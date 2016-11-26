/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.herencia;

/**
 *
 * @author usuario
 */
public class Empleado extends Persona{
    
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

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "sueldo=" + sueldo + '}';
    }

}
