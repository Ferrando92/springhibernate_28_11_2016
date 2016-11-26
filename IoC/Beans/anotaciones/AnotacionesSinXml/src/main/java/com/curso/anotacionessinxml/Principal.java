/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.anotacionessinxml;

import com.curso.beans.Persona;
import com.curso.componentes.Componente;
import com.curso.config.Configuracion;
import com.curso.config.ConfiguracionJsr330;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author usuario
 */
public class Principal {

    private ApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.init();
    }

    private void init() {
        ctx = new AnnotationConfigApplicationContext(Configuracion.class,ConfiguracionJsr330.class);
        ((AbstractApplicationContext) ctx).registerShutdownHook();
        System.out.println("Contexto cargado");
        System.out.println(ctx.getBean(Componente.class));
        System.out.println(ctx.getBean(Persona.class));
        System.out.println(ctx.getBean(Persona.class));
    }
}
