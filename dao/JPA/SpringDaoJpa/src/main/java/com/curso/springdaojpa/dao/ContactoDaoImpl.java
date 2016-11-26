/*
 * ContactoDaoImpl.java
 *
 * Created on 5 de junio de 2007, 12:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaojpa.dao;

import com.curso.springdaojpa.modelo.Contacto;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class ContactoDaoImpl implements ContactoDao {

    @PersistenceContext
    private EntityManager em;

    /** Creates a new instance of ContactoDaoImpl */
    public ContactoDaoImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Contacto> getTodosLosContactos() {
        Query query = em.createQuery("select c from Contacto as c");
        return query.getResultList();
    }

    @Override
    public Long insertarContacto(Contacto c) {
        em.persist(c);
        return c.getId();
    }
}
