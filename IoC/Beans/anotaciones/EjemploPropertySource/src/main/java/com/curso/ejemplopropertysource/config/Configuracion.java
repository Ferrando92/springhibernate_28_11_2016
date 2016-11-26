/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplopropertysource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author usuario
 */
@Configuration
@PropertySource("app.properties")
public class Configuracion {
    @Autowired
    private Environment env;
    public String obtenerPropiedad(){
        return env.getProperty("uno");
    }
}
