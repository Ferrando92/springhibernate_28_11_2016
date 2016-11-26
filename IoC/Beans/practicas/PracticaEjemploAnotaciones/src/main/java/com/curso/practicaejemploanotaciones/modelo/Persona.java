/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaejemploanotaciones.modelo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class Persona {

    @Autowired
    private String nombre;
    @Autowired
    private List<Aficion> aficiones;

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", aficiones=" + aficiones + '}';
    }

}
