/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.cableado;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.BeanNameAware;

/**
 *
 * @author usuario
 */
public class Contenedor implements Serializable, BeanNameAware{
    
    private Contenido contenido;

    private List<String> nombres;

    private String nombreBean;

    /**
     * Get the value of nombreBean
     *
     * @return the value of nombreBean
     */
    public String getNombreBean() {
        return nombreBean;
    }

    /**
     * Set the value of nombreBean
     *
     * @param nombreBean new value of nombreBean
     */
    public void setNombreBean(String nombreBean) {
        this.nombreBean = nombreBean;
    }

    /**
     * Get the value of nombres
     *
     * @return the value of nombres
     */
    public List<String> getNombres() {
        return nombres;
    }

    /**
     * Set the value of nombres
     *
     * @param nombres new value of nombres
     */
    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }

    /**
     * Get the value of contenido
     *
     * @return the value of contenido
     */
    public Contenido getContenido() {
        return contenido;
    }

    /**
     * Set the value of contenido
     *
     * @param contenido new value of contenido
     */
    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Contenedor{" + "contenido=" + contenido + ", nombres=" + nombres + ", nombreBean=" + nombreBean + '}';
    }


    @Override
    public void setBeanName(String name) {
        nombreBean = name;
    }

}
