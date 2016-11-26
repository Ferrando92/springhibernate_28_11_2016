/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.piloto;

import com.curso.piloto.beans.Aficion;
import com.curso.piloto.beans.Persona;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author usuario
 */
public class Principal {

    private static final Logger LOG = LoggerFactory.getLogger(Principal.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        LOG.info("Cargando un ApplicationContext desde XML y un archivo de propiedades");
        Optional<Persona> persona = contextoConfigurable("vacio.xml").map(context -> context.getBean(Persona.class));
        System.out.println(persona.orElse(new Persona()));
        esperar();
        LOG.info("Cargando un ApplicationContext desde XML");
        contextoEstandar("app.xml").map(context -> {
            LOG.info("Ejecutando la aplicaci\u00f3n bajo el contexto {0}", context);
            return Optional.of(true);
        });
        esperar();
        LOG.info("Cargando un ApplicationContext por programa");
        Optional<Persona> personaPorPrograma = contextoProgramatico().map(context -> context.getBean("personaPorPrograma", Persona.class));
        System.out.println(personaPorPrograma);
        LOG.info("Fin del programa...");
    }

    private static void esperar() {
        System.out.println("Pulse cualquier tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

    private static Optional<ApplicationContext> contextoEstandar(String... configuraciones) {
        Optional<ApplicationContext> r = Optional.empty();
        try {
            r = Optional.of(new ClassPathXmlApplicationContext(configuraciones));
            LOG.info("Contexto cargado");
            LOG.info("Buscando un bean de tipo Persona");
            r.map(context -> context.getBean(Persona.class)).ifPresent(System.out::println);
            LOG.info("Buscando los nombres de los beans de tipo Aficion");
            String[] nombres = r.map(context -> context.getBeanNamesForType(Aficion.class)).get();
            Arrays.asList(nombres).forEach(System.out::println);
            LOG.info("Buscando todos los beans de tipo Aficion");
            Map<String, Aficion> aficiones = r.map(context -> context.getBeansOfType(Aficion.class)).get();
            aficiones.forEach((k, v) -> System.out.format("Clave: %s. Valor:%s%n", k, v));
        } catch (BeansException e) {
            LOG.error("\u00a1Error de configuraci\u00f3n de Spring! {0}", e.getMessage());
        }
        return r;
    }

    private static Optional<ApplicationContext> contextoConfigurable(String... configuraciones) {

        Optional<ApplicationContext> r = Optional.empty();
        try {
            GenericApplicationContext context = new GenericApplicationContext();
            XmlBeanDefinitionReader lectorXml = new XmlBeanDefinitionReader(context);
            lectorXml.loadBeanDefinitions(configuraciones);
            PropertiesBeanDefinitionReader lectorPropiedades = new PropertiesBeanDefinitionReader(context);
            lectorPropiedades.loadBeanDefinitions(new ClassPathResource("beans.properties"));
            context.refresh();
            r = Optional.of(context);
            LOG.info("Contexto cargado");
        } catch (BeansException | IllegalStateException e) {
            LOG.error("\u00a1Error de configuraci\u00f3n de Spring! {0}", e.getMessage());
        }
        return r;
    }

    private static Optional<ApplicationContext> contextoProgramatico() {
        Optional<ApplicationContext> r = Optional.empty();
        try {
            BeanDefinition bdPersona = new RootBeanDefinition(Persona.class);
            BeanDefinition bdAficion = new RootBeanDefinition(Aficion.class);

            bdPersona.getPropertyValues().addPropertyValue("nombre", "Nombre por programa");
            bdAficion.getPropertyValues().addPropertyValue("nombre", "Nombre Afición por programa");
            bdPersona.getPropertyValues().addPropertyValue("aficion", bdAficion);

            GenericApplicationContext context = new GenericApplicationContext();
            context.registerBeanDefinition("personaPorPrograma", bdPersona);
            context.registerBeanDefinition("aficionPorPrograma", bdAficion);
            context.refresh();
            r = Optional.of(context);
        } catch (BeansException | IllegalStateException e) {
            LOG.error("\u00a1Error de configuraci\u00f3n de Spring! {0}", e.getMessage());
        }
        return r;
    }
}
