/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplojinq;

import com.curso.ejemplojinq.modelo.Persona;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import static java.lang.System.*;

/**
 *
 * @author usuario
 */
public class Principal {

    private static final Logger LOG = Logger.getLogger(Principal.class.getName());
    private static JinqJPAStreamProvider streams;
    private EntityManager entityManager;
    private static EntityManagerFactory emf;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("EjemploPU");
        LOG.log(Level.INFO, "JPA inicializado correcramente");
        streams = new JinqJPAStreamProvider(emf);
        streams.setHint("queryLogger", (JPAQueryLogger) (String query, Map<Integer, Object> positionParameters, Map<String, Object> namedParameters) -> {
            System.out.println("  " + query);
        });
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        obtenerPersonas(10).forEach(em::persist);
        em.getTransaction().commit();
        new Principal().ejecutarConsultas();
        emf.close();
        LOG.log(Level.INFO, "JPA cerrado correcramente");
    }

    private JinqStream<Persona> personas() {
        return streams.streamAll(entityManager, Persona.class);
    }

    private void ejecutarConsultas() {
        entityManager = emf.createEntityManager();
        out.println("Todas las personas".toUpperCase());
        personas().forEach(out::println);
        out.println("Todas las personas que tienen un dos".toUpperCase());
        personas().where(p -> p.getNombre().contains("2")).forEach(out::println);
    }

    private static Stream<Persona> obtenerPersonas(Integer maxPersonas) {
        Objects.requireNonNull(maxPersonas);
        assert 1 <= maxPersonas : "El número de personas a crear debe ser al menos una";
        return IntStream.rangeClosed(1, maxPersonas)
                .mapToObj(i -> "Persona " + i)
                .map(Persona::new);
    }

}
