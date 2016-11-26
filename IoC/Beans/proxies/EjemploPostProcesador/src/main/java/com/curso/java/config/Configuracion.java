/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.config;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Administrador
 */
@Configuration
@ComponentScan("com.curso.java")
public class Configuracion {
    private static final Logger LOG = Logger.getLogger(Configuracion.class.getName());

    public Configuracion() {
        LOG.log(Level.INFO,"Configuración creada".toUpperCase(Locale.getDefault()));
    }

}
