package com.curso.java.spring3hibernate4;

import com.curso.java.daos.Dao;
import com.curso.java.modelo.Aficion;
import com.curso.java.modelo.Persona;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        System.out.println("Contexto cargado");
        Dao<Persona> dao = ctx.getBean(Dao.class);
        try {
            Persona p = testDaoPersona(dao);
            testCache(ctx, p);
            testDaoPersonaAficion1(dao);
            testDaoPersonaAficion2(dao);
        } catch (DataAccessException e) {
            LOG.log(Level.SEVERE, "Ha ocurrido un error", e);
        }

    }

    private static void testCache(ApplicationContext ctx, Persona p) throws BeansException {
        SessionFactory sf = ctx.getBean(SessionFactory.class);
        assert sf.getCache().containsEntity(Persona.class, p.getId()) : "El objeto no está en caché";
        System.out.println("Entradas en el caché");
        Map entradas = sf.getStatistics()
                .getSecondLevelCacheStatistics("personas")
                .getEntries();
        entradas.keySet().stream().map((clave) -> entradas.get(clave)).forEach((valor) -> {
            System.out.println(valor);
        });
    }

    private static Persona testDaoPersona(Dao<Persona> dao) {
        Persona p = dao.guardar(new Persona("abc"));
        assert p.getId() != null : "La clave primaria es nula";
        System.out.println("La clave primaria de esta persona es " + p.getId());
        Collection<Persona> personas = dao.consulta();
        assert personas.size() == 1 : "Debe haber sólo una persona";
        personas.stream().forEach((persona) -> {
            System.out.println(persona);
        });
        return p;
    }

    private static void testDaoPersonaAficion1(Dao<Persona> dao) {
        Persona p = new Persona("def");
        Aficion a = new Aficion();
        a.setNombre("una cualquiera");
        p.getAficiones().add(a);
        a.setPersona(p);
        p = dao.guardar(p);
        System.out.println(p);        
        final String orden = "select p.aficiones from Persona as p where p.nombre = :primerParametro";
        Map<String, String> parametros = new HashMap<>();
        parametros.put("primerParametro", "def");
        Collection c = dao.consulta(orden, parametros);
        System.out.println(c);        
    }    
    private static void testDaoPersonaAficion2(Dao<Persona> dao) {
        Persona p = new Persona("ghi");
        Aficion a = new Aficion();
        a.setNombre("otra afición");
        p.getAficiones().add(a);
        a.setPersona(p);
        p = dao.guardar(p);
        System.out.println(p);
        final String orden = "select p from Persona as p left join fetch p.aficiones Aficion where p.nombre = :primerParametro";
        Map<String, String> parametros = new HashMap<>();
        parametros.put("primerParametro", "ghi");
        Collection<Persona> c = dao.consulta(orden, parametros);
        System.out.println(c.toArray(new Persona[]{})[0].getAficiones());
    }
}