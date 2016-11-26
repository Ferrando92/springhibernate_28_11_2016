/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.elementos;

import com.curos.java.entidades.elementos.Libro;
import java.util.List;
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
public class ElementosTest {

    private static final String tituloLibro = "abc";
    private static final String etiqueta1 = "uno";
    private static final String etiqueta2 = "dos";
    private static final String etiqueta3 = "tres";
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
        Libro libro = new Libro();
        libro.setTitulo(tituloLibro);
        libro.getEtiquetas().add(etiqueta1);
        libro.getEtiquetas().add(etiqueta2);
        libro.getEtiquetas().add(etiqueta3);
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    @Test
    public void testBuscarElementos() {
        testPersist();
        String consulta = "select libro.etiquetas from Libro libro where libro.titulo = :parametro";
        em.getTransaction().begin();
        List<String> etiquetas = em.createQuery(consulta).setParameter("parametro", tituloLibro).getResultList();
        em.getTransaction().commit();
        assertEquals(3, etiquetas.size());
        assertEquals(etiqueta1, etiquetas.get(0));
        assertEquals(etiqueta2, etiquetas.get(1));
        assertEquals(etiqueta3, etiquetas.get(2));
    }
}
