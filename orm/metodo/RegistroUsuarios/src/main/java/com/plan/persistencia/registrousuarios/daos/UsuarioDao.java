/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.persistencia.registrousuarios.daos;

import com.plan.persistencia.registrousuarios.modelos.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author usuario
 */
public class UsuarioDao {

    private final SessionFactory emf;

    public UsuarioDao(SessionFactory emf) {
        this.emf = emf;
    }

    public Integer contarUsuarios() {
        Session em = emf.getCurrentSession();
        em.getTransaction().begin();
        Integer n = em.createQuery("from Usuario").list().size();
        em.getTransaction().commit();
        return n;
    }

    public Usuario guardarUsuario(Usuario u) {
        Session em = emf.getCurrentSession();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        return u;
    }

    public Boolean existe(Usuario usuario) {
        final String orden = "from Usuario u where u.nombre = :nombre and u.clave= :clave";
        Session em = emf.getCurrentSession();
        em.getTransaction().begin();
        Query q = em.createQuery(orden);
        q.setParameter("nombre", usuario.getNombre());
        q.setParameter("clave", usuario.getClave());
        Boolean n = !q.list().isEmpty();
        em.getTransaction().commit();
        return n;
    }

}
