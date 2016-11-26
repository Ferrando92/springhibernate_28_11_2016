/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.ciclovida;

import com.curso.spring.beans.Usuario;
import org.springframework.beans.factory.ObjectFactory;

/**
 *
 * @author user
 */
public class FactoriaUsuarioBean {

    private ObjectFactory<Usuario> factoria;

    public void setFactoria(ObjectFactory<Usuario> factoria) {
        this.factoria = factoria;
    }

    public Usuario getNuevoUsuario() {
        return factoria.getObject();
    }
}
