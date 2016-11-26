package com.plan.spring.ejemploanotaciones;

import com.plan.spring.ejemploanotaciones.beans.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        System.out.println("Contexto cargado");
        Persona p = ctx.getBean(Persona.class);
        assert p != null : "No se encuentra la persona";
        System.out.println(p);
    }
}
