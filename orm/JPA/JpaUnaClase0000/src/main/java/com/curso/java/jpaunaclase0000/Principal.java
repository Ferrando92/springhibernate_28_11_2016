/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.jpaunaclase0000;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.curso.java.entidades.Persona;

/**
 *
 * @author jose maria
 */
public class Principal {

    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaUnaClasePU");
        System.out.println("El modelo de datos ha sido creado correctamente");
        System.out.println("Intentando hacer persistente una nueva persona");
        Long clave = insertarPersona(emf);
        System.out.println("Insertada nueva persona con clave " + clave);
        System.out.println("Personas existentes en la base de datos");
        List<Persona> personas = mostrarPersonas(emf);
        if (personas.isEmpty()) {
            System.out.println("No se encuentran personas");
        } else {
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
        System.out.println("Intentando actualizar el nombre de la persona con clave " + clave);
        Persona p = actualizarPersona(clave, emf);
        System.out.println("Los datos de la nueva persona son " + p);
        System.out.println("Intentando borrar la persona con clave " + p);
        borrarPersona(p.getId(), emf);
        personas = mostrarPersonas(emf);
        if (personas.isEmpty()) {
            System.out.println("No se encuentran personas");
        } else {
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
        emf.close();
    }

    static List<Persona> mostrarPersonas(EntityManagerFactory emf) {
        List<Persona> personas = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Persona> q = em.createQuery("select p from Persona p",Persona.class);
            personas = q.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha ourrido un error", e);
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return personas;
    }

    static Long insertarPersona(EntityManagerFactory emf) {
        Long clave = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Persona p = new Persona("abc");
            em.persist(p);
            em.getTransaction().commit();
            clave = p.getId();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha ourrido un error", e);
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return clave;
    }

    private static Persona actualizarPersona(Long clave, EntityManagerFactory emf) {
        Persona p = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            p = em.find(Persona.class, clave);
            p.setNombre("xyz");
            //Nota: la llamada al método merge es innecesaria
            p = em.merge(p);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha ourrido un error", e);
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return p;
    }

    private static Persona borrarPersona(Long clave, EntityManagerFactory emf) {
        Persona p = null;
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            p = em.find(Persona.class, clave);
            em.remove(p);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha ourrido un error", e);
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return p;
    }
}
