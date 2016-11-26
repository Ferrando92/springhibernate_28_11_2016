package com.curso.spring.beans.auto;

import com.curso.spring.beans.Empleado;

public class Jefe extends Empleado {

    private Empleado asesor;

    public Jefe() {
    }

    public Jefe(String nombre, int sueldo) {
        super(nombre, sueldo);
    }

    public Empleado getAsesor() {
        return asesor;
    }

    public void setAsesor(Empleado asesor) {
        this.asesor = asesor;
    }

    @Override
    public String toString() {
        return super.toString() + "Asesor: " + getAsesor();
    }
}
