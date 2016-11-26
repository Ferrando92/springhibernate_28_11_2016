/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.callbacks.events;

import java.io.Serializable;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jose maria
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String telefono = "+341911234567";
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento = new Date();
    @Transient
    private Integer edad;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaCreacion() {
        return new Date(fechaCreacion.getTime());
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = new Date(fechaCreacion.getTime());
    }

    public Date getFechaNacimiento() {
        return new Date(fechaNacimiento.getTime());
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @PrePersist
    @PreUpdate
    private void validar() {
        if (fechaNacimiento.getTime() > new Date().getTime()) {
            throw new IllegalArgumentException("La fecha de nacimiento no es válida");
        }
        if (!telefono.startsWith("+")) {
            throw new IllegalArgumentException("El número de teléfono no es válido");
        }
    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calcularEdad() {
        if (fechaNacimiento == null) {
            edad = null;
            return;
        }
        Calendar fecha = new GregorianCalendar();
        fecha.setTime(fechaNacimiento);
        Calendar hoy = new GregorianCalendar();
        hoy.setTime(new Date());
        int ajuste = 0;
        if (hoy.get(DAY_OF_YEAR) - fecha.get(DAY_OF_YEAR) < 0) {
            ajuste = -1;
        }
        edad = hoy.get(YEAR) - fecha.get(YEAR) + ajuste;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entidades.events.Customer[id=" + id + "]";
    }
}
