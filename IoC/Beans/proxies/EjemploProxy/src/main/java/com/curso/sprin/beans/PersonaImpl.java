/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.sprin.beans;

/**
 *
 * @author Alejandra
 */
public class PersonaImpl implements Persona {

    private String nombre = "Un nombre cualquiera";

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
