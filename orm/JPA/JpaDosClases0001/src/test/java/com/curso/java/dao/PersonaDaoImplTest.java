/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.dao;

import com.curso.java.entidades.Aficion;
import com.curso.java.entidades.Persona;
import java.util.List;
import org.hibernate.LazyInitializationException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jose maria
 */
public class PersonaDaoImplTest {

    private static PersonaDao instancia;

    @BeforeClass
    public static void init() {
        instancia = PersonaManager.getInstancia().getPersonaDao();
    }

    @After
    public void limpiar() {
        List<Persona> personas = instancia.getPersonas();
        for (Persona persona : personas) {
            instancia.borrar(persona);
        }
        assertTrue(instancia.getPersonas().isEmpty());
    }

    /**
     * Test of guardar method, of class PersonaDaoImpl.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Persona persona = new Persona("abc");
        assertTrue(persona.getId() == null);
        Persona result = instancia.guardar(persona);
        assertTrue(result.getId() != null);
        assertEquals(result.getNombre(), "abc");
    }

    /**
     * Test of actualizar method, of class PersonaDaoImpl.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Persona persona = new Persona("abc");
        instancia.guardar(persona);
        persona.setNombre("xyz");
        instancia.actualizar(persona);
        Persona result = instancia.buscar(persona.getId());
        assertEquals(result.getNombre(), "xyz");
    }

    /**
     * Test of borrar method, of class PersonaDaoImpl.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        Persona persona = new Persona("abc");
        instancia.guardar(persona);
        instancia.borrar(persona);
        List<Persona> lista = instancia.getPersonas();
        assertEquals(lista.size(), 0);
    }

    /**
     * Test of getPersonas method, of class PersonaDaoImpl.
     */
    @Test
    public void testGetPersonas_0args() {
        System.out.println("getPersonas");
        for (int i = 0; i < 5; i++) {
            Persona p = new Persona("Persona" + i);
            instancia.guardar(p);
        }
        List<Persona> result = instancia.getPersonas();
        assertEquals(result.size(), 5);
    }

    /**
     * Test of getPersonas method, of class PersonaDaoImpl.
     */
    @Test
    public void testGetPersonas_String() {
        System.out.println("getPersonas por nombre");
        for (int i = 0; i < 5; i++) {
            Persona p = new Persona("Persona" + i);
            instancia.guardar(p);
        }
        List<Persona> result = instancia.getPersonas("Persona3");
        assertEquals(result.size(), 1);
    }

    /**
     * Test of buscar method, of class PersonaDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Persona expResult = new Persona("123");
        instancia.guardar(expResult);
        Persona result = instancia.buscar(expResult.getId());
        assertEquals(expResult, result);
    }

    /**
     * Test of testGuardarPersonaAficionesConError method, of class
     * PersonaDaoImpl.
     */
    @Test(expected = LazyInitializationException.class)
    public void testGuardarPersonaAficionesConError() {
        System.out.println("guardarPersonaAficionesConError");
        Persona persona = new Persona("abc");
        Aficion a1 = new Aficion("1");
        Aficion a2 = new Aficion("2");
        persona.getAficiones().add(a1);
        persona.getAficiones().add(a2);
        a1.setPersona(persona);
        a2.setPersona(persona);
        Persona resultado = instancia.guardar(persona);
        List<Aficion> lista = instancia.getAficiones(resultado);
        assertEquals(lista.getClass().getName(), "org.hibernate.collection.internal.PersistentBag");
        assertEquals(lista.size(), 2);
    }

    /**
     * Test of testGuardarPersonaAficionesSinError method, of class
     * PersonaDaoImpl.
     */
    @Test
    public void testGuardarPersonaAficionesSinError() {
        System.out.println("guardarPersonaAficionesSinError");
        Persona persona = new Persona("abc");
        Aficion a1 = new Aficion("1");
        Aficion a2 = new Aficion("2");
        persona.getAficiones().add(a1);
        persona.getAficiones().add(a2);
        a1.setPersona(persona);
        a2.setPersona(persona);
        Persona resultado = instancia.guardar(persona);
        List<Aficion> lista = instancia.getAficionesSinError(resultado);
        assertEquals(lista.size(), 2);
        assertEquals(lista.get(0).getNombre(), "1");
        assertEquals(lista.get(1).getNombre(), "2");
    }
}
