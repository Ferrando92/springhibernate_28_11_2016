/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.dao;

import com.curso.java.entidades.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose maria
 */
@Repository
@Transactional
public class SimpleDao implements Dao {

    @PersistenceContext
    private EntityManager em;

    @Override    
    public Vehiculo guardar(Vehiculo vehiculo) {
        em.persist(vehiculo);
        return vehiculo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> todos() {
        return em.createQuery("select v from Vehiculo v").getResultList();
    }
}
