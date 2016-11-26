/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.herencia.mappedsuperclass;

import javax.persistence.Entity;

/**
 *
 * @author jose maria
 */
@Entity
public class Circulo extends Figura {

    private static final long serialVersionUID = 1L;
    private Double radio;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "entidades.relaciones.herencia.mappedsuperclass.Circulo[id=" + getId() + "]";
    }
}
