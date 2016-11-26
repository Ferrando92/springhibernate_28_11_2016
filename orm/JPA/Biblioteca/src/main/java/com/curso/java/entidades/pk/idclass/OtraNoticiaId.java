/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.pk.idclass;

import java.io.Serializable;

/**
 *
 * @author jose maria
 */
public class OtraNoticiaId implements Serializable {

    private static final long serialVersionUID = 1L;
    private String titulo;
    private String lenguaje;

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OtraNoticiaId other = (OtraNoticiaId) obj;
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        return !((this.lenguaje == null) ? (other.lenguaje != null) : !this.lenguaje.equals(other.lenguaje));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 41 * hash + (this.lenguaje != null ? this.lenguaje.hashCode() : 0);
        return hash;
    }
}
