/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.unidireccional.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;

/**
 *
 * @author jose maria
 */
@Entity
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
//    @OneToMany
// Si queremos usar una tabla intermedia que almacene las claves de ambas
//    @JoinTable(name = "tabla_factura_item",
//    joinColumns =
//    @JoinColumn(name = "factura_fk"),
//    inverseJoinColumns =
//    @JoinColumn(name = "factura_item_fk"))
// Si queremos usar claves extranjeras
//    @JoinColumn(name = "factura_item_fk")
    @OrderBy("fechaAdicion desc")
// También podría usarse @OrderColumn, pero no ambas
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.relaciones.unidireccional.onetomany.Factura[id=" + id + "]";
    }
}
