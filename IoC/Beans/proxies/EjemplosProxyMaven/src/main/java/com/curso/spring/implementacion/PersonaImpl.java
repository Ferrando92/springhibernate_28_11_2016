/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.implementacion;

import com.curso.spring.especificacion.Persona;

/**
 *
 * @author jose maria
 */
public class PersonaImpl implements Persona {

    private String nombre;

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
