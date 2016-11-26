/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.herencia.mappedsuperclass;

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
public class HerenciaMappedsuperclassTest {

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
        em.getTransaction().begin();
        Circulo ancestro = new Circulo();
        em.persist(ancestro);
        em.getTransaction().commit();
        assertNotNull(ancestro.getId());
    }

    @Test
    public void testFindOk() {
        em.getTransaction().begin();
        final String consultaCirculo = "select c from Circulo c";
        assertEquals(em.createQuery(consultaCirculo).getResultList().size(), 1L);
        em.getTransaction().commit();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindError() {
        final String consultaFigura = "select f from Figura f";
        assertEquals(em.createQuery(consultaFigura).getResultList().size(), 1);
    }
}
