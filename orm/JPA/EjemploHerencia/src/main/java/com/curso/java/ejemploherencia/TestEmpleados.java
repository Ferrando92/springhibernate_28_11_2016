/*
 * TestEmpleados.java
 *
 * Created on 3 de mayo de 2007, 18:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.java.ejemploherencia;

import com.curso.java.entidades.Empleado;
import com.curso.java.entidades.Jefe;
import com.curso.java.entidades.ServicioEmpleados;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class TestEmpleados {

    /**
     * Creates a new instance of TestEmpleados
     */
    public TestEmpleados() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("EjemploHerenciaPU");
        EntityManager em = emf.createEntityManager();
        ServicioEmpleados servicioEmpleados = new ServicioEmpleados(em);
// Crear y guardar un empleado
        em.getTransaction().begin();
        Empleado emp = servicioEmpleados.crearEmpleado(158L, "John Doe", 45000L);
        servicioEmpleados.crearJefe(200L, "Un Jefe", 45000L, 1000.0d);
        em.getTransaction().commit();
        System.out.println("Guardado " + emp);
// Buscar un empleado
        emp = servicioEmpleados.buscarEmpleado(158L);
        System.out.println("Encontrado " + emp);
// Todos los empleados
        Collection<Empleado> emps = servicioEmpleados.buscarTodosLosEmpleados();
        System.out.println("Lista de empleados...");
        for (Empleado e : emps) {
            System.out.println("Encontrado empleado: " + e);
        }
// Todos los Jefes
        Collection<Jefe> jefes = servicioEmpleados.buscarTodosLosJefes();
        System.out.println("Lista de empleados...");
        for (Jefe j : jefes) {
            System.out.println("Encontrado jefe: " + j);
        }
// Actualizar un empleado
        em.getTransaction().begin();
        emp = servicioEmpleados.incrementarSalario(158L, 1000L);
        em.getTransaction().commit();
        System.out.println("Actualizado " + emp);
// borrar un empleado
        em.getTransaction().begin();
        servicioEmpleados.borrarEmpleado(158L);
        servicioEmpleados.borrarEmpleado(200L);
        em.getTransaction().commit();
        System.out.println("Empleado 158 borrado");
        System.out.println("Empleado 200 borrado");
// cerrar recursos
        em.close();
        emf.close();
    }
}
