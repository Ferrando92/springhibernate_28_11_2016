/*
 * Main.java
 * 
 * Created on 25-sep-2007, 11:01:34
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.sprin.ejemploproxy;

import com.curso.sprin.aop.TestAdvice;
import com.curso.sprin.beans.Persona;
import com.curso.sprin.beans.PersonaImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProxyFactory factoria = new ProxyFactory(new PersonaImpl());
        factoria.addInterface(Persona.class);
        factoria.addAdvice(new TestAdvice());
        Object obj = factoria.getProxy();
        System.out.println("Clase del proxy: " + obj.getClass());
        Persona p = (Persona) obj;
        System.out.println("El nombre de la persona es " + p.getNombre());
    }

}
