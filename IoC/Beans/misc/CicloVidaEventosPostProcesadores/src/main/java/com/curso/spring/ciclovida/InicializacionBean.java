/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.ciclovida;

import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author user
 */
public class InicializacionBean implements InitializingBean {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (getNombre() == null) {
            System.out.println("La propiedad nombre de este bean no se ha inicializado");
        }
    }
}
