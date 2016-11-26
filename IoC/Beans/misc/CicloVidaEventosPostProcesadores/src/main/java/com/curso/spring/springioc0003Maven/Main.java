/*
 * Main.java
 *
 * Created on 19 de junio de 2007, 14:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.spring.springioc0003Maven;

import com.curso.spring.ciclovida.FactoriaUsuarioBean;
import com.curso.spring.eventos.DemoBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class Main {

    private ApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.cargarContexto();
        m.provocarEvento();
        m.probarFactoria();
    }

    private void cargarContexto() {
        ctx = new ClassPathXmlApplicationContext("app.xml");
        System.out.println("Contexto cargado");
        ((AbstractApplicationContext) ctx).registerShutdownHook();
    }

    private void probarFactoria() {
        FactoriaUsuarioBean factoriaUsuarioBean = ctx.getBean(FactoriaUsuarioBean.class);
        System.out.format("Primer usuario:%s%n", factoriaUsuarioBean.getNuevoUsuario());
        System.out.format("Segundo usuario:%s%n", factoriaUsuarioBean.getNuevoUsuario());
    }

    private void provocarEvento() {
        DemoBean demoBean = ctx.getBean(DemoBean.class);
        demoBean.generarEvento();
    }

}
