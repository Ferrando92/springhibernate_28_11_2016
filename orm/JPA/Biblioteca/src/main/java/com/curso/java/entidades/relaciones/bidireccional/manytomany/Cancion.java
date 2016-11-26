/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.bidireccional.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author jose maria
 */
@Entity
public class Cancion implements Serializable {

    @ManyToMany(mappedBy = "canciones")
    private List<Cantante> cantantes = new ArrayList<Cantante>();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    public List<Cantante> getCantantes() {
        return cantantes;
    }

    public void setCantantes(List<Cantante> cantantes) {
        this.cantantes = cantantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.relaciones.bidireccional.manytomany.Cancion[id=" + id + "]";
    }
}
