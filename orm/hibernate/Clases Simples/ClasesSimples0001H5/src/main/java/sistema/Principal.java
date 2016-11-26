/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Usuario;
import static java.lang.System.out;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
        Usuario usuario = p.crearUsuario();
        p.mostrarUsuarios();
        p.actualizarUsuario(usuario.getId());
        p.mostrarUsuarios();
        p.borrarUsuario(usuario.getId());
        p.mostrarUsuarios();
        p.cerrar();
    }

    private void actualizarUsuario(Long id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            usuario.setNombre("Nombre actualizado");
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void borrarUsuario(Long id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private Usuario crearUsuario() {
        Session session = null;
        Usuario usuario = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            usuario = new Usuario("Uno", "clave uno");
            session.persist(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }

    private void mostrarUsuarios() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Query<Usuario> query = session.createQuery("from Usuario");
            List<Usuario> usuarios = query.list();
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios que mostrar");
            } else {
                usuarios.forEach(out::println);
            }
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void inicializarHibernate() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private void cerrar() {
        sessionFactory.close();
        System.out.println("Factoría de sesiones cerrada");
    }
}
