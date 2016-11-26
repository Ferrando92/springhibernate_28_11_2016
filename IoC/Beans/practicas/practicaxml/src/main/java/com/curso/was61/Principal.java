package com.curso.was61;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Persona;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		System.out.println("Contexto cargado");
		Persona p = ctx.getBean(Persona.class);
		System.out.println(p);
	}

}
