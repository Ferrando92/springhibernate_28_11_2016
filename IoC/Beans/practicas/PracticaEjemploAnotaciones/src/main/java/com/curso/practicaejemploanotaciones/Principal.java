/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaejemploanotaciones;

import com.curso.practicaejemploanotaciones.modelo.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        new Principal().cargarSpring().mostrarPersona();
        
    }
    private Principal cargarSpring(){
        ctx = new ClassPathXmlApplicationContext("app.xml");
        return this;
    }
    private Principal mostrarPersona(){
        System.out.println(ctx.getBean(Persona.class));
        return this;
    }
}
