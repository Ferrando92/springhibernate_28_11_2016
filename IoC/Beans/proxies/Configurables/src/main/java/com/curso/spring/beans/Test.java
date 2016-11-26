/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.beans;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Test {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private TestServicio testServicio;

    public TestServicio getTestServicio() {
        return testServicio;
    }

    public void setTestServicio(TestServicio testServicio) {
        this.testServicio = testServicio;
    }
}
