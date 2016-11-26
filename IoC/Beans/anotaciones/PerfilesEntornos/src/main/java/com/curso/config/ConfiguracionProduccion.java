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
@PropertySource("produccion.properties")
@Profile("produccion")
public class ConfiguracionProduccion implements Util {

    public ConfiguracionProduccion() {
        log();
    }

}
