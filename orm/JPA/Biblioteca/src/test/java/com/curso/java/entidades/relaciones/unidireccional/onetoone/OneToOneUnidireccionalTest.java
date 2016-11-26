/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.relaciones.unidireccional.onetoone;

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
public class OneToOneUnidireccionalTest {

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
        Usuario usuario = new Usuario();
        Perfil perfil = new Perfil();
        usuario.setPerfil(perfil);
        em.getTransaction().begin();
        em.persist(usuario);

        em.persist(perfil);
        em.getTransaction().commit();
        assertNotNull(usuario.getId());
        assertNotNull(perfil.getId());
        em.getTransaction().begin();
        Usuario otro = em.find(Usuario.class, usuario.getId());
        assertNotNull(otro);
        assertNotNull(otro.getPerfil());
        assertEquals(otro.getPerfil().getId(), perfil.getId());
        Perfil otroPerfil = em.find(Perfil.class, perfil.getId());
        assertNotNull(otroPerfil);
        assertEquals(otro.getPerfil().getId(), otroPerfil.getId());
        em.getTransaction().commit();
    }
}
