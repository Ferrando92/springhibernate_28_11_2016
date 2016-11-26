/*
 * ServicioClienteImpl.java
 *
 * Created on 6 de junio de 2007, 11:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaojpa.servicio;

import com.curso.springdaojpa.dao.ComercialDao;
import com.curso.springdaojpa.dao.ContactoDao;
import com.curso.springdaojpa.modelo.Contacto;
import com.curso.springdaojpa.modelo.Comercial;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author user
 */
public class ServicioClienteImpl implements ServicioCliente {

    private ContactoDao contactoDao;
    private ComercialDao comercialDao;

    /**
     * Creates a new instance of ServicioClienteImpl
     */
    public ServicioClienteImpl() {
    }

    public void setContactoDao(ContactoDao contactoDao) {
        this.contactoDao = contactoDao;
    }

    public void setComercialDao(ComercialDao comercialDao) {
        this.comercialDao = comercialDao;
    }

    @Override
    public Collection<Comercial> getTodosLosComerciales() {
        return comercialDao.getTodosLosComerciales();
    }

    @Override
    public Long insertarComercial(Comercial c) {
        comercialDao.insertarComercial(c);
        return c.getId();
    }

    @Override
    public Collection<Contacto> getTodosLosContactos() {
        return contactoDao.getTodosLosContactos();
    }

    @Override
    public Long insertarContacto(Contacto c) {
        contactoDao.insertarContacto(c);
        return c.getId();
    }

    @Override
    public void asignarContacto(Comercial comercial, Contacto contacto) {
        comercialDao.asignarContacto(comercial, contacto);
    }

    @Override
    public List<Contacto> getContactosDeUnComercial(Comercial comercial) {
        return comercialDao.getComercial(comercial.getId()).getContactos();
    }
}
