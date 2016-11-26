/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jose maria
 */
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "select p from Persona p")})
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String curriculum;
    private Date fechaNacimiento = new Date();
    private Date fechaCreacion = new Date();
    private Genero genero = Genero.FEMENINO;

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "t_genero")
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Transient
    public Integer getEdad() {
        return 0;
    }

    @Temporal(value = TemporalType.DATE)
    public Date getFechaNacimiento() {
        return new Date(fechaNacimiento.getTime());
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getFechaCreacion() {
        return new Date(fechaCreacion.getTime());
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = new Date(fechaCreacion.getTime());
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    @Column(unique = true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "entidades.Persona[id=" + id + "]";
    }
}
