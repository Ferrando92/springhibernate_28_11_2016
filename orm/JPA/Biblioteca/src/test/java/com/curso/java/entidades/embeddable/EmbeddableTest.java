/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.embeddable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author jose maria
 */
public class EmbeddableTest {

    private static final String DESCRIPCION_HABITACION = "cocina";
    private static EntityManagerFactory emf;
    private EntityManager em;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("LocalMemoryPU");
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }
    
    private void testPersist() {
        Casa casa = new Casa();
        Habitacion habitacion = new Habitacion();
        habitacion.setDescripcion(DESCRIPCION_HABITACION);
        casa.setHabitacion(habitacion);
        em.getTransaction().begin();
        em.persist(casa);
        em.getTransaction().commit();
    }

    @Test
    public void testFind() {
        testPersist();
        final String consulta = "select c.habitacion.descripcion from Casa c";
        em.getTransaction().begin();
        assertEquals(em.createQuery(consulta).getResultList().size(), 1);
        assertEquals(em.createQuery(consulta).getResultList().get(0), DESCRIPCION_HABITACION);
        em.getTransaction().commit();
    }
}
