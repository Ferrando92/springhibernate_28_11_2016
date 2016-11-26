package com.curso.springdaohibernate.dao.hibernate;

import com.curso.springdaohibernate.dao.PersonaDao;

import com.curso.springdaohibernate.dominio.Aficion;
import com.curso.springdaohibernate.dominio.Persona;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PersonaDaoHibernate extends HibernateDaoSupport implements PersonaDao {

    public PersonaDaoHibernate() {
    }

    @Override
    public List<Persona> getPersonas() {
        return (List<Persona>) getHibernateTemplate().find("from Persona p order by p.nombre");
    }

    @Override
    public Persona insertPersona(final Persona una) {
        getHibernateTemplate().saveOrUpdate(una);
        return una;
    }

    @Override
    public void updatePersona(final Persona una) {
        getHibernateTemplate().update(una);
    }

    @Override
    public void deletePersona(final Persona una) {
        getHibernateTemplate().delete(una);
    }

    @Override
    public Persona getPersona(final Integer id) {
        return getHibernateTemplate().load(Persona.class, id);
    }

    @Override
    public List<Persona> getPorNombreParecido(final String nombre) {
        final String orden = "from Persona p where p.nombre like :nombre";
        return getHibernateTemplate()
                .execute(
                        session -> session.createQuery(orden).setString("nombre", "%" + nombre + "%").list()
                );
    }

    @Override
    public Long getNumeroDePersonas() {
        List lista = getHibernateTemplate().find("select count(*) from Persona");
        return (Long) lista.get(0);
    }

    @Override
    public List<Aficion> getAficiones(final Integer id) {
        return (List<Aficion>) getHibernateTemplate().find("select p.aficionesInternas from Persona p where p.id = ?",
                new Object[]{id});
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Aficion> getAficionesDeOtraManera(final Integer id) {
        return getHibernateTemplate().execute(session -> {
            Persona p = (Persona) session.load(Persona.class, id);
            return p.getAficiones();
        });
    }

    @Override
    public List<Aficion> getAficionesDeOtraManeraMas(Integer id) {
        Persona p = getHibernateTemplate().load(Persona.class, id);
        return p.getAficiones();
    }
}
