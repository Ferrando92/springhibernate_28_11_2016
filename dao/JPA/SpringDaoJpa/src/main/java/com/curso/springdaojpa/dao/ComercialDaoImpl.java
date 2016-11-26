/*
 * ComercialDaoImpl.java
 *
 * Created on 6 de junio de 2007, 11:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaojpa.dao;

import com.curso.springdaojpa.modelo.Contacto;
import com.curso.springdaojpa.modelo.Comercial;
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
public class ComercialDaoImpl implements ComercialDao {

    @PersistenceContext
    private EntityManager em;

    /** Creates a new instance of ComercialDaoImpl */
    public ComercialDaoImpl() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Comercial> getTodosLosComerciales() {
        Query query = em.createQuery("select c from Comercial as c");
        return query.getResultList();
    }

    @Override
    public Long insertarComercial(Comercial c) {
        em.persist(c);
        return c.getId();
    }

    @Override
    public void asignarContacto(Comercial comercial, Contacto contacto) {
        comercial.getContactos().add(contacto);
        contacto.setComercial(comercial);
        em.persist(comercial);
    }

    @Override
    public Comercial getComercial(Long id) {
        return em.find(Comercial.class, id);
    }
}
