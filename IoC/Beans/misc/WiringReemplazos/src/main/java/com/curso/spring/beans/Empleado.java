package com.curso.spring.beans;

public class Empleado extends Persona {
    private Integer sueldo = 1000;

    public Empleado() {
    }

    public Empleado(String nombre, int sueldo) {
        super(nombre);
        this.sueldo = sueldo;
    }

    protected Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSueldo();
    }
}
