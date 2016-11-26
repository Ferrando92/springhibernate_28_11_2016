/*
 * DemoBean.java
 *
 * Created on 19 de junio de 2007, 15:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.spring.eventos;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author Administrador
 */
public class DemoBean implements ApplicationContextAware {

    private ApplicationContext ctx;

    /**
     * Creates a new instance of DemoBean
     */
    public DemoBean() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
        System.out.println("Contexto recibido");
    }

    public void generarEvento() {
        ctx.publishEvent(new DemoEvento(this));
    }
}
