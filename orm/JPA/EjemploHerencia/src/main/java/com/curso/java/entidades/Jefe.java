/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades;

import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author Administrador
 */
@Entity
public class Jefe extends Empleado {

    private static final long serialVersionUID = 1L;
    private Double incentivos;

    public Jefe() {
    }

    public Jefe(Long id) {
        super(id);
    }

    public Double getIncentivos() {
        return incentivos;
    }

    public void setIncentivos(Double incentivos) {
        this.incentivos = incentivos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.incentivos);
        return super.hashCode() + hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jefe other = (Jefe) obj;
        if (!Objects.equals(this.incentivos, other.incentivos)) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + getId() + "]";
    }
}
