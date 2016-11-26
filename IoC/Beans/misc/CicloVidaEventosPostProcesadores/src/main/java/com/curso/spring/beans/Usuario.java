/*
 * Usuario.java
 *
 * Created on 1 de junio de 2007, 13:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.spring.beans;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Usuario implements Serializable {

    private String nombre;
    private String clave;
    private Integer edad;

    /**
     * Métodos de factoría
     * @return 
     */
    public static Usuario crearUsuario() {
        return new Usuario();
    }

    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
        nombre = "Sin definir";
        clave = "Sin definir";
        edad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getNombre();
    }
}
