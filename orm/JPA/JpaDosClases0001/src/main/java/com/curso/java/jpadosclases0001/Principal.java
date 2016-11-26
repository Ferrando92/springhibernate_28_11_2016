/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.jpadosclases0001;

import com.curso.java.dao.PersonaDao;
import com.curso.java.dao.PersonaManager;
import com.curso.java.entidades.Aficion;
import com.curso.java.entidades.Persona;
import java.util.List;

/**
 *
 * @author jose maria
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDao personaDao = PersonaManager.getInstancia().getPersonaDao();
        System.out.println("El modelo de datos ha sido creado correctamente.Ver la base de datos 'curso' en NetBeans");
        System.out.println("Realizando operaciones persistentes...");
        System.out.println("Haciendo persistente un objeto de tipo persona");
        Persona persona = new Persona("abc");
        personaDao.guardar(persona);
        System.out.println("Los datos de la persona hecha persistente son: " + persona);
        System.out.println("Modificando un objeto de tipo persona");
        persona.setNombre("xyz");
        personaDao.actualizar(persona);
        System.out.println("Localizando la persona para comprobar que ha sido actualizada correctamente");
        Persona otra = personaDao.buscar(persona.getId());
        System.out.println("Los datos de la persona modificada son: " + otra);
        System.out.println("Elminando un objeto de tipo persona");
        personaDao.borrar(otra);
        System.out.println("Intentando localizar la persona borrada para comprobar que no se encuentra");
        Persona otraMas = personaDao.buscar(otra.getId());
        System.out.println("La persona buscada " + (otraMas == null ? "no se encuentra" : "sí se encuentra"));
        System.out.println("Probando las consultas...");
        System.out.println("Haciendo persistentes cinco personas");
        for (int i = 0; i < 5; i++) {
            Persona p = new Persona("Persona" + i);
            Aficion a = new Aficion("Afición" + i);
            p.getAficiones().add(a);
            a.setPersona(p);
            personaDao.guardar(p);
        }
        System.out.println("Comprobando que hay cinco personas en el sistema");
        List<Persona> lista = personaDao.getPersonas();
        for (Persona persona1 : lista) {
            System.out.println(persona1);
//            System.out.println(persona1.getAficiones());
        }
        System.out.println("Probando la consulta por nombre");
        lista = personaDao.getPersonas("Persona3");
        System.out.println("El número de personas encontradas es " + lista.size());
        System.out.println("Sus datos son: " + lista.get(0));
        List<Aficion> aficiones = personaDao.getAficionesSinError(lista.get(0));
        System.out.println("Aficiones: " + aficiones);
        List<Persona> listaPersonas = personaDao.getAficionesSinErrorDeOtraManera(lista.get(0));
        System.out.println("Persona: " + listaPersonas.get(0));
        System.out.println("Aficiones: " + listaPersonas.get(0).getAficiones());
    }
}
