package com.curso.springdaohibernate;

import com.curso.springdaohibernate.dominio.Aficion;
import com.curso.springdaohibernate.dominio.Persona;

import com.curso.springdaohibernate.servicios.ServicioPersona;
import static java.lang.System.out;
import java.util.function.IntConsumer;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class Principal {

    private ApplicationContext ctx;
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public Principal() {
    }

    public static void main(String[] args) {
        new Principal()
                .cargarContexto()
                .cargarDatosPrueba()
                .probarAccesoDatos()
                .probarAspectoRecuperacion();                
    }

    private Principal cargarContexto() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml", "daoContext.xml", "aspectosContext.xml");
        System.out.println("Contexto cargado");
        return this;
    }

    private Principal probarAccesoDatos() {
        ServicioPersona s =  ctx.getBean(ServicioPersona.class);
        System.out.printf("Hay %d personas en la base de datos\n",
                s.getNumeroDePersonas());
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos");
        s.getPersonas().forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Personas en la base de datos cuyo nombre contiene la letra 'p'");
        s.getPorNombreParecido("p").forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Datos de la persona con id 1");
        Persona p = s.getPersona(1);
        System.out.println(p);
        System.out.println("************************************************");
        System.out.println("Borrando a aa persona con id = 1");
        s.deletePersona(p);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2");
        s.getAficiones(2).forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 obtenidas de otra manera");
        s.getAficionesDeOtraManera(2).forEach(out::println);
        System.out.println("************************************************");
        System.out.println("Aficiones de la persona con id 2 de una tercera forma");
        s.getAficionesDeOtraManeraMas(2).forEach(out::println);
        System.out.println("************************************************");
        return this;
    }

    private static class Consumidor implements IntConsumer {

        private final ServicioPersona sp;

        public Consumidor(ServicioPersona sp) {
            System.out.println("ServicioPersonas encontrado");
            this.sp = sp;
        }

        @Override
        public void accept(int numero) {
            Persona p = new Persona("pepe" + numero);
            Aficion a = new Aficion("Afición" + numero, p);
            p.nuevaAficion(a);
            sp.insertPersona(p);
        }

    }

    private Principal cargarDatosPrueba() {
        IntStream.range(0, 10).forEach(new Consumidor(ctx.getBean(ServicioPersona.class)));
        System.out.println("************************************************");
        return this;
    }

    private Principal probarAspectoRecuperacion() {
        ServicioPersona s = ctx.getBean(ServicioPersona.class);
        System.out.println("Probando el aspecto de recuperación...");
        try {
            Persona p = s.getPersona(20000);
        } catch (DataAccessException e) {
            System.out.println("Excepción de tipo DataAccessException");
        }
        return this;
    }
}
