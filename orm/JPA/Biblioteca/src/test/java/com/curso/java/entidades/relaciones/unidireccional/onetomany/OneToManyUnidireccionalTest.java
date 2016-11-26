/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.unidireccional.onetomany;

import java.util.Date;
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
public class OneToManyUnidireccionalTest {

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
        Factura factura = new Factura();
        Item item = new Item();
        factura.getItems().add(item);
        em.persist(item);
        assertNotNull(item.getId());
        Item item1 = new Item();
        factura.getItems().add(item1);
        em.persist(item1);
        assertNotNull(item1.getId());
        em.persist(factura);
        assertNotNull(factura.getId());
        em.getTransaction().commit();
        em.getTransaction().begin();
        Factura otraFactura = em.find(Factura.class, factura.getId());
        assertNotNull(otraFactura);
        assertEquals(otraFactura.getItems().size(), 2);
        Item otroItem = em.find(Item.class, item.getId());
        assertNotNull(otroItem);
        assertEquals(otroItem.getId(), otraFactura.getItems().get(0).getId());
        assertEquals(em.createQuery("select f from Factura f").getResultList().size(), 1);
        assertEquals(em.createQuery("select i from Item i").getResultList().size(), 2);
        em.getTransaction().commit();
    }
}
