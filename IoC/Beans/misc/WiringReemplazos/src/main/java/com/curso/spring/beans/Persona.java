package com.curso.spring.beans;

public class Persona {
    private String nombre;

    public Persona() {
        this("Sin nombre");
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public static Persona crearPersona() {
        return new Persona("pepe");
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
