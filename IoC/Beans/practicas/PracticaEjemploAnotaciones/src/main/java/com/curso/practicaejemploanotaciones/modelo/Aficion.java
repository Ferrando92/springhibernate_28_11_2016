/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaejemploanotaciones.modelo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class Aficion {
    @Value("#{props.nombreAficion + T(java.lang.System).nanoTime()}")
    private String nombre;

    @Override
    public String toString() {
        return "Aficion{" + "nombre=" + nombre + '}';
    }
    
}
