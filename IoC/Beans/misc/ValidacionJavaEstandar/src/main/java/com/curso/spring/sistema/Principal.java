/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.sistema;

import com.curso.spring.beans.Persona;
import com.curso.spring.config.Configuracion;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        principal.obtenerBean();
    }

    private void cargarContexto() {
        ctx = new AnnotationConfigApplicationContext(Configuracion.class);
        System.out.println("Contexto cargado");
    }

    private void obtenerBean() {
        Persona persona = ctx.getBean(Persona.class);
        System.out.println("Encontrado: " + persona);
        Validator validator = ctx.getBean(Validator.class);
        Set<ConstraintViolation<Persona>> s = validator.validate(persona);
        for (ConstraintViolation<Persona> c : s) {
            System.out.println(c.getMessage());
        }
        persona.setNombre("0123456789");
        s = validator.validate(persona);
        for (ConstraintViolation<Persona> c : s) {
            System.out.println(c.getMessage());
        }
    }
}
