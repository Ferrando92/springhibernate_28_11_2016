/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.bidireccional.manytomany;

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
public class ManyToManyTest {

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

    @Test
    public void testPersist() {
        Cantante cantante = new Cantante();
        Cancion cancion = new Cancion();
        cantante.getCanciones().add(cancion);
        cancion.getCantantes().add(cantante);
        em.getTransaction().begin();
        em.persist(cantante);
        em.getTransaction().commit();
        assertNotNull(cantante.getId());
        assertNotNull(cancion.getId());
        em.getTransaction().begin();
        Cantante otroCantante = em.find(Cantante.class, cantante.getId());
        assertEquals(otroCantante.getCanciones().size(), 1);
        Cancion otraCancion = em.find(Cancion.class, cancion.getId());
        assertEquals(otraCancion.getCantantes().size(), 1);
        em.getTransaction().commit();
        assertEquals(otroCantante.getCanciones().get(0), cancion);
        assertEquals(otraCancion.getCantantes().get(0), cantante);
    }
}
