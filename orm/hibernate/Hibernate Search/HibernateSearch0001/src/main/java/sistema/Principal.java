/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Usuario;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;
import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import util.HibernateHook;
import util.HibernateUtil;

/**
 *
 * @author Chema
 */
public class Principal {

    private SessionFactory sessionFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.validarUsuario();
        p.inicializarHibernate();
        p.crearUsuarios(10000);
        p.indexarUsuarios();
        p.buscarUsuariosConAficion("montañismo");
//        p.mostrarUsuarios();
    }

    private void buscarUsuariosConAficion(String aficion) {
        Session session = null;
        FullTextSession fts = null;
        try {
            System.out.println("Buscando usuarios aficionados al " + aficion);
            long a = System.currentTimeMillis();
            session = sessionFactory.getCurrentSession();
            fts = Search.getFullTextSession(session);
            fts.getTransaction().begin();
            MultiFieldQueryParser parser = new MultiFieldQueryParser(Version.LUCENE_35,new String[]{"aficiones"},
                    new StandardAnalyzer(Version.LUCENE_35));
            org.apache.lucene.search.Query query = parser.parse(aficion);
            org.hibernate.Query hibQuery = fts.createFullTextQuery(query, Usuario.class);
            List<Usuario> usuarios = hibQuery.list();
            System.out.format("Encontrados %d usuarios aficionados al %s%n", usuarios.size(), aficion);
            fts.getTransaction().commit();
            long b = System.currentTimeMillis();
            System.out.println("Fin de la transacción. Tiempo empleado en milisegundos " + (b - a));
        } catch (ParseException ex) {
            fts.getTransaction().rollback();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HibernateException hibernateException) {
            fts.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void crearUsuarios(Integer cuantos) {
        Session session = null;
        Usuario usuario = null;
        System.out.format("Creando %d usuarios%n", cuantos);
        try {
            long a = System.currentTimeMillis();
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            for (int i = 0; i < cuantos; i++) {
                usuario = new Usuario("Uno" + i, "clave " + i, "abcd" + i);
                usuario.setCorreo("xyz@abc.com");
                if (i % 10 == 0) {
                    usuario.setAficiones("fútbol, baloncesto, tenis, natación");
                } else {
                    usuario.setAficiones("fútbol, baloncesto, tenis, montañismo");
                }
                session.save(usuario);
                if (i % 40 == 0) {
                    session.flush();
                    session.clear();
                    System.out.println("Usuarios insertados " + i);
                }
            }
            long b = System.currentTimeMillis();
            System.out.println("Fin de la inserción. Tiempo empleado en milisegundos " + (b - a));
            session.getTransaction().commit();
            b = System.currentTimeMillis();
            System.out.println("Fin de la transacción. Tiempo (inserción + commit) empleado en milisegundos " + (b - a));
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void indexarUsuarios() {
        Session session = null;
        FullTextSession fts = null;
        int contador = 0;
        try {
            System.out.println("Comenzando la construcción del índice...");
            long a = System.currentTimeMillis();
            session = sessionFactory.getCurrentSession();
            fts = Search.getFullTextSession(session);
            fts.getTransaction().begin();
//            List<Usuario> usuarios = session.createQuery("from Usuario").setCacheMode(CacheMode.IGNORE).list();
//            for (Usuario usuario : usuarios) {
//                fts.index(usuario);
//                if (++contador % 100 == 0) {
//                    System.out.println("Usuarios indexados " + contador);
//                }
//            }
            ScrollableResults usuarios = session.createQuery("from Usuario").setCacheMode(CacheMode.IGNORE).scroll();
            while (usuarios.next()) {
                Usuario u = (Usuario) usuarios.get(0);
                fts.index(u);
                session.evict(u);
                if (++contador % 100 == 0) {
                    System.out.println("Usuarios indexados " + contador);
                }
            }
            fts.getTransaction().commit();
            long b = System.currentTimeMillis();
            System.out.println("Fin de la transacción. Tiempo empleado en milisegundos " + (b - a));
            System.out.format("Indexados %d usuarios%n", contador);
        } catch (HibernateException hibernateException) {
            fts.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void mostrarUsuarios() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from Usuario");
            List<Usuario> usuarios = query.list();
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios que mostrar");
            } else {
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private void validarUsuario() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Usuario usuario = new Usuario();
        Set<ConstraintViolation<Usuario>> errores = validator.validate(usuario);
        for (ConstraintViolation<Usuario> error : errores) {
            System.out.format("Error: %s. Mensaje: %s.%n", error.getInvalidValue(), error.getMessage());
        }

        usuario = new Usuario("uno", "dos", "abc");
        usuario.setCorreo("xyz");
        errores = validator.validate(usuario);
        for (ConstraintViolation<Usuario> error : errores) {
            System.out.format("Error: %s. Mensaje: %s.%n", error.getInvalidValue(), error.getMessage());
        }
    }
}
