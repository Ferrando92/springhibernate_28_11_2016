/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.ejemplosproxy;

import com.curso.spring.especificacion.Persona;
import com.curso.spring.especificacion.Usuario;
import com.curso.spring.proxies.SimpleProxy;

/**
 *
 * @author jose maria
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object obj = SimpleProxy.crear(Persona.class, Usuario.class);
        Persona persona = (Persona) obj;
        persona.setNombre("abc");
        System.out.println("El nombre es " + persona.getNombre());
        Usuario usuario = (Usuario) obj;
        usuario.setClave("xyz");
        System.out.println("La clave es " + usuario.getClave());
        System.out.println("Fin");
    }

}
