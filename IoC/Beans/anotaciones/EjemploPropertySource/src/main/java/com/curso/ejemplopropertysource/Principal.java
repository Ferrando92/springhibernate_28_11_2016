/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplopropertysource;

import com.curso.ejemplopropertysource.config.Configuracion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
        System.out.println("Contexto cargado");
        Configuracion c = ctx.getBean(Configuracion.class);
        System.out.println(c.obtenerPropiedad());
    }
    
}
