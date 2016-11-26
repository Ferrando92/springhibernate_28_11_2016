package com.curso.spring.beans;

public class Departamento {
    private Empleado responsable;

    public Departamento() {
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "El responsable del departamento es " + responsable;
    }
}
