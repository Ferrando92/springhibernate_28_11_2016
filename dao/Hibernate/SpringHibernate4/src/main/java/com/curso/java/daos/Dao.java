/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.daos;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Chema
 * @param <T>
 */
public interface Dao<T> {

    T guardar(final T objeto);

    T borrar(final T objeto);

    Collection<T> consulta();

    Collection<T> consulta(final String texto, final Map<String, String> parametros);

    Collection<T> consulta(final String texto, final Map<String, String> parametros, final Integer desde, final Integer cuantos);
}
