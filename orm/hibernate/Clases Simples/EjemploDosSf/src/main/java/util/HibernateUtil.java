/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Chema
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactoryUno;
    private static final SessionFactory sessionFactoryDos;

    static {
        sessionFactoryUno = crearSesionFactory("recursos/sesionuno.cfg.xml");
        sessionFactoryDos = crearSesionFactory("recursos/sesiondos.xml");

    }

    public static SessionFactory getSessionFactoryUno() {
        return sessionFactoryUno;
    }

    public static SessionFactory getSessionFactoryDos() {
        return sessionFactoryDos;
    }

    private static SessionFactory crearSesionFactory(String recurso) throws ExceptionInInitializerError {
        SessionFactory sf = null;
        try {
            // Crear la factoría de sesiones definida por el parámetro 'recurso'
            Configuration conf = new Configuration().configure(recurso);
            ServiceRegistry s = new ServiceRegistryBuilder().applySettings(
                    conf.getProperties()).buildServiceRegistry();
            sf = conf.buildSessionFactory(s);
            System.out.format("Factoría de sesiones %s creada.\n", recurso);
            return sf;
        } catch (Throwable ex) {
            System.err.println("La creación de la factoría de sesiones ha fallado." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
