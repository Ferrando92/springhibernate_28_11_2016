/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.jsr330;

import javax.inject.Named;

/**
 *
 * @author usuario
 */
@Named
public class Inyectable {

    public Inyectable() {
        System.out.println("En el constructor de " + getClass().getName());
    }
    
}
