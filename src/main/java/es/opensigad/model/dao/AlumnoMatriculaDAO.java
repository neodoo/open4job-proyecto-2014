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

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger.getLogger(AlumnoMatriculaDAO.class.getName());

	public AlumnoMatriculaDAO() {
	}

	// InsertarMatricula
	public boolean insertarMatricula(int idAlumno, int cursoEscolar,
			int idCentro, int idEnsenanza, String modulo, int curso) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Alumno alumno = new Alumno();
			
			Centro centroMatricula = new Centro();
			Ensenanza ensenanza = new Ensenanza();

			alumno.setId(idAlumno);
			centroMatricula.setId(idCentro);
			ensenanza.setId(idEnsenanza);

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setAlumno(alumno);
			alumnoMatricula.setCursoEscolar(cursoEscolar);
			alumnoMatricula.setCentro(centroMatricula);
			alumnoMatricula.setEnsenanza(ensenanza);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);

			// Guardar matricula
		
			em.persist(alumnoMatricula);
			
			em.getTransaction().commit();

			estado = true;
			
			logger.log(Level.INFO, "AlumnoMatriculaDAO.insertarMatricula: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.insertarMatricula: " + e.getMessage());

		} finally {
			
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}

		return estado;

	}
	
	public ArrayList<Centro> getCentroList(){
		
		ArrayList<Centro> centroList = new ArrayList<Centro>();
		//ArrayList<Integer>  centroLista= new ArrayList<Integer>();
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Query q = em.createQuery("select c from Centro c");
			centroList = (ArrayList<Centro>) q.getResultList();
			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoMatriculaDAO.getListadoMatricula: OK.");

		} catch (EntityExistsException e) {
			
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.getListadoMatricula:" + e.getMessage());

		} finally {
			
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}
		
		return centroList;
	}

	public boolean borrarMatricula(int idMatricula) {
		
		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			// Borrar matricula

			em.getTransaction().begin();
			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula = em.find(AlumnoMatricula.class, idMatricula);
			em.remove(alumnoMatricula);
			em.getTransaction().commit();
			
			estado = true;

			logger.log(Level.INFO, "AlumnoMatriculaDAO.borrarMatricula: OK.");	

		} catch (EntityExistsException e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.borrarMatricula: " + e.getMessage());

		} finally {
			
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}

		return estado;

	}

	public boolean modificarMatricula(int idAlumno, int cursoEscolar,
			int idCentro, int idEnsenanza, String modulo, int curso,
			int idMatricula) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setId(idAlumno);
			alumnoMatricula.setId(cursoEscolar);
			alumnoMatricula.setId(idCentro);
			alumnoMatricula.setId(idEnsenanza);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);
			alumnoMatricula.setId(idMatricula);

			// Modificar alumno
			em.getTransaction().begin();
			
			em.merge(alumnoMatricula);
			
			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoMatriculaDAO.modificarMatricula: OK.");

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.modificarMatricula: OK.");

		} finally {
			
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
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

			logger.log(Level.INFO, "AlumnoMatriculaDAO.getListadoMatricula: OK.");

		} catch (EntityExistsException e) {
			
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.getListadoMatricula:" + e.getMessage());

		} finally {
			
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}

		return alumnoMatriculaList;

	}

	public AlumnoMatricula getListaFichaMatricula(int idMatricula) {

		AlumnoMatricula alumnoMatricula = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			// String query = "from AlumnoMatricula m where m.id = "+
			// idMatricula;

			// String query =
			// "from AlumnoMatricula m where m.id = :idMatricula";

			em.getTransaction().begin();
			
			alumnoMatricula = em.find(AlumnoMatricula.class, idMatricula);

			/*
			 * alumnMatricula = (AlumnoMatricula) em.createQuery(query)
			 * .setParameter(":idMatricula", idMatricula) .getSingleResult();
			 */
			
			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoMatriculaDAO.getListaFichaMatricula: OK.");

		} catch (EntityExistsException e) {
			
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.getListadoMatricula: OK.");
		
		} finally {
			
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}

		return alumnoMatricula;

	}

}
