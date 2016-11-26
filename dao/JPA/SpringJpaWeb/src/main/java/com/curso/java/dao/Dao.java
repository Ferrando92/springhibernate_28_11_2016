/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.dao;

import com.curso.java.entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author jose maria
 */
public interface Dao {
    Vehiculo guardar(Vehiculo vehiculo);
    List<Vehiculo> todos();
}
