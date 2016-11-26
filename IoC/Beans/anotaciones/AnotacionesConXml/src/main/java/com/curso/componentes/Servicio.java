/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.componentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class Servicio {
    @Autowired
    private Repositorio repo;

    @Override
    public String toString() {
        return "Servicio{" + "repo=" + repo + '}';
    }
}
