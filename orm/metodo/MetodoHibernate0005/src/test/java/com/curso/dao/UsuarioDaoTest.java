/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.dao;

import com.curso.beans.Usuario;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author usuario
 */
public class UsuarioDaoTest {

    private static final UsuarioDao instance = new UsuarioDaoHibernate();

    public UsuarioDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        instance.todos().forEach(instance::borrar);
    }

    /**
     * Test of guardar method, of class UsuarioDao.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Usuario nuevo = new Usuario("a", "b");
        Usuario result = instance.guardar(nuevo);
        assertNotNull(result.getId());
    }

    /**
     * Test of actualizar method, of class UsuarioDao.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Usuario nuevo = instance.guardar(new Usuario("a", "b"));
        Usuario u = instance.encontrar(nuevo.getId());
        u.setNombre("xyz");
        nuevo = instance.actualizar(u);
        u = instance.encontrar(nuevo.getId());
        assertEquals("xyz", u.getNombre());
    }

    /**
     * Test of borrar method, of class UsuarioDao.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        Usuario nuevo = instance.guardar(new Usuario("a", "b"));
        assertEquals(1, instance.todos().size());
        instance.borrar(nuevo);
        assertTrue(instance.todos().isEmpty());
    }
//
//    /**
//     * Test of todos method, of class UsuarioDao.
//     */
    @Test
    public void testTodos() {
        System.out.println("todos");
        List<Usuario> usuarios = Arrays.asList(new Usuario(),new Usuario());
        List<Usuario> guardados = usuarios.stream().map(instance::guardar).collect(Collectors.toList());
        assertEquals(2, guardados.size());        
    }
}
