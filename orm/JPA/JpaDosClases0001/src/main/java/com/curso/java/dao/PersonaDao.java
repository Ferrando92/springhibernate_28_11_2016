/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.dao;

import com.curso.java.entidades.Aficion;
import com.curso.java.entidades.Persona;
import java.util.List;

/**
 *
 * @author jose maria
 */
public interface PersonaDao {

    Persona guardar(Persona persona);

    Persona actualizar(Persona persona);

    Persona borrar(Persona persona);

    Persona buscar(Long id);

    List<Persona> getPersonas();

    List<Persona> getPersonas(String nombre);

    List<Aficion> getAficiones(Persona persona);

    List<Aficion> getAficionesSinError(Persona persona);

    List<Persona> getAficionesSinErrorDeOtraManera(Persona persona);

}
