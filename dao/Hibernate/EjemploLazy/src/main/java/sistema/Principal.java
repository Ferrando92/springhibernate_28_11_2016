/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Rol;
import beans.Usuario;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        p.inicializarHibernate();
        Usuario u = p.crearUsuario();
        p.tests(u);
        p.mostrarUsuarios();
        final String consultaNoLazy = "select distinct u from Usuario as u join fetch u.roles";
        p.mostrarUsuarios(consultaNoLazy);
        final String consultaLazy = "from Usuario";
        p.mostrarUsuarios(consultaLazy);
    }

    private Usuario crearUsuario() {
        Session session = null;
        Usuario usuario = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            usuario = new Usuario("Uno", "clave uno");
            for (int i = 0; i < 5; i++) {
                Rol rol = new Rol("Rol " + i);
                usuario.getRoles().add(rol);
                rol.setUsuario(usuario);
            }
            session.persist(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        }
        return usuario;
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
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        }
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private void mostrarUsuarios(String consulta) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Query query = session.createQuery(consulta);
            List<Usuario> usuarios = query.list();
            session.getTransaction().commit();
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios que mostrar");
            } else {
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                }
            }
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        }
    }

    private void tests(Usuario u) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Long id = u.getId();
            Usuario otro = (Usuario) session.load(Usuario.class, id);
            System.out.println("La clase del objeto devuelto por load es " + otro.getClass().getName());
            Set<Rol> roles = otro.getRoles();
            System.out.println("La clase del objeto devuelto por getRoles es " + roles.getClass().getName());          
            session.getTransaction().commit();            
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        }
    }
}
