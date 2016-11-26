/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springdaojpa;

import com.curso.springdaojpa.modelo.Comercial;
import com.curso.springdaojpa.modelo.Contacto;
import com.curso.springdaojpa.servicio.ServicioCliente;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author usuario
 */
public class Principal {

    private ApplicationContext ctx;
    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Principal().init().ejecutarSpringJpa().ejecutarSpringJpaRelaciones();
    }

    private Principal init() {
        ctx = new ClassPathXmlApplicationContext("app.xml");
        LOG.log(Level.INFO, "Contexto cargado");
        return this;
    }

    private Principal ejecutarSpringJpa() {
        ServicioCliente servicio = ctx.getBean(ServicioCliente.class);
        final Integer MAX_ELEMENTOS = 5;
        IntStream.iterate(0, i -> i + 1).limit(MAX_ELEMENTOS).forEach(
                i -> servicio.insertarContacto(new Contacto())
        );
        Collection<Contacto> todosContactos = servicio.getTodosLosContactos();
        System.out.printf("se han encontrado %d contactos\n", todosContactos.size());
        todosContactos.forEach(contacto
                -> System.out.printf("La clave del contacto es %d\n", contacto.getId())
        );
        IntStream.iterate(0, i -> i + 1).limit(MAX_ELEMENTOS).forEach(
                i -> servicio.insertarComercial(new Comercial())
        );
        Collection<Comercial> todosComerciales = servicio.getTodosLosComerciales();
        System.out.printf("se han encontrado %d comerciales\n", todosComerciales.size());
        todosComerciales.forEach(
                comercial -> System.out.printf("La clave del comercial es %d\n", comercial.getId())
        );
        return this;
    }

    private Principal ejecutarSpringJpaRelaciones() {
        Comercial comercial = new Comercial();
        Contacto contacto = new Contacto();
        ServicioCliente servicio = ctx.getBean(ServicioCliente.class);
        servicio.asignarContacto(comercial, contacto);
        List<Contacto> contactos = servicio.getContactosDeUnComercial(comercial);
        System.out.printf("se han encontrado %d contactos\n", contactos.size());
        contactos.forEach(
                elem -> System.out.printf("La clave del contacto es %d\n", elem.getId())
        );

        return this;
    }

}
