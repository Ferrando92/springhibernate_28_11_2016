/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.entidades.callbacks.listeners;

import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author jose maria
 */
public class ValidacionListener {

    @PrePersist
    @PreUpdate
    private void validar(ClienteListener cliente) {
        if (cliente.getFechaNacimiento().getTime() > new Date().getTime()) {
            throw new IllegalArgumentException("La fecha de nacimiento no es válida");
        }
        if (!cliente.getTelefono().startsWith("+")) {
            throw new IllegalArgumentException("El número de teléfono no es válido");
        }
    }
}
