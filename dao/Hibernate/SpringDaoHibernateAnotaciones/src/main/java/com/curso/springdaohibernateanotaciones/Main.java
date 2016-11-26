/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springdaohibernateanotaciones;

import com.curso.springdaohibernateanotaciones.dominio.Aficion;
import com.curso.springdaohibernateanotaciones.dominio.Persona;
import com.curso.springdaohibernateanotaciones.servicios.ServicioPersona;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Chema
 */
public class Main {

    private ApplicationContext ctx;
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.cargarContexto();
        m.cargarDatosPrueba();
        m.probarAccesoDatos();
    }

    private void cargarContexto() {        
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml", "daoContext.xml");
        System.out.println("Contexto cargado");
    }

    private void probarAccesoDatos() {
        ServicioPersona s = ctx.getBean(ServicioPersona.class);
        System.out.printf("Hay %d personas en la base de datos\n",
                s.getNumeroDePersonas());
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos");
        s.getPersonas().forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos cuyo nombre contiene la letra 'p'");
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
        List<Aficion> aficiones = s.getAficiones(2);
        s.getAficiones(2).forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 obtenidas de otra manera");
        aficiones = s.getAficionesDeOtraManera(2);
        System.out.println("Clase" + aficiones.getClass().getName());
//        for (Aficion aficion : aficiones) {
//            System.out.println(aficion);
//        }
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 de una tercera forma");
        aficiones = s.getAficionesDeOtraManeraMas(2);
                System.out.println("Clase" + aficiones.getClass().getName());

//        for (Aficion aficion : aficiones) {
//            System.out.println(aficion);
//        }
        System.out.println("************************************************");
    }

    private void cargarDatosPrueba() {
        ServicioPersona s = (ServicioPersona) ctx.getBean("servicioPersona");
        LOGGER.log(Level.INFO, "Servicio de personas encontrado");
        for (int i = 0; i < 10; i++) {
            Persona p = new Persona();
            p.setNombre("pepe" + i);
            Aficion a = new Aficion();
            a.setNombre("Afición" + i);
            a.setPersona(p);
            p.getAficiones().add(a);
            Persona otra = s.insertPersona(p);
            System.out.println("Insertada persona con id " + otra.getId());
        }
        System.out.println("************************************************");
    }
}
