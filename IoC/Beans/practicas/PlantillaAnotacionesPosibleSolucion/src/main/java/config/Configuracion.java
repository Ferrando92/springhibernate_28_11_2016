/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import beans.Aficion;
import beans.Perfil;
import beans.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author iconotc
 */
@Configuration
public class Configuracion {

    @Bean
    public Persona uno() {
        return new Persona();
    }

    @Bean
    public Aficion dos() {
        return new Aficion();
    }

    @Bean
    public Aficion dos_1() {
        return new Aficion();
    }

    @Bean
    public Aficion dos_2() {
        return new Aficion();
    }

    @Bean
    public Perfil tres() {
        return new Perfil();
    }

    @Bean
    @Scope("prototype")
    public String cuatro() {
        return "Nombre " + System.nanoTime();
    }
}
