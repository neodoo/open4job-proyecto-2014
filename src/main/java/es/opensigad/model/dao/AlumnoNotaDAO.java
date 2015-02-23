package es.opensigad.model.dao;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;


public class AlumnoNotaDAO implements AlumnoNotaDAOInterfaz {

	protected DataSource ds;

	public AlumnoNotaDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AlumnoNota> getAllAlumnoNotas() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<AlumnoNota> listaNotas = (ArrayList<AlumnoNota>) em
				.createQuery("from AlumnoNota").getResultList();
		em.getTransaction().commit();

		em.close();
		return listaNotas;
		
	}

	public ArrayList<AlumnoNota> getNotasByIdMatricula(int idMatricula) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");	
		EntityManager em =  emf.createEntityManager();
		
		// Listar alumnos
		em.getTransaction().begin();
		
		String query = "SELECT * FROM AlumnoNota an WHERE an.id = " + idMatricula;
		
		ArrayList<AlumnoNota> alumnos = (ArrayList<AlumnoNota>) em.createQuery( query ).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return alumnos;
		
	}

	public boolean insertarNotasAlumnoByIdMatricula(int idAlumnoMatricula,
			int idMateria, String evaluacion, int nota, String observacion){
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
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(alumnonota);
		em.getTransaction().commit();
		em.close();

		return true;
			
	}

	public boolean actualizarNotaByIdMatricula(int idMatricula,int idEnsenanza, int idMateria, int idEvalucion,int nota){
		return false;
			
	}

	public boolean borrarNotaByIdMatricula(int idMatricula) {
		
		AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
		alumnoMatricula.setId(idMatricula);
		AlumnoNota alumnoNota = new AlumnoNota();
		alumnoNota.setAlumnoMatricula(alumnoMatricula);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(alumnoNota);
		
		em.getTransaction().commit();
		em.close();
		
		
		return false;
		
	}

}
