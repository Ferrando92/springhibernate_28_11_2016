/*
 * ServicioEmpleados.java
 *
 * Created on 3 de mayo de 2007, 18:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.java.entidades;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class ServicioEmpleados {

    private final EntityManager em;

    public ServicioEmpleados(EntityManager em) {
        this.em = em;
    }

    public Empleado crearEmpleado(Long id, String nombre, Long salario) {
        Empleado emp = new Empleado(id);
        emp.setNombre(nombre);
        emp.setSalario(salario);
        em.persist(emp);
        return emp;
    }

    public void borrarEmpleado(Long id) {
        Empleado emp = buscarEmpleado(id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Jefe crearJefe(long id, String nombre, long salario, double incentivos) {
        Jefe jefe = new Jefe(id);
        jefe.setNombre(nombre);
        jefe.setSalario(salario);
        jefe.setIncentivos(incentivos);
        em.persist(jefe);
        return jefe;
    }

    public Empleado incrementarSalario(Long id, Long cantidad) {
        Empleado emp = em.find(Empleado.class, id);
        if (emp != null) {
            emp.setSalario(emp.getSalario() + cantidad);
        }
        return emp;
    }

    public Empleado buscarEmpleado(Long id) {
        return em.find(Empleado.class, id);
    }

    public Collection<Empleado> buscarTodosLosEmpleados() {
        Query query = em.createQuery("SELECT e FROM Empleado e");
        return (Collection<Empleado>) query.getResultList();
    }

    public Collection<Jefe> buscarTodosLosJefes() {
        Query query = em.createQuery("SELECT j FROM Jefe j");
        return (Collection<Jefe>) query.getResultList();
    }
}
