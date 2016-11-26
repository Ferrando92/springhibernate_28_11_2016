/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.post;

import com.curso.java.modelo.PersonaProxy;
import com.curso.java.modelo.PersonaReal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component
public class PostProcesador implements BeanPostProcessor {

    private static final Logger LOG = Logger.getLogger(PostProcesador.class.getName());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOG.log(Level.INFO, "Antes: {0}", bean.getClass().getName());
        if (bean instanceof PersonaReal) {
            PersonaProxy p = new PersonaProxy();
            p.setPersonaReal((PersonaReal) bean);
            return p;
        } else {
            return bean;
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOG.log(Level.INFO, "Despu\u00e9s: {0}", bean.getClass().getName());
        return bean;
    }
}
