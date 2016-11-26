/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.sistema;

import com.curso.spring.beans.GestorOxm;
import com.curso.spring.beans.Persona;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class Principal {

    private ApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.cargarContexto();
        principal.guardarPersona();
        principal.cargarPersona();
    }

    private void cargarContexto() {
        ctx = new ClassPathXmlApplicationContext("recursos//applicationContext.xml");
        System.out.println("Contexto cargado");
    }

    private void guardarPersona() {
        Persona persona = ctx.getBean(Persona.class);
        persona.setFecha(new Date());
        GestorOxm gestorOxm = ctx.getBean(GestorOxm.class);
        gestorOxm.guardarPersona(persona);
        System.out.format("Persona guardada.Nombre:%s.Fecha:%s.\n", persona.getNombre(), persona.getFecha());
    }

    private void cargarPersona() {
        GestorOxm gestorOxm = ctx.getBean(GestorOxm.class);
        Persona persona = gestorOxm.cargarPersona();
        System.out.format("Persona Cargada.Nombre:%s.Fecha:%s.\n", persona.getNombre(), persona.getFecha());
    }
}
