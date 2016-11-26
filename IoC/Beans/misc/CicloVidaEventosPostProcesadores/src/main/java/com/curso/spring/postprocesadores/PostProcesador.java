/*
 * PostProcesador.java
 *
 * Created on 19 de junio de 2007, 14:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.spring.postprocesadores;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author Administrador
 */
public class PostProcesador implements BeanPostProcessor {

    /**
     * Creates a new instance of PostProcesador
     */
    public PostProcesador() {
    }

    @Override
    public Object postProcessBeforeInitialization(Object object, String string) throws BeansException {
        System.out.printf("En postProcessBeforeInitialization.Bean %s. Se llama %s\n", object, string);
        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String string) throws BeansException {
        System.out.printf("En postProcessAfterInitialization.Bean %s. Se llama %s\n", object, string);
        return object;
    }

}
