/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springdaohibernateanotaciones;

import com.curso.springdaohibernateanotaciones.dominio.Aficion;
import com.curso.springdaohibernateanotaciones.dominio.Persona;
import com.curso.springdaohibernateanotaciones.servicios.ServicioPersona;
import static java.lang.System.out;
import java.util.stream.IntStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author usuario
 */
public class Principal {

    private enum Opciones {
        OK, FALLO
    }
    private ApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Principal()
                .cargarContexto()
                .cargarBd()
                .accederADatos(Opciones.OK);

    }

    private Principal cargarContexto() {
        ctx = new ClassPathXmlApplicationContext("app.xml", "dao.xml");
        System.out.println("Contexto Cargado");
        return this;
    }

    private Principal cargarBd() {
        final Long nInstancias = IntStream.rangeClosed(0, 10)
                .parallel()
                .mapToObj(i -> new Persona("persona" + i))
                .map(p -> p.nuevaAficion(new Aficion("aficion" + System.nanoTime())))
                .map(ctx.getBean(ServicioPersona.class)::insertPersona)
                .count();
        System.out.format("Se han hecho persistentes %s personas%n", nInstancias);
        return this;
    }

    private void accederADatos(Opciones forzarFallo) {
        ServicioPersona s = ctx.getBean(ServicioPersona.class);
        System.out.printf("Hay %d personas en la base de datos\n",
                s.getNumeroDePersonas());
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos");
        s.getPersonas().forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos cuyo nombre contiene la letra '5'");
        s.getPorNombreParecido("5").forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Datos de la persona con id 1");
        Persona p = s.getPersona(1);
        System.out.println(p.getClass().getName());
        System.out.println("************************************************");
        System.out.println("Borrando a aa persona con id = 1");
        s.deletePersona(p);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2");
        s.getAficiones(2).forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 obtenidas de otra manera");
        System.out.println("Clase " + s.getAficionesDeOtraManera(2).getClass().getName());
        if (forzarFallo == Opciones.FALLO) {
            s.getAficionesDeOtraManera(2).forEach(out::println);
        }

        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 de una tercera forma");
        System.out.println("Clase " + s.getAficionesDeOtraManeraMas(2).getClass().getName());
        if (forzarFallo == Opciones.FALLO) {
            s.getAficionesDeOtraManeraMas(2).forEach(out::println);
        }
        System.out.println("Fin");
    }

}
