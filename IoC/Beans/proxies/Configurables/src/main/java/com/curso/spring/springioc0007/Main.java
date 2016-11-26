/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.springioc0007;

import com.curso.spring.beans.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author user
 */
public class Main {

    private ApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        m.test();
    }

    private void init() {
        ctx = new ClassPathXmlApplicationContext("recursos/applicationContext.xml");
        System.out.println("Contexto cargado");
    }

    private void test() {
        Test test = new Test();
        System.out.println("El servicio es " + test.getTestServicio());
        System.out.println("El nombre es " + test.getNombre());
        Test test1 = new Test();
        System.out.println("El servicio es " + test1.getTestServicio());
    }
}
