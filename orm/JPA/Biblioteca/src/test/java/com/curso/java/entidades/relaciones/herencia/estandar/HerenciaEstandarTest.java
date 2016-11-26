/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.herencia.estandar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jose maria
 */
public class HerenciaEstandarTest {

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
        Ancestro ancestro = new Ancestro();
        Descendiente descendiente = new Descendiente();
        em.getTransaction().begin();
        em.persist(ancestro);
        em.persist(descendiente);
        em.getTransaction().commit();
        assertNotNull(ancestro.getId());
        assertNotNull(descendiente.getId());
    }

    @Test
    public void testFind() {
        testPersist();
        em.getTransaction().begin();
        final String consultaAncestro = "select a from Ancestro a";
        assertEquals(em.createQuery(consultaAncestro).getResultList().size(), 2);
        final String consultaDescendiente = "select d from Descendiente d";
        assertEquals(em.createQuery(consultaDescendiente).getResultList().size(), 1);
        em.getTransaction().commit();
    }
}
