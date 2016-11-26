/*
 * Main.java
 * 
 * Created on 25-sep-2007, 11:01:34
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.springvalidacion;

import com.curso.spring.beans.TestBean;
import com.curso.spring.beans.TestBeanValidator;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("recursos/applicationContext.xml");
        System.out.println("Contexto cargado");
        TestBean test = ctx.getBean(TestBean.class);
        TestBeanValidator testValidator = ctx.getBean(TestBeanValidator.class);
        Errors e = new BeanPropertyBindingResult(test, "testBean");
        testValidator.validate(test, e);
        System.out.println("Validación concluida ");
        List<FieldError> lista = e.getFieldErrors();
        lista.forEach(System.out::println);
    }

}
