/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.bidireccional.onetomany;

import java.util.List;
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
public class OneToManyBidireccionalTest {

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
        Programa p = new Programa();
        Modulo m1 = new Modulo();
        Modulo m2 = new Modulo();
        p.getModulos().add(m2);
        p.getModulos().add(m1);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        assertNotNull(p.getId());
        assertNotNull(m1.getId());
        assertNotNull(m2.getId());
    }

    @Test(expected = AssertionError.class)
    public void testFindError() {
        final String consulta = "select p.modulos from Programa p";
        em.getTransaction().begin();
        assertEquals(em.createQuery(consulta).getResultList().size(), 2);
        em.getTransaction().commit();
    }

    @Test
    public void testFind() {
        final String consulta = "select p from Programa p left join fetch p.modulos";
        em.getTransaction().begin();
        List<Programa> l = em.createQuery(consulta).getResultList();
        em.getTransaction().commit();
        assertEquals(l.size(), 1L);
        assertEquals(l.get(0).getModulos().size(), 2);
    }

    @Test
    public void testFindGetSingleResult() {
        testPersist();
        final String consulta = "select p from Programa p";
        em.getTransaction().begin();
        Programa p = (Programa) em.createQuery(consulta).getSingleResult();
        em.getTransaction().commit();
        assertEquals(p.getModulos().size(), 2);
    }
}
