package com.curso.springdaohibernateanotaciones.dominio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue
    private final Integer id = null;
    private String nombre;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<Aficion> aficiones = new ArrayList<>();

    public Persona nuevaAficion(Aficion a) {
        aficiones.add(a);
        a.setPersona(this);
        return this;
    }

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre();
    }

    public List<Aficion> getAficiones() {
        return aficiones;
    }
}
