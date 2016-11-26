/*
 * DemoEvento.java
 *
 * Created on 19 de junio de 2007, 15:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.spring.eventos;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Administrador
 */
public class DemoEvento extends ApplicationEvent {

    /**
     * Creates a new instance of DemoEvento
     * @param origen
     */
    public DemoEvento(Object origen) {
        super(origen);
    }

}
