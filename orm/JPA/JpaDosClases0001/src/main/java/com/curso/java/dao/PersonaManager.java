/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jose maria
 */
public class PersonaManager {

    private static volatile PersonaManager personaManager;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaUnaClasePU");

    private PersonaManager() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (emf != null) {
                    emf.close();
                }
            }
        });
    }

    public static PersonaManager getInstancia() {
        if (personaManager == null) {
            personaManager = new PersonaManager();
        }
        return personaManager;
    }

    public PersonaDao getPersonaDao() {
        return new PersonaDaoImpl(emf);
    }
}
