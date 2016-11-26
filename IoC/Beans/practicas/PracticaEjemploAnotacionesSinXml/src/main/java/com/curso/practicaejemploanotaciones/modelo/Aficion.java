/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaejemploanotaciones.modelo;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class Aficion {

    @Autowired
    private Environment env;

    private String nombre;

    @Override
    public String toString() {
        return "Aficion{" + "nombre=" + nombre + '}';
    }

    @PostConstruct
    private void init() {
        nombre = env.getProperty("nombreAficion") + System.nanoTime();
    }

}
