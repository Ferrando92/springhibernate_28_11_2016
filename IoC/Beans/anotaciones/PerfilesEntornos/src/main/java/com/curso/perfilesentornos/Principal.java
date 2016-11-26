/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.perfilesentornos;

import com.curso.beans.Persona;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author usuario
 */
public class Principal {

    private AnnotationConfigApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.init();
        p.testPerfiles();
    }

    private void init() {
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("produccion");
        ctx.scan("com.curso.config");
        ctx.refresh();
        System.out.println("Contexto cargado");
    }

    private void testPerfiles() {
        Arrays.asList(ctx.getEnvironment().getActiveProfiles()).forEach(System.out::println);
        System.out.println(ctx.getBean(Persona.class));
    }
}
