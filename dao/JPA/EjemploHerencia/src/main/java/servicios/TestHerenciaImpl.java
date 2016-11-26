/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import beans.Empresa;
import beans.single_table.Empleado;
import beans.single_table.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chema
 */
@Repository
@Transactional
public class TestHerenciaImpl implements TestHerencia {

    @PersistenceContext
    private EntityManager em;

    public void test() {
        Empresa e = new Empresa();
        Empleado emp = new Empleado();
        e.getPersonal().add(emp);
        emp.setEmpresa(e);
        em.persist(e);
        List<Persona> todos = em.createQuery("select p from PersonaSingleTable as p").getResultList();
        todos.forEach(persona -> 
            System.out.println(persona.getClass().getSimpleName())
        );
    }
}
