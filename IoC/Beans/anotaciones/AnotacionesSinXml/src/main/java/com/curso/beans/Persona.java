/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.beans;

import com.curso.config.Util;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author usuario
 */
public class Persona implements Util{

    @Autowired
    private Aficion aficion;

    public Persona() {
        log();
    }

    @Override
    public String toString() {
        return "Persona{" + "aficion=" + aficion + '}';
    }

}
