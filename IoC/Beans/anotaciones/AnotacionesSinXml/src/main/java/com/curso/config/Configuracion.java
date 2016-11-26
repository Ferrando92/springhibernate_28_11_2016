/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.config;

import com.curso.beans.Persona;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author usuario
 */
@Configuration
@ComponentScan(basePackages = {"com.curso.componentes","com.curso.beans"})
@PropertySource("props.properties")
public class Configuracion implements Util{

    public Configuracion() {
        log();
    }
    
    @Bean
    public PropertySourcesPlaceholderConfigurer daIgual(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean(autowire = Autowire.BY_TYPE)
    @Scope("prototype")
    public Persona tambienDaIgual(){
        return new Persona();
    }
}
