/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.pk.embeddable;

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
public class EmbeddablePkTest {

    private static final String CUERPO_TEST = "Cuerpo test";
    private static final String LENGUAJE = "es";
    private static final String TITULO = "Test";
    private NoticiaId otroId;
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
        NoticiaId nId = new NoticiaId();
        nId.setLenguaje(LENGUAJE);
        nId.setTitulo(TITULO);
        Noticia n = new Noticia();
        n.setId(nId);
        n.setCuerpo(CUERPO_TEST);
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
        otroId = n.getId();
        assertNotNull(otroId);
    }

    @Test
    public void testFind() {
        NoticiaId nId = new NoticiaId();
        nId.setLenguaje(LENGUAJE);
        nId.setTitulo(TITULO);
        em.getTransaction().begin();
        Noticia n = em.find(Noticia.class, nId);
        em.getTransaction().commit();
        assertNotNull(n);
        assertEquals(CUERPO_TEST, n.getCuerpo());
    }
}
