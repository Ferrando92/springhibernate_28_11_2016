/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.config;

import com.curso.spring.beans.Persona;
import javax.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *
 * @author Administrador
 */
@Configuration
public class Configuracion {

    @Bean
    public Persona getPersona() {
        return new Persona();
    }

    @Bean
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }
}
