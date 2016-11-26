/*
 * DemoListener.java
 *
 * Created on 19 de junio de 2007, 15:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.spring.eventos;

import org.springframework.context.ApplicationListener;

/**
 *
 * @author Administrador
 */
public class DemoListener implements ApplicationListener<DemoEvento> {

    /**
     * Creates a new instance of DemoListener
     */
    public DemoListener() {
    }

    @Override
    public void onApplicationEvent(DemoEvento event) {
        System.out.println("Capturado el evento " + event.getClass().getName());
    }

}
