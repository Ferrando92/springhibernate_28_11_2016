package com.curso.ejemplojpamulti;

import com.curso.ejemplojpamulti.dao.Dao;
import com.curso.ejemplojpamulti.entidad.Factura;
import com.curso.ejemplojpamulti.entidad.Persona;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        Dao<Persona> daoPersona = ctx.getBean(Dao.class);
        Persona p = daoPersona.insertarUno(new Persona("abc" + System.currentTimeMillis()));
        System.out.println("Clave persona: " + p.getId());
        Dao<Factura> daoFactura = ctx.getBean(Dao.class);
        Factura f = daoFactura.insertarDos(new Factura(new Long(System.currentTimeMillis()).doubleValue()));
        System.out.println("Clave factura: " + f.getId());
    }
}
