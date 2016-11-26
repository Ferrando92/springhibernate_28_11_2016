/*
 * Main.java
 * 
 * Created on 25-sep-2007, 11:01:34
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.beansanonimos;

import com.curso.spring.beans.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("recursos/applicationContext.xml");
        System.out.println("Contexto cargado");
        String[] nombres = ctx.getBeanDefinitionNames();
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        Persona persona = (Persona) ctx.getBean("com.curso.spring.beans.Persona");
        System.out.println(persona.getNombre());
        Persona persona1 = (Persona) ctx.getBean("com.curso.spring.beans.Persona#1");
        System.out.println(persona1.getNombre());
    }

}
