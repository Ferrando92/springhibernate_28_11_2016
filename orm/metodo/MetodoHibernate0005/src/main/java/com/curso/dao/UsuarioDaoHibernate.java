/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.dao;

import com.curso.beans.Usuario;
import com.curso.utilidades.HibernateUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author usuario
 */
public class UsuarioDaoHibernate implements UsuarioDao {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    private static final Logger LOG = Logger.getLogger(UsuarioDaoHibernate.class.getName());

    @Override
    public Usuario guardar(Usuario nuevo) {
        Session s = null;
        try {
            s = sf.getCurrentSession();
            s.getTransaction().begin();
            s.persist(nuevo);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, e.toString());
            if (s != null) {
                s.getTransaction().rollback();
            }
        }
        return nuevo;
    }

    @Override
    public Usuario actualizar(Usuario existente) {
        Session s = null;
        try {
            s = sf.getCurrentSession();
            s.getTransaction().begin();
            s.update(existente);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, e.toString());
            if (s != null) {
                s.getTransaction().rollback();
            }
        }
        return existente;
    }

    @Override
    public Usuario borrar(Usuario existente) {
        Session s = null;
        try {
            s = sf.getCurrentSession();
            s.getTransaction().begin();
            s.delete(existente);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, e.toString());
            if (s != null) {
                s.getTransaction().rollback();
            }
        }
        return existente;
    }

    @Override
    public Collection<Usuario> todos() {
        Session s = null;
        try {
            s = sf.getCurrentSession();
            s.getTransaction().begin();
            List<Usuario> lista = s.createQuery("from Usuario").list();
            s.getTransaction().commit();
            return lista;
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, e.toString());
            if (s != null) {
                s.getTransaction().rollback();
            }
            return null;
        }
    }

    @Override
    public Usuario encontrar(Serializable id) {
        Session s = null;
        try {
            s = sf.getCurrentSession();
            s.getTransaction().begin();
            Usuario u = (Usuario) s.get(Usuario.class,id);
            s.getTransaction().commit();
            return u;
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, e.toString());
            if (s != null) {
                s.getTransaction().rollback();
            }
            return null;
        }
    }
}
