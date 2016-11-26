/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.ambito;

/**
 *
 * @author usuario
 */
public class Prototipo {
    
    private String texto;

    /**
     * Get the value of texto
     *
     * @return the value of texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Set the value of texto
     *
     * @param texto new value of texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Prototipo{" + "texto=" + texto + " " + hashCode() + '}';
    }

}
