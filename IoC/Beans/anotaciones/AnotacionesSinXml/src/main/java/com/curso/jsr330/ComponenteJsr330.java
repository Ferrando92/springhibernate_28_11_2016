/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.jsr330;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author usuario
 */
@Named
public class ComponenteJsr330 {

    @Inject
    private Inyectable inyectable;

    public ComponenteJsr330() {
        System.out.println("En el constructor de " + getClass().getName());
    }

    @Override
    public String toString() {
        return "ComponenteJsr330{" + "inyectable=" + inyectable + '}';
    }

}
