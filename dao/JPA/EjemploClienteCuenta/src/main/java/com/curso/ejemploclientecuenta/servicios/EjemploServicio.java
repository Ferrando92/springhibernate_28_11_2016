/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploclientecuenta.servicios;

import com.curso.ejemploclientecuenta.entidades.Cliente;
import com.curso.ejemploclientecuenta.entidades.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose maria
 */
@Repository
@Transactional(readOnly = true)
@Service
public class EjemploServicio {

    @PersistenceContext
    private EntityManager em;

    @Transient
    @Transactional(propagation = Propagation.NEVER)
    public Cliente crearCliente() {
        return new Cliente("abc" + System.currentTimeMillis());
    }

    @Transient
    @Transactional(propagation = Propagation.NEVER)
    public Cuenta crearCuenta() {
        return new Cuenta(Math.random());
    }

    @Transient
    @Transactional(propagation = Propagation.NEVER)
    public void asignarCuenta(Cliente cliente, Cuenta... cuentas) {
        assert cliente.getId() == null : "El id del cliente debe ser nulo en este método";
        for (Cuenta cuenta : cuentas) {
            assert cuenta.getId() == null : "El id de la cuenta debe ser nulo en este método";
            cliente.getCuentas().add(cuenta);
            cuenta.setCliente(cliente);
        }
        assert cliente.getCuentas().size() == cuentas.length;
        for (Cuenta cuenta : cuentas) {
            assert cuenta.getCliente() == cliente;
        }
    }

    public List<Cliente> getClientes() {
        return em.createQuery("select distinct c from Cliente as c join fetch c.cuentas").getResultList();
    }

    @Transactional(readOnly = false)
    public Long guardarCliente(Cliente cliente) {
        em.persist(cliente);
        return cliente.getId();

    }

    public Cliente localizarCliente(Long clave) {
        return em.find(Cliente.class, clave);
    }

    public Cliente autenticar(Cliente cliente) {
        TypedQuery<Cliente> q = em.createNamedQuery("Cliente.findByName", Cliente.class);
        return q.setParameter("parametro", cliente.getNombre()).getSingleResult();
    }
}
