package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.Centro;
import es.opensigad.model.vo.Ensenanza;

@Stateless
public class AlumnoMatriculaDAO implements AlumnoMatriculaDAOInterfaz {

	@PersistenceContext(unitName = "opensigadUnit")
	private EntityManager em;
	
	public static final Logger logger = Logger
			.getLogger(AlumnoMatriculaDAO.class.getName());

	public AlumnoMatriculaDAO() {
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// InsertarMatricula
	public boolean insertarMatricula(int idAlumno, int cursoEscolar,
			int idCentro, int idEnsenanza, String modulo, int curso) {

		boolean estado = false;

		try {

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

			estado = true;

			logger.log(Level.INFO, "AlumnoMatriculaDAO.insertarMatricula: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.insertarMatricula: "
					+ e.getMessage());

		} finally {

		}

		return estado;

	}

	public ArrayList<Alumno> getAlumnoList() {

		ArrayList<Alumno> alumnoList = new ArrayList<Alumno>();

		try {

			Query q = em.createQuery("select a from Alumno a");
			alumnoList = (ArrayList<Alumno>) q.getResultList();

			logger.log(Level.INFO, "AlumnoMatriculaDAO.getAlumnoList: OK.");

		} catch (EntityExistsException e) {

			logger.log(Level.SEVERE,
					"AlumnoMatriculaDAO.getAlumnoList:" + e.getMessage());

		} finally {

		}

		return alumnoList;
	}

	public ArrayList<Centro> getCentroList() {

		ArrayList<Centro> centroList = new ArrayList<Centro>();

		try {

			Query q = em.createQuery("select c from Centro c");
			centroList = (ArrayList<Centro>) q.getResultList();

			logger.log(Level.INFO, "AlumnoMatriculaDAO.getCentroList: OK.");

		} catch (EntityExistsException e) {

			logger.log(Level.SEVERE,
					"AlumnoMatriculaDAO.getCentroList:" + e.getMessage());

		} finally {

		}

		return centroList;
	}

	public ArrayList<Ensenanza> getEnsenanzaList() {

		ArrayList<Ensenanza> ensenanzaList = new ArrayList<Ensenanza>();

		try {

			Query q = em.createQuery("select e from Ensenanza e");
			ensenanzaList = (ArrayList<Ensenanza>) q.getResultList();

			logger.log(Level.INFO, "AlumnoMatriculaDAO.getEnsenanzaList: OK.");

		} catch (EntityExistsException e) {

			logger.log(Level.SEVERE,
					"AlumnoMatriculaDAO.getEnsenanzaList:" + e.getMessage());

		} finally {

		}

		return ensenanzaList;

	}

	public boolean borrarMatricula(int idMatricula) {

		boolean estado = false;

		try {

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula = em.find(AlumnoMatricula.class, idMatricula);
			if (alumnoMatricula != null) {

				em.remove(em.merge(alumnoMatricula));

				estado = true;

				logger.log(Level.INFO,
						"AlumnoMatriculaDAO.borrarMatricula: OK.");
			}
		} catch (EntityExistsException e) {

			logger.log(Level.SEVERE,
					"AlumnoMatriculaDAO.borrarMatricula: " + e.getMessage());

		} finally {

		}

		return estado;

	}

	public boolean modificarMatricula(int idAlumno, int cursoEscolar,
			int idCentro, int idEnsenanza, String modulo, int curso,
			int idMatricula) {

		try {

			Alumno alumno = new Alumno();
			Centro centro = new Centro();
			Ensenanza ensenanza = new Ensenanza();

			alumno.setId(idAlumno);
			centro.setId(idCentro);
			ensenanza.setId(idEnsenanza);

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setAlumno(alumno);
			alumnoMatricula.setCursoEscolar(cursoEscolar);
			alumnoMatricula.setCentro(centro);
			alumnoMatricula.setEnsenanza(ensenanza);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);
			alumnoMatricula.setId(idMatricula);

			// Modificar alumno

			em.merge(alumnoMatricula);

			logger.log(Level.INFO, "AlumnoMatriculaDAO.modificarMatricula: OK.");

			return true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoMatriculaDAO.modificarMatricula: Fallo." + e.getMessage());

		} finally {

		}

		return false;

	}

	public List<AlumnoMatricula> getListadoMatricula(int idAlumno) {

		List<AlumnoMatricula> alumnoMatriculaList = null;

		try {
						  
			Query q = em.createQuery("from AlumnoMatricula am WHERE am.alumno.id = ?1");
			q.setParameter(1,idAlumno);
			alumnoMatriculaList = q.getResultList();

			logger.log(Level.INFO,
					"AlumnoMatriculaDAO.getListadoMatricula: OK.");

		} catch (EntityExistsException e) {

			logger.log(Level.SEVERE, "AlumnoMatriculaDAO.getListadoMatricula:"
					+ e.getMessage());

		} finally {

		}

		return alumnoMatriculaList;

	}

	public AlumnoMatricula getListaFichaMatricula(int idMatricula) {

		AlumnoMatricula alumnoMatricula = null;

		try {

			alumnoMatricula = em.find(AlumnoMatricula.class, idMatricula);

			logger.log(Level.INFO,
					"AlumnoMatriculaDAO.getListaFichaMatricula: OK.");

		} catch (EntityExistsException e) {

			logger.log(Level.SEVERE,
					"AlumnoMatriculaDAO.getListadoMatricula: OK.");

		} finally {

		}

		return alumnoMatricula;

	}

}
