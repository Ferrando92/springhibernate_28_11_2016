/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.spring.proxies;

import com.curso.spring.especificacion.Persona;
import com.curso.spring.especificacion.Usuario;
import com.curso.spring.implementacion.PersonaImpl;
import com.curso.spring.implementacion.UsuarioImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author jose maria
 */
public class SimpleProxy implements InvocationHandler {

    private final Persona persona;
    private final Usuario usuario;

    private SimpleProxy() {
        persona = new PersonaImpl();
        usuario = new UsuarioImpl();
    }

    public static Object crear(Class... interfaces) {
        InvocationHandler handler = new SimpleProxy();
        ClassLoader loader = handler.getClass().getClassLoader();
        return Proxy.newProxyInstance(loader, interfaces, handler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String metodo = method.getName();
        switch (metodo) {
            case "getNombre":
                return persona.getNombre();
            case "setNombre":
                persona.setNombre((String) args[0]);
                return null;
        }
        switch (metodo) {
            case "getClave":
                return usuario.getClave();
            case "setClave":
                usuario.setClave((String) args[0]);
                return null;
            default:
                throw new IllegalAccessException("El método " + metodo + " no está definido");
        }
    }
}
