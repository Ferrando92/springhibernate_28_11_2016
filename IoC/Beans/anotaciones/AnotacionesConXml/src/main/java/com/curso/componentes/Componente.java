/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.componentes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class Componente {
    @Resource
    private String nombre;

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @PostConstruct
    public void antes(){
        System.out.println("En método antes de la clase " + getClass().getName());
    }
    @PreDestroy
    public void despues(){
        System.out.println("En método despues de la clase " + getClass().getName());
    }

    @Override
    public String toString() {
        return "Componente{" + "nombre=" + nombre + '}';
    }
}
