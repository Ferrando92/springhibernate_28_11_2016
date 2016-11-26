/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.cableado;

import java.util.Arrays;

/**
 *
 * @author usuario
 */
public class CableadoPorConstructor {

    public CableadoPorConstructor(String... argumentos) {
        System.out.println("En el constructor");
        Arrays.asList(argumentos).forEach(System.out::println);
    }
    
}
