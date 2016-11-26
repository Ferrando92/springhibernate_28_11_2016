package com.curso.springdaohibernate.dominio;

public class Aficion {

    private Integer id;
    private String nombre;
    private Persona persona;

    public Aficion() {
    }

    public Aficion(String nombre, final Persona persona) {
        this.nombre = nombre;
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(final Persona persona) {
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Esta afición se denomina " + getNombre();
    }
}
