/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author Chema
 */
@Configuration
public class Configuracion {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    /**
     *
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager obtenerGestorTransacciones() {
        HibernateTransactionManager h = new HibernateTransactionManager();
        h.setSessionFactory(sessionFactory);
        return h;
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor getPe() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
