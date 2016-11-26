/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Usuario;
import java.util.List;
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

    private SessionFactory sessionFactoryUno;
    private SessionFactory sessionFactoryDos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicializarHibernate();
        p.crearUsuario(p.sessionFactoryUno);
        System.out.println("Usuarios de sessionFactoryUno");
        p.mostrarUsuarios(p.sessionFactoryUno);
        p.crearUsuario(p.sessionFactoryDos);
        System.out.println("Usuarios de sessionFactoryDos");
        p.mostrarUsuarios(p.sessionFactoryDos);
    }

    private void crearUsuario(SessionFactory sf) {
        Session session = null;
        try {
            session = sf.getCurrentSession();
            session.getTransaction().begin();
            Long t = System.currentTimeMillis();
            session.persist(new Usuario("Uno" + t, "clave uno" + t));
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            System.out.println("En crearUsuario");
            if (session == null || session.isOpen()) {
                System.out.println("La sesión no se ha cerrado automáticamente");
            } else {
                System.out.println("La sesión se ha cerrado automáticamente");
            }
        }
    }

    private void mostrarUsuarios(SessionFactory sf) {
        Session session = null;
        try {
            session = sf.getCurrentSession();
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
        } finally {
            System.out.println("En mostrarUsuarios");
            if (session == null || session.isOpen()) {
                System.out.println("La sesión no se ha cerrado automáticamente");
            } else {
                System.out.println("La sesión se ha cerrado automáticamente");
            }
        }
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactoryUno = HibernateUtil.getSessionFactoryUno();
        sessionFactoryDos = HibernateUtil.getSessionFactoryDos();
    }
}
