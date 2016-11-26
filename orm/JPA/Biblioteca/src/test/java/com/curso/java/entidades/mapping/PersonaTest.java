/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.mapping;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
public class PersonaTest {

    private static final String nombrePersona = "abc";
    private static Long id = null;
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
        Persona persona = new Persona(nombrePersona);
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        id = persona.getId();
        assertNotNull(id);
    }

    @Test
    public void testFind() {
        em.getTransaction().begin();
        Persona persona = em.find(Persona.class, id);
        em.getTransaction().commit();
        assertNotNull(persona);
        assertEquals(id, persona.getId());
        assertEquals(nombrePersona, persona.getNombre());
    }

    @Test
    public void testFindAll() {
        em.getTransaction().begin();
        Query q = em.createNamedQuery("Persona.findAll");
        List<Persona> personas = q.getResultList();
        em.getTransaction().commit();
        assertTrue(personas.size() == 1);
    }
}
