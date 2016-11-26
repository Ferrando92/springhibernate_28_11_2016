/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.daos;

import com.curso.java.modelo.Persona;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Chema
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class DaoTest {

    @Autowired
    private Dao<Persona> dao;
    private Persona persona;

    public DaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        persona = new Persona("abc");
    }

    @After
    public void tearDown() {
        Collection<Persona> c = dao.consulta();
//        c.forEach((persona1) -> {
//            dao.borrar(persona1);
//        });        
        c.forEach(dao::borrar);
    }

    @Test
    public void testGuardar() {
        assertNotNull(dao.guardar(persona).getId());
    }

    @Test
    public void testConsulta() {
        dao.guardar(persona);
        assertEquals(1, dao.consulta().size());
    }

    @Test
    public void testConsultaParametrizada() {
        final String orden = "from Persona as p where p.nombre = :primerParametro";
        Map<String, String> parametros = new HashMap<>();
        parametros.put("primerParametro", "abc");
        dao.guardar(persona);
        assertEquals(1, dao.consulta(orden, parametros).size());
    }

    @Test
    public void testConsultaParametrizadaPaginada() {
        final String orden = "from Persona as p where p.nombre between :primerParametro and :segundoParametro";
        Map<String, String> parametros = new HashMap<>();
        parametros.put("primerParametro", "def");
        parametros.put("segundoParametro", "jkl");
        dao.guardar(persona);
        dao.guardar(new Persona("def"));
        dao.guardar(new Persona("ghi"));
        dao.guardar(new Persona("jkl"));
        assertEquals(1, dao.consulta(orden, parametros, 2, 1).size());
    }
}
