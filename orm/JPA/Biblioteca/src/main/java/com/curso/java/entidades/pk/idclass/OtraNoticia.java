/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.pk.idclass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;

/**
 *
 * @author jose maria
 */
@Entity
@IdClass(OtraNoticiaId.class)
public class OtraNoticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String titulo;
    @Id
    private String lenguaje;
    @Lob
    private String cuerpo;

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

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OtraNoticia other = (OtraNoticia) obj;
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        if ((this.lenguaje == null) ? (other.lenguaje != null) : !this.lenguaje.equals(other.lenguaje)) {
            return false;
        }
        return !((this.cuerpo == null) ? (other.cuerpo != null) : !this.cuerpo.equals(other.cuerpo));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 11 * hash + (this.lenguaje != null ? this.lenguaje.hashCode() : 0);
        hash = 11 * hash + (this.cuerpo != null ? this.cuerpo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "entidades.pk.idclass.Noticia[id=" + titulo + "," + lenguaje + "]";
    }
}
