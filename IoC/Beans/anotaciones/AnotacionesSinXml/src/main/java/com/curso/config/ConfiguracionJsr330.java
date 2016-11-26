/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author usuario
 */
@Configuration
@ComponentScan(basePackages = "com.curso.jsr330")
public class ConfiguracionJsr330 implements Util {

    @Autowired
    private ApplicationContext ctx;

    public ConfiguracionJsr330() {
        log();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(ctx);
    }
}
