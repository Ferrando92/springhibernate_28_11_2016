/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.daos;

import java.util.Collection;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chema
 * @param <Persona>
 */
@Repository
@Transactional
public class HibernateDao<Persona> implements Dao<Persona> {

    @Autowired
    private SessionFactory sf;
    @Value("from Persona")
    private String orden;

    /**
     *
     * @param objeto
     * @return
     */
    @Override
    public Persona guardar(final Persona objeto) {
        sf.getCurrentSession().save(objeto);
        return objeto;
    }

    /**
     *
     * @return Collection<Persona>
     */
    @Transactional(readOnly = true)
    @Override
    public Collection<Persona> consulta() {
        return sf.getCurrentSession().createQuery(orden).setCacheable(true).setCacheRegion("todos").list();
    }

    /**
     *
     * @param texto
     * @param parametros
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Collection<Persona> consulta(final String texto, final Map<String, String> parametros) {
        Query q = sf.getCurrentSession().createQuery(texto);
        for (String clave : parametros.keySet()) {
            q.setParameter(clave, parametros.get(clave));
        }
        return q.list();
    }

    /**
     *
     * @param texto
     * @param parametros
     * @param desde
     * @param cuantos
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Collection<Persona> consulta(final String texto, final Map<String, String> parametros, final Integer desde, final Integer cuantos) {
        Query q = sf.getCurrentSession().createQuery(texto);
        for (String clave : parametros.keySet()) {
            q.setParameter(clave, parametros.get(clave));
        }
        q.setFirstResult(desde);
        q.setMaxResults(cuantos);
        return q.list();
    }

    @Override
    public Persona borrar(Persona objeto) {
        sf.getCurrentSession().delete(objeto);
        return objeto;
    }
}
