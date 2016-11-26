/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplojpamulti.dao;

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
public class Dao<T> {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em1;
    @PersistenceContext(unitName = "entityManagerFactory2")
    private EntityManager em2;

    @Transactional("uno")
    public T insertarUno(T objeto) {
        em1.persist(objeto);
        return objeto;
    }

    @Transactional("dos")
    public T insertarDos(T objeto) {
        em2.persist(objeto);
        return objeto;
    }
}
