/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.repos;

import com.curso.java.modelo.Aficion;
import com.curso.java.modelo.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose maria
 */
public interface PersonaRepo extends JpaRepository<Persona, Long> {

    Persona findByNombre(String nombre);

    List<Persona> findByAficiones(List<Aficion> aficiones);

    @Modifying
    @Query("update Persona p set p.nombre = ?1 where p.nombre = ?2")
    @Transactional
    Integer cambiarNombre(String nombreNuevo, String nombreAntiguo);

    @Modifying
    @Transactional
    @Query("delete from Persona p where p.activo = false")
    void borrarUsuariosInactivos();
}
