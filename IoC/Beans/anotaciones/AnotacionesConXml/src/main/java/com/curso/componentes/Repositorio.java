/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.componentes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
@Scope(value = "prototype")
public class Repositorio {

    public Repositorio() {
         System.out.println("En el constructor de " + getClass().getName());
    }
    
}
