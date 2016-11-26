/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.servicios;

import com.curso.java.modelo.Aficion;
import com.curso.java.modelo.Persona;
import com.curso.java.repos.PersonaRepo;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose maria
 */
@Service
public class ServicioPersona {

    @Autowired
    private PersonaRepo personaRepo;

    public Persona nuevaPersona(Persona persona) {
        return personaRepo.save(persona);
    }

    @Cacheable("persona")
    public List<Persona> todos() {
        LOG.log(Level.INFO, "Desde la base de datos");
        return personaRepo.findAll();
    }

    public List<Persona> buscarPorAficiones(Aficion... aficiones) {
        return personaRepo.findByAficiones(Arrays.asList(aficiones));
    }

    public Persona buscarPorNombre(String nombre) {
        return personaRepo.findByNombre(nombre);
    }

    public Integer cambiarNombre(String nombreNuevo, String nombreAntiguo) {
        return personaRepo.cambiarNombre(nombreNuevo, nombreAntiguo);
    }

    public void borrarUsuariosInactivos() {
        personaRepo.borrarUsuariosInactivos();
    }
    private static final Logger LOG = Logger.getLogger(ServicioPersona.class.getName());
}
