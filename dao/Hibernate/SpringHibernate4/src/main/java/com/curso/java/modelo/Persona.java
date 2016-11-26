/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author Chema
 */
@Entity
@Access(AccessType.FIELD)
@Cacheable
@Cache(region = "personas", usage = CacheConcurrencyStrategy.READ_WRITE, include = "all")
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, orphanRemoval = true)
    private Set<Aficion> aficiones = new HashSet<>();

    public Set<Aficion> getAficiones() {
        return aficiones;
    }

    public void setAficiones(Set<Aficion> aficiones) {
        this.aficiones = aficiones;
    }

    /**
     *
     */
    public Persona() {
    }

    /**
     *
     * @param nombre
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return el valor de la clave primaria
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.aficiones);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.aficiones, other.aficiones);
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
