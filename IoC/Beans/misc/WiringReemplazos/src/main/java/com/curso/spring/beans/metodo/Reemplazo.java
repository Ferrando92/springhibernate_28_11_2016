package com.curso.spring.beans.metodo;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Reemplazo implements MethodReplacer {
    public Reemplazo() {
    }

    @Override
    public Object reimplement(Object object, Method method, 
                              Object[] object1) throws Throwable {
        System.out.println("Ejecutando desde una clase distinta: " + getClass().getName());
        return null;
    }
}
