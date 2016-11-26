/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaejemploanotaciones;

import com.curso.practicaejemploanotaciones.modelo.Aficion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author usuario
 */
@Configuration
@ComponentScan
@PropertySource(value = "p.properties")
public class Configuracion {

    @Bean
    public Aficion daIgual() {
        return new Aficion();
    }

    @Bean
    public String daIgualTambien() {
        return "prueba";
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
