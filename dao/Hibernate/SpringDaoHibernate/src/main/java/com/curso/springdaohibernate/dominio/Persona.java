package com.curso.springdaohibernate.dominio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persona implements Serializable {

    private Integer id;
    private String nombre;
    private final Set<Aficion> aficionesInternas = new HashSet<>();
    private List<Aficion> aficiones;

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
        return "Mi nombre es " + nombre;
    }

    public List<Aficion> getAficiones() {
        return Collections.unmodifiableList(new ArrayList<>(aficionesInternas));
    }

    public Boolean nuevaAficion(Aficion a){
        return aficionesInternas.add(a);
    }
}
