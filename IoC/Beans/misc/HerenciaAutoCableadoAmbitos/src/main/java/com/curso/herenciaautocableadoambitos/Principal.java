/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.herenciaautocableadoambitos;

import com.curso.herencia.Empleado;
import com.curso.herencia.OtroEmpleado;
import com.curso.ambito.Prototipo;
import com.curso.cableado.CableadoPorConstructor;
import com.curso.cableado.Contenedor;
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
        Principal p = new Principal();
        p.init();
        p.herencia();
        p.ambito();
        p.cableado();
    }

    private void init() {
        ctx = new ClassPathXmlApplicationContext("herencia.xml", "proto.xml","cableado.xml");
        System.out.println("Contexto cargado");
    }

    private void herencia() {
        System.out.println(ctx.getBean("usoConcreto", Empleado.class));
        System.out.println(ctx.getBean(OtroEmpleado.class));
        System.out.println(ctx.getBean("usoAbstracto", Empleado.class));
    }

    private void ambito() {
        System.out.println(ctx.getBean(Prototipo.class));
        System.out.println(ctx.getBean(Prototipo.class));
    }

    private void cableado() {
        System.out.println(ctx.getBean("contenedor1",Contenedor.class));
        System.out.println(ctx.getBean("contenedor2",Contenedor.class));
        System.out.println(ctx.getBean(CableadoPorConstructor.class));
    }

}
