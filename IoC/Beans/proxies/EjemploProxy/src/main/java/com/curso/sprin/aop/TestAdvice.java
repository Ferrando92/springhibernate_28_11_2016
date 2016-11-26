/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.sprin.aop;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author Alejandra
 */
public class TestAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Advice invocado en " + target.getClass());
    }

}
