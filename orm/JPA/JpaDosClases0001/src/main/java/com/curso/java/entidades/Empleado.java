/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades;

import java.io.Serializable;

/**
 *
 * @author jose maria
 */
public class Empleado implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
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
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

}
