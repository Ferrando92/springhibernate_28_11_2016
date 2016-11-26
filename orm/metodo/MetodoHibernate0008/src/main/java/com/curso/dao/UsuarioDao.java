/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.dao;

import com.curso.beans.Usuario;
import java.util.Collection;

/**
 *
 * @author Administrador
 */
public interface UsuarioDao {
    Usuario encontrar(Usuario id);
    Usuario guardar(Usuario nuevo);
    Usuario actualizar(Usuario existente);
    Usuario borrar(Usuario existente);
    Collection<Usuario> todos();
}
