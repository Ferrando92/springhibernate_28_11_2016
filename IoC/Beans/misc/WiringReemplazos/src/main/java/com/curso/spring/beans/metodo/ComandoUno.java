package com.curso.spring.beans.metodo;

public class ComandoUno implements Comando {
    private Object estado;

    public ComandoUno() {
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando el comando " + getClass().getName() + 
                           " con la informaci�n: " + estado);
    }

    @Override
    public void setEstado(Object estado) {
        this.estado = estado;
    }

    public Comando crearComando() {
        return new ComandoUno();
    }
}
