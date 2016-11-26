/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.componentes;

import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component("nombreEscogido")
public class Dependencia {

    public Dependencia() {
        System.out.println("En el constructor de " + getClass().getName());
    }

    @PreDestroy
    public void despues() {
        System.out.println("En método despues de la clase " + getClass().getName());
    }
}
