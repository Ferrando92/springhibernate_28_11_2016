/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.persistencia.registrousuarios.listeners;

import com.plan.persistencia.registrousuarios.daos.UsuarioDao;
import com.plan.persistencia.registrousuarios.utilidades.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;

/**
 * Web application lifecycle listener.
 *
 * @author usuario
 */
public class HibernateServletListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(HibernateServletListener.class.getName());
    private SessionFactory emf;
    private UsuarioDao dao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = HibernateUtil.getSessionFactory();
        LOG.log(Level.INFO, "SessionFactory Creada");
        sce.getServletContext().setAttribute("emf", emf);
        dao = new UsuarioDao(emf);
        LOG.log(Level.INFO, "Dao Creado");
        sce.getServletContext().setAttribute("dao", dao);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
        LOG.log(Level.INFO, "Dao igual a null");
        emf.close();
        LOG.log(Level.INFO, "SessionFactory Eliminada");
    }
}
