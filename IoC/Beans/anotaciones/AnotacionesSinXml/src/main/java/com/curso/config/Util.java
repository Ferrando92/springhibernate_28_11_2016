/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.config;

/**
 *
 * @author usuario
 */
public interface Util {
    default void log(){
        System.out.println("En el constructor de " + this.getClass().getName());
    }
}
