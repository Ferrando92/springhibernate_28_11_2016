/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.dao;

import com.curso.beans.Usuario;
import com.curso.utilidades.HibernateUtil;
import java.util.Collection;
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
    private final EnTransaccion<Usuario> ent = new EnTransaccion<>();
    private static final Logger LOG = Logger.getLogger(UsuarioDaoHibernate.class.getName());

    @FunctionalInterface
    private interface Transaccional<T> {

        T ejecutar(Session s);

    }

    private class EnTransaccion<T> {

        T run(Transaccional<T> t) {
            Session s = null;
            try {
                s = sf.getCurrentSession();
                s.getTransaction().begin();
                T r = t.ejecutar(s);
                s.getTransaction().commit();
                return r;
            } catch (HibernateException e) {
                LOG.log(Level.SEVERE, e.toString());
                if (s != null) {
                    s.getTransaction().rollback();
                }
                return null;
            }
        }
    }

    @Override
    public Usuario guardar(Usuario nuevo) {
        return ent.run(s -> {
            s.persist(nuevo);
            return nuevo;
        });
    }

    @Override
    public Usuario actualizar(Usuario existente) {
        return ent.run(s -> {
            s.update(existente);
            return existente;
        });
    }

    @Override
    public Usuario borrar(Usuario existente) {
        return ent.run(s -> {
            s.delete(existente);
            return existente;
        });
    }

    @Override
    public Collection<Usuario> todos() {
        return new EnTransaccion<Collection<Usuario>>().
                run(s -> s.createQuery("from Usuario").list());
    }

    @Override
    public Usuario encontrar(Usuario existente) {
        return ent.run(s -> (Usuario) s.get(Usuario.class, existente.getId()));
    }
}
