/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.implementacion;

import com.curso.spring.especificacion.Usuario;

/**
 *
 * @author jose maria
 */
public class UsuarioImpl implements Usuario {

    private String clave;

    @Override
    public String getClave() {
        return clave;
    }

    @Override
    public void setClave(String clave) {
        this.clave = clave;
    }
}
