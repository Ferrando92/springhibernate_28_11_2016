/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.herencia.estandar;

import javax.persistence.Entity;

/**
 *
 * @author jose maria
 */
@Entity
public class Descendiente extends Ancestro {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "entidades.relaciones.herencia.estandar.Descendiente[id=" + getId() + "]";
    }
}
