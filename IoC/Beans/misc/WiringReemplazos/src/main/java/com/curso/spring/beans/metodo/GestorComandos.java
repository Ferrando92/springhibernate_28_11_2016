package com.curso.spring.beans.metodo;

public abstract class GestorComandos {
    public GestorComandos() {
    }

    public void ejecutar(Object estado) {
        Comando comando = crearComando();
        comando.setEstado(estado);
        comando.ejecutar();
    }

    public abstract Comando crearComando();
    
    public void otroMetodo(){
        System.out.println("Ejecutando desde " + getClass().getName());
    }
}
