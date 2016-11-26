/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.persistencia.registrousuarios.utilidades;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author usuario
 */
public class HibernateUtil {

    private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getName());

    private static final SessionFactory sessionFactory = getSf();

    private static SessionFactory getSf() {
        try {
            Configuration conf = new Configuration().configure();
            ServiceRegistry s = new StandardServiceRegistryBuilder().
                    applySettings(conf.getProperties()).build();
            return conf.buildSessionFactory(s);
        } catch (HibernateException ex) {
            LOG.log(Level.SEVERE, ex.toString());
            return null;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}
