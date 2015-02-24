package es.opensigad.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;

public class AlumnoNotaDAO implements AlumnoNotaDAOInterfaz {

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public EntityManagerFactory emf = null;
	public EntityManager em = null;

	public AlumnoNotaDAO() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(ENTITY_MANAGER);

		EntityManager em = emf.createEntityManager();

	}

	public ArrayList<AlumnoNota> getAllAlumnoNotas() {

		em.getTransaction().begin();
		ArrayList<AlumnoNota> listaNotas = (ArrayList<AlumnoNota>) em
				.createQuery("from AlumnoNota").getResultList();
		em.getTransaction().commit();

		em.close();

		return listaNotas;

	}

	public ArrayList<AlumnoNota> getNotasByIdMatricula(int idMatricula) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(ENTITY_MANAGER);
		EntityManager em = emf.createEntityManager();

		// Listar alumnos
		em.getTransaction().begin();

		String query = "SELECT * FROM AlumnoNota an WHERE an.id = "
				+ idMatricula;

		ArrayList<AlumnoNota> alumnos = (ArrayList<AlumnoNota>) em.createQuery(
				query).getResultList();

		em.getTransaction().commit();
		em.close();

		return alumnos;

	}

	public boolean insertarNotasAlumnoByIdMatricula(int idAlumnoMatricula,
			int idMateria, String evaluacion, int nota, String observacion) {

		AlumnoMatricula matricula = new AlumnoMatricula();
		matricula.setId(idAlumnoMatricula);

		EnsenanzaMateria ensenanzaMateria = new EnsenanzaMateria();
		ensenanzaMateria.setId(idMateria);

		AlumnoNota alumnonota = new AlumnoNota();
		alumnonota.setAlumnoMatricula(matricula);
		alumnonota.setEnsenanzaMateria(ensenanzaMateria);
		alumnonota.setEvaluacion(evaluacion);
		// alumnonota.setNota(nota);
		alumnonota.setObservacion(observacion);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(ENTITY_MANAGER);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(alumnonota);
		em.getTransaction().commit();
		em.close();

		return true;

	}

public boolean actualizarNotaByIdMatricula(int idAlumnoMatricula,int idMateria, String evaluacion,String nota, String observacion){
		
		AlumnoMatricula matricula = new AlumnoMatricula();
		matricula.setId(idAlumnoMatricula);

		EnsenanzaMateria ensenanzaMateria = new EnsenanzaMateria();
		ensenanzaMateria.setId(idMateria);

		AlumnoNota alumnonota = new AlumnoNota();
		alumnonota.setAlumnoMatricula(matricula);
		alumnonota.setEnsenanzaMateria(ensenanzaMateria);
		alumnonota.setEvaluacion(evaluacion);
		alumnonota.setNota(nota);
		alumnonota.setObservacion(observacion);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ENTITY_MANAGER");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(alumnonota);
		em.getTransaction().commit();
		em.close();
		return true;
			
	}

	public boolean borrarNotaByIdMatricula(int idMatricula) {

		AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
		alumnoMatricula.setId(idMatricula);
		AlumnoNota alumnoNota = new AlumnoNota();
		alumnoNota.setAlumnoMatricula(alumnoMatricula);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(ENTITY_MANAGER);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.remove(alumnoNota);

		em.getTransaction().commit();
		em.close();

		return false;

	}

}
