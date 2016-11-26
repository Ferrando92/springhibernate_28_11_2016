package com.curso.springdaohibernateanotaciones.dao;

import com.curso.springdaohibernateanotaciones.dominio.Aficion;
import com.curso.springdaohibernateanotaciones.dominio.Persona;

import java.util.List;

public interface PersonaDao {
    List<Persona> getPersonas();

    Persona insertPersona(Persona una);

    void updatePersona(Persona una);

    void deletePersona(Persona una);

    Persona getPersona(Integer id);

    List<Persona> getPorNombreParecido(String nombre);

    Long getNumeroDePersonas();
    
    List<Aficion> getAficiones(Integer id);

    List<Aficion> getAficionesDeOtraManera(Integer id);

    List<Aficion> getAficionesDeOtraManeraMas(Integer id);
}
