/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.componentes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

/**
 *
 * @author usuario
 */
@Controller
@Lazy(true)
public class Controlador {

    public Controlador() {
        System.out.println("En el constructor de " + getClass().getName());
    }
    
}
