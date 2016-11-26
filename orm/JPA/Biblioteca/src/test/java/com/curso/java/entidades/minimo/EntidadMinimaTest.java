/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.minimo;

import com.curso.java.entidades.minimo.EntidadMinima;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
public class EntidadMinimaTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Long clave = 1000L;

    public EntidadMinimaTest() {
    }

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
        insertHelper();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void testInsert() {
        System.out.println("testInsert");
        em.getTransaction().begin();
        TypedQuery<EntidadMinima> query = em.createQuery("select e from EntidadMinima e", EntidadMinima.class);
        EntidadMinima e = query.getSingleResult();
        assertNotNull(e);
        em.remove(e);
        em.getTransaction().commit();
    }

    @Test
    public void testDelete() {
        System.out.println("testDelete");
        em.getTransaction().begin();
        TypedQuery<EntidadMinima> query = em.createQuery("select e from EntidadMinima e", EntidadMinima.class);
        EntidadMinima e = query.getSingleResult();
        em.remove(e);
        em.getTransaction().commit();
        em.getTransaction().begin();
        assertTrue(em.createQuery("select e from EntidadMinima e").getResultList().isEmpty());
        em.getTransaction().commit();
    }

    @Test
    public void testFind() {
        System.out.println("testFind");
        em.getTransaction().begin();
        EntidadMinima e = em.find(EntidadMinima.class, clave);
        assertEquals(e.getId(), clave);
        em.remove(e);
        em.getTransaction().commit();
    }

    @Test
    public void testUpdate() {
        System.out.println("testUpdate");
        em.getTransaction().begin();
        EntidadMinima e = em.find(EntidadMinima.class, clave);
        e.setNombre("xyz");
        em.merge(e);
        em.getTransaction().commit();
        em.getTransaction().begin();
        e = em.find(EntidadMinima.class, clave);
        assertEquals(e.getNombre(), "xyz");
        em.remove(e);
        em.getTransaction().commit();
    }

    private void insertHelper() {
        em.getTransaction().begin();
        EntidadMinima e = new EntidadMinima();
        e.setId(clave);
        e.setNombre("abc");
        em.persist(e);
        em.getTransaction().commit();
    }
}
