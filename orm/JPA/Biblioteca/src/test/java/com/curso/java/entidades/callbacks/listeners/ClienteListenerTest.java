/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.callbacks.listeners;

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
public class ClienteListenerTest {

    private static final String TELEFONO_ERRONEO = "abc";
    private static EntityManagerFactory emf;
    private EntityManager em;
    private ClienteListener clienteListener;

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
        clienteListener = new ClienteListener();
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void testPersistOk() {
        em.getTransaction().begin();
        em.persist(clienteListener);
        em.getTransaction().commit();
        assertNotNull(clienteListener.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPersistError() {
        em.getTransaction().begin();
        clienteListener.setTelefono(TELEFONO_ERRONEO);
        em.persist(clienteListener);
        em.getTransaction().commit();
        assertNotNull(clienteListener.getId());
    }
}
