/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.elementospersistentes;

import com.curso.java.entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ElementosPersistentesPU");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        Usuario usuario = new Usuario("usuario" + System.currentTimeMillis());
        usuario.getSeudonimos().add("uno");
        usuario.getSeudonimos().add("dos");
        usuario.getSeudonimos().add("tres");
        usuario.getSeudonimos().add("uno");
        m.guardar(usuario);
        m.mostrarUsuarios();
    }

    public void guardar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha ocurrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    private void mostrarUsuarios() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Usuario> lista = em.createQuery("select u from Usuario u").getResultList();
        try {
            for (Usuario usuario : lista) {
                System.out.println(usuario);
                for (String s : usuario.getSeudonimos()) {
                    System.out.println(s);
                }
            }
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            LOG.log(Level.ALL, "Ha ocurrido un error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
