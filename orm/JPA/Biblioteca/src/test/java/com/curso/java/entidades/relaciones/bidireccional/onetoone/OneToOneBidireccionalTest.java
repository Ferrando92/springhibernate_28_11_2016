/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.bidireccional.onetoone;

import org.junit.After;
import org.junit.Before;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose maria
 */
public class OneToOneBidireccionalTest {

    private static final String UNIDAD_PERSISTENCIA = "LocalMemoryPU";
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    private EntityTransaction tx;

    @BeforeClass
    public static void inicializarEntityManager() {
        emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);

    }

    @AfterClass
    public static void cerrarEntityManager() {
        emf.close();
    }

    @Before
    public void uno() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @After
    public void dos() {
        if (tx.isActive()) {
            tx.rollback();
        }
        em.close();
    }

    @Test
    public void testPersistOk() {
        Coche coche = new Coche();
        Motor motor = new Motor();
        coche.setMotor(motor);
        motor.setCoche(coche);
        em.persist(coche);
        assertNotNull(coche.getId());
        assertNotNull(motor.getId());
        assertNotNull(coche.getMotor());
        assertEquals(coche.getMotor().getId(), motor.getId());
        assertNotNull(motor.getCoche());
        assertEquals(motor.getCoche().getId(), coche.getId());
    }

    @Test(expected = AssertionError.class)
    public void testPersistError1() {
        Coche coche = new Coche();
        Motor motor = new Motor();
        coche.setMotor(motor);
        em.persist(coche);
        assertNotNull(motor.getCoche());
    }

    @Test(expected = AssertionError.class)
    public void testPersistError2() {
        try {
            Coche coche = new Coche();
            Motor motor = new Motor();
            motor.setCoche(coche);
            em.persist(motor);
            assertNotNull(coche.getId());
        } catch (IllegalThreadStateException e) {
            System.out.println("Error esperado");
        }

    }
}
