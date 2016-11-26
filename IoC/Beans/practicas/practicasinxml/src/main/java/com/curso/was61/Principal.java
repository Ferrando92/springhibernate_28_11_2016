package com.curso.was61;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.Configuracion;
import beans.Persona;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
		System.out.println("Contexto cargado");
		Persona p = ctx.getBean(Persona.class);
		System.out.println(p);
	}

}
