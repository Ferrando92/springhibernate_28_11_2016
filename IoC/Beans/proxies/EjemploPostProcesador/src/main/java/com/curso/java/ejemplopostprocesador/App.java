package com.curso.java.ejemplopostprocesador;

import com.curso.java.modelo.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.curso.java");
        System.out.println("Contexto cargado");
        Persona p = ctx.getBean(Persona.class);
        System.out.println(p.getClass().getName());
        System.out.println(p.getNombre());
        p.setNombre("Nuevo nombre");
    }
}
