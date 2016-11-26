/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.curso.java.entidades.Aficion;
import com.curso.java.entidades.Persona;

/**
 *
 * @author jose maria
 */
class PersonaDaoImpl implements PersonaDao {

    private static final Logger LOG = Logger.getLogger(PersonaDaoImpl.class.getName());
    private final EntityManagerFactory emf;

    PersonaDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
        assert this.emf != null : "La factoría de EntityManagers es nula";
    }

    @Override
    public Persona guardar(Persona persona) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(persona);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return persona;
    }

    @Override
    public Persona actualizar(Persona persona) {
        Persona otra = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            otra = em.find(Persona.class, persona.getId());
            otra.setNombre(persona.getNombre());
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return otra;
    }

    @Override
    public Persona borrar(Persona persona) {
        Persona otra = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            otra = em.find(Persona.class, persona.getId());
            em.remove(otra);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return otra;
    }

    @Override
    public List<Persona> getPersonas() {
        List<Persona> resultado = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            resultado = em.createNamedQuery("persona.findAll",Persona.class).getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return resultado;
    }

    @Override
    public List<Persona> getPersonas(String nombre) {
        List<Persona> resultado = null;
        String consulta = "select p from Persona as p where p.nombre like :nombre";
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<Persona> q = em.createQuery(consulta,Persona.class);
            q.setParameter("nombre", "%" + nombre);
            resultado = q.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return resultado;
    }

    @Override
    public Persona buscar(Long id) {
        Persona otra = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            otra = em.find(Persona.class, id);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return otra;
    }

    @Override
    public List<Aficion> getAficiones(Persona persona) {
        List<Aficion> aficiones = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Persona otra = em.find(Persona.class, persona.getId());
            aficiones = otra.getAficiones();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return aficiones;
    }

    @Override
    public List<Aficion> getAficionesSinError(Persona persona) {
        List<Aficion> aficiones = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Persona otra = em.find(Persona.class, persona.getId());
            aficiones.addAll(otra.getAficiones());
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return aficiones;
    }

    @Override
    public List<Persona> getAficionesSinErrorDeOtraManera(Persona persona) {
        final String orden = "select p from Persona as p left join fetch p.aficiones Aficion where p.nombre = :primerParametro";
        List<Persona> personas = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<Persona> q = em.createQuery(orden,Persona.class);
            q.setParameter("primerParametro", persona.getNombre());
            personas = q.getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha oourrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return personas;
    }
}
