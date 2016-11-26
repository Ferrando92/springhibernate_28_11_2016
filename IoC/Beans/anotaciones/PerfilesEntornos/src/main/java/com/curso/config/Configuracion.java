/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.config;

import com.curso.beans.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 *
 * @author usuario
 */
@Configuration
public class Configuracion implements Util{

    public Configuracion() {
        log();
    }

    @Autowired
    private Environment e;

    @Bean
    public Persona daIgual() {
        Persona p = new Persona();
        p.setNombre(e.getProperty("una"));
        return p;
    }
}
