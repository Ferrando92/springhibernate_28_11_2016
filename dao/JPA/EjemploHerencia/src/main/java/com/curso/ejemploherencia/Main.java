/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploherencia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servicios.TestHerencia;

/**
 *
 * @author Chema
 */
public class Main {
private ApplicationContext ctx;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.initSpring();
        m.test();
    }

    private void initSpring() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Contexto Cargado");
    }

    private void test() {
        TestHerencia t = (TestHerencia) ctx.getBean("testHerencia");
        t.test();
    }

}
