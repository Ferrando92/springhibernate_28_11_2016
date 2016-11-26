/*
 * ContactoDao.java
 *
 * Created on 5 de junio de 2007, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaojpa.dao;

import com.curso.springdaojpa.modelo.Contacto;
import java.util.Collection;

/**
 *
 * @author user
 */
public interface ContactoDao {

    Collection<Contacto> getTodosLosContactos();

    Long insertarContacto(Contacto c);
}
