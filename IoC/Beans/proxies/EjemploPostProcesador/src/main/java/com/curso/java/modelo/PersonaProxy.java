/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class PersonaProxy implements Persona {

    private static final Logger LOG = Logger.getLogger(PersonaProxy.class.getName());
    private Persona personaReal;

    public void setPersonaReal(Persona personaReal) {
        this.personaReal = personaReal;
    }

    @Override
    public String getNombre() {
        LOG.log(Level.INFO, "Ejecutando getNombre en el proxy");
        return personaReal.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        LOG.log(Level.INFO, "Ejecutando setNombre en el proxy: {0}", nombre);
        personaReal.setNombre(nombre);
    }

}
