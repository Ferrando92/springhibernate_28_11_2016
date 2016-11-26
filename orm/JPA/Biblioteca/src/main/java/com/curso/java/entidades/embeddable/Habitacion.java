/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.embeddable;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jose maria
 */
@Embeddable
//Conveniente si se va a embeber en más de una entidad, ya que el objeto embebido
//obtiene por defecto el tipo de acceso de la entidad en la que se le declara.
//Dos entidades con un tipo de acceso distinto y el mismo embebido podrían producir errores.
@Access(AccessType.PROPERTY)
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private String descripcion;

    @Column(name = "habitacion_descripcion", length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
