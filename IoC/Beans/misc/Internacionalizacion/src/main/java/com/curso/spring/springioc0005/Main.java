/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.springioc0005;

import java.util.Date;
import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("recursos/applicationContext.xml");
        System.out.println("Contexto cargado");
        MessageSource fuente = ctx;
        String mensajeUnoEs = fuente.getMessage("m1", null, Locale.getDefault());
        String mensajeDosES = fuente.getMessage("m2", new Object[]{new Date(), new Date()}, new Locale("es", "ES"));
        String mensajeUnoEn = fuente.getMessage("m1", null, new Locale("en", "GB"));
        String mensajeDosEn = fuente.getMessage("m2", new Object[]{new Date(), new Date()}, new Locale("en", "GB"));
        System.out.println("Mensajes en castellano");
        System.out.println(String.format("Mensaje número uno: %s\n", mensajeUnoEs));
        System.out.println(String.format("Mensaje número dos: %s\n", mensajeDosES));
        System.out.println("Mensajes en inglés");
        System.out.println(String.format("Mensaje número uno: %s\n", mensajeUnoEn));
        System.out.println(String.format("Mensaje número dos: %s\n", mensajeDosEn));
    }
}
