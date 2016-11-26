/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.modelo;

import java.io.Serializable;

/**
 *
 * @author Chema
 */
public class Aficion implements Serializable {

    private Long id;
    private String nombre;
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Aficion{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
