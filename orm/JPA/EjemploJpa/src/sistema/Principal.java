package sistema;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Persona;

import com.sun.istack.logging.Logger;

public class Principal {
	public static void main(String... args) {
		Logger LOG = Logger.getLogger(Principal.class);
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EjemploJpa");
		insertarPersona(LOG, emf);
		buscarPersonas(LOG, emf);
		emf.close();

	}

	private static void buscarPersonas(Logger LOG, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Persona> q = em.createQuery("select p from Persona p",
				Persona.class);
		List<Persona> todas = q.getResultList();
		todas.forEach(persona -> LOG.log(Level.INFO, "Persona: " + persona));
		em.getTransaction().commit();
	}

	private static void insertarPersona(Logger LOG, EntityManagerFactory emf) {
		Persona p = new Persona("Nombre " + System.currentTimeMillis());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		LOG.log(Level.INFO, "Persona: " + p);
		em.getTransaction().commit();
	}
}
