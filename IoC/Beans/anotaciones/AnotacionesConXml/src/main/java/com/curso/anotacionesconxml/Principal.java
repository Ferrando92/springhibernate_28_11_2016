/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.anotacionesconxml;

import com.curso.componentes.Componente;
import com.curso.componentes.Controlador;
import com.curso.componentes.Repositorio;
import com.curso.componentes.Servicio;
import com.curso.filtros.ClaseFiltrada;
import com.curso.jsr330.ComponenteJsr330;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author usuario
 */
public class Principal {

    private ApplicationContext ctx;
    private static final Logger LOG = LoggerFactory.getLogger(Principal.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.init();
        p.componentes();
        p.filtros();
        p.jsr330();
    }

    private void init() {
        ctx = new ClassPathXmlApplicationContext("*.xml");
        ((AbstractApplicationContext)ctx).registerShutdownHook();
        LOG.info("Contexto cargado");        
    }

    private void componentes() {
        System.out.println(ctx.getBean(Componente.class));
        System.out.println(ctx.getBean(Servicio.class));
        System.out.println(ctx.getBean(Repositorio.class));
        System.out.println(ctx.getBean(Controlador.class));
    }

    private void filtros() {
        System.out.println(ctx.getBean(ClaseFiltrada.class));
    }

    private void jsr330() {
        System.out.println(ctx.getBean(ComponenteJsr330.class));
    }
}
