/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.metodohibernate0001;

import com.curso.beans.Usuario;
import com.curso.dao.UsuarioDao;
import com.curso.utilidades.HibernateUtil;
import static java.lang.System.out;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 *
 * @author Administrador
 */
public class Principal {

    @Inject
    private UsuarioDao dao;

    public UsuarioDao getDao() {
        return dao;
    }

    /**
     * @param event
     */
    public void main(@Observes ContainerInitialized event) {
        Usuario uno = new Usuario("abc", "xyz");
        dao.guardar(uno);
        dao.todos().forEach(out::println);
        uno.setNombre("123");
        Usuario actualizado = dao.actualizar(uno);
        dao.todos().forEach(out::println);
        dao.borrar(actualizado);
        if (dao.todos().isEmpty()) {
            System.out.println("No hay usuarios");
        } else {
            System.out.println("Algo va mal");
        }
        HibernateUtil.getSessionFactory().close();
        System.exit(0);
    }

}
