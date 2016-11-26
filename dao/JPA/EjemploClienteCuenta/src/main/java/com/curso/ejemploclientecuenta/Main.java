/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploclientecuenta;

import com.curso.ejemploclientecuenta.entidades.Cliente;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.curso.ejemploclientecuenta.servicios.EjemploServicio;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author jose maria
 */
public class Main {

    private ApplicationContext ctx;
    private EjemploServicio ejemploServicio;
    private Long clave;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.initSpring();
        m.testClientesCuentas();
        m.testTodosLosClientes();
        m.testAutenticar();
        m.testLocalizarCliente();
    }

    void initSpring() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ejemploServicio = ctx.getBean(EjemploServicio.class);
        System.out.format("Contexto cargado. Servicio %s encontrado\n", ctx);
    }

    void testAutenticar() {
        Cliente u = ejemploServicio.crearCliente();
        u.setNombre("NombreUsuario6");
        try {
            System.out.println(ejemploServicio.autenticar(u) != null ? "Autenticado" : "No autenticado");
        } catch (DataAccessException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Ha ocurrido un error", e);
        }
    }

    void testLocalizarCliente() {
        System.out.format("Buscando al cliente con Id %s\n", clave);
        Cliente cliente = ejemploServicio.localizarCliente(clave);
        System.out.println(cliente != null ? "Encontrado" : "No encontrado");
    }

    void testTodosLosClientes() {
        System.out.println("Mostrando a todos los clientes registrados...");
        ejemploServicio.getClientes().forEach(out::println);
    }

    void testClientesCuentas() {
        Cliente cliente = ejemploServicio.crearCliente();
        ejemploServicio.asignarCuenta(cliente, ejemploServicio.crearCuenta(), ejemploServicio.crearCuenta());
        clave = ejemploServicio.guardarCliente(cliente);
        System.out.println("Cliente con clave " + clave + " guardado");
    }
}
