/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.pk.idclass;

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
public class IdClassPkTest {

    private static final String CUERPO_TEST = "Cuerpo test";
    private static final String LENGUAJE = "es";
    private static final String TITULO = "Test";
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
        OtraNoticia n = new OtraNoticia();
        n.setLenguaje(LENGUAJE);
        n.setTitulo(TITULO);
        n.setCuerpo(CUERPO_TEST);
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
        assertEquals(em.createQuery("select n from OtraNoticia n").getResultList().size(), 1);
    }

    @Test
    public void testFind() {
        OtraNoticiaId otroId = new OtraNoticiaId();
        otroId.setLenguaje(LENGUAJE);
        otroId.setTitulo(TITULO);
        em.getTransaction().begin();
        OtraNoticia n = em.find(OtraNoticia.class, otroId);
        em.getTransaction().commit();
        assertNotNull(n);
        assertEquals(CUERPO_TEST, n.getCuerpo());
    }
}
