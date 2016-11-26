/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.modelo;

import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component
public class PersonaReal implements Persona {

    private String nombre;

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
