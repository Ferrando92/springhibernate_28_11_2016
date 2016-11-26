/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.pk.embeddable;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 *
 * @author jose maria
 */
@Entity
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private NoticiaId id;
    @Lob
    private String cuerpo;

    public NoticiaId getId() {
        return id;
    }

    public void setId(NoticiaId id) {
        this.id = id;
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
        final Noticia other = (Noticia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return !((this.cuerpo == null) ? (other.cuerpo != null) : !this.cuerpo.equals(other.cuerpo));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.cuerpo != null ? this.cuerpo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "entidades.pk.embeddable.Noticia[id=" + id + "]";
    }
}
