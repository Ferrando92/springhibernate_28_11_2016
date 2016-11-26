/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author usuario
 */
@Configuration
@PropertySource("pruebas.properties")
@Profile("pruebas")
public class ConfiguracionPruebas implements Util {

    public ConfiguracionPruebas() {
        log();
    }
}
