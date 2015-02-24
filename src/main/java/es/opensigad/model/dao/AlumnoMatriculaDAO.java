package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.Centro;
import es.opensigad.model.vo.Ensenanza;

public class AlumnoMatriculaDAO implements AlumnoMatriculaDAOInterfaz {

	public static final Logger logger = Logger
			.getLogger(AlumnoMatriculaDAO.class.getName());

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public AlumnoMatriculaDAO() {
	}

	// InsertarMatricula
	public boolean insertarMatricula(int idAlumno, int cursoEscolar,
			int centro, int ensenanza, String modulo, int curso) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence
					.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Alumno alumno = new Alumno();
			Centro centroMatricula = new Centro();
			Ensenanza ensenanzaMatricula = new Ensenanza();

			alumno.setId(idAlumno);
			centroMatricula.setId(centro);
			ensenanzaMatricula.setId(ensenanza);

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setAlumno(alumno);
			alumnoMatricula.setCursoEscolar(cursoEscolar);
			alumnoMatricula.setCentro(centroMatricula);
			alumnoMatricula.setEnsenanza(ensenanzaMatricula);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);

			// Guardar matricula
			// si le paso el objeto en vez de el set persist dará error al estar
			// creado en la bbdd???
			em.persist(alumnoMatricula);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());

		} finally {
			em.close();
			emf.close();
		}

		return false;

	}

	public boolean borrarMatricula(int idMatricula) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence
					.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			// Borrar matricula

			em.getTransaction().begin();
			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula = em.find(AlumnoMatricula.class, idMatricula);
			
			if (alumnoMatricula == null){return false;}
			em.remove(alumnoMatricula);
			em.getTransaction().commit();

			return true;

		} catch (EntityExistsException e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}

		return false;

	}

	public boolean modificarMatricula(int idAlumno, int cursoEscolar,
			int centro, int ensenanza, String modulo, int curso,
			int idMatricula) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence
					.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setId(idAlumno);
			alumnoMatricula.setId(cursoEscolar);
			alumnoMatricula.setId(centro);
			alumnoMatricula.setId(ensenanza);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);
			alumnoMatricula.setId(idMatricula);

			// Modificar alumno

			em.getTransaction().begin();
			em.merge(alumnoMatricula);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}

		return false;

	}

	public List<AlumnoMatricula> getListadoMatricula(int idAlumno) {

		List<AlumnoMatricula> alumnoMatriculaList = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Query q = em.createQuery("from AlumnoMatricula am");
			alumnoMatriculaList = q.getResultList();			

			em.getTransaction().commit();

		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}

		return alumnoMatriculaList;
	}

	public AlumnoMatricula getListaFichaMatricula(int idMatricula) {

		AlumnoMatricula alumnoFichaMatricula = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence
					.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			// String query = "from AlumnoMatricula m where m.id = "+
			// idMatricula;

			// String query =
			// "from AlumnoMatricula m where m.id = :idMatricula";

			em.getTransaction().begin();
			alumnoFichaMatricula = em.find(AlumnoMatricula.class, idMatricula);

			/*
			 * alumnoFichaMatricula = (AlumnoMatricula) em.createQuery(query)
			 * .setParameter(":idMatricula", idMatricula) .getSingleResult();
			 */
			em.getTransaction().commit();

		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}

		return alumnoFichaMatricula;

	}

}
