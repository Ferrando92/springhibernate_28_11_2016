/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.configuracion;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component
public class Configuracion {

    @Bean(name = "transactionManager", autowire = Autowire.BY_TYPE)
    JpaTransactionManager getJpaTx() {
        return new JpaTransactionManager();
    }

    @Bean
    LocalEntityManagerFactoryBean getEmf() {
        LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
        bean.setPersistenceUnitName("SpringJpaWebPU");
        return bean;
    }

    @Bean
    PersistenceAnnotationBeanPostProcessor getPa() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor getPe() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
