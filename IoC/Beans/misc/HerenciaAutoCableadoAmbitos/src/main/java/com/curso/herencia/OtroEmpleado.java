/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.herencia;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class OtroEmpleado implements Serializable{
    
    private String nombre;

    private Double sueldo;

    /**
     * Get the value of sueldo
     *
     * @return the value of sueldo
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * Set the value of sueldo
     *
     * @param sueldo new value of sueldo
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

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

    @Override
    public String toString() {
        return "OtroEmpleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }

}
