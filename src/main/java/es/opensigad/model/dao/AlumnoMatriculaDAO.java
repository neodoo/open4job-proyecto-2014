package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.Centro;
import es.opensigad.model.vo.Ensenanza;

public class AlumnoMatriculaDAO implements AlumnoMatriculaDAOInterfaz {

	public static final Logger logger = Logger
			.getLogger(AlumnoMatriculaDAO.class.getName());

	// @Resource(name="jdbc/opensigad")
	// DataSource ds;

	public AlumnoMatriculaDAO() {
	}

	// InsertarMatricula
	public boolean insertarMatricula(int idAlumno, int cursoEscolar,
			String centro, String ensenanza, String modulo, int curso) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		try {
			
			String query = "from Alumno m where m.id = :idAlumno";
			String query1 = "from Centro c where c.titulo = :centro";
			String query2 = "from Ensenanza e where e.nombre = :ensenanza";
			
			em.getTransaction().begin();
			Alumno alumno = (Alumno) em.createQuery(query)
					.setParameter(":idAlumno", idAlumno)
					.getSingleResult();
			Centro centroMatricula = (Centro) em.createQuery(query1)
					.setParameter(":centro", centro)
					.getSingleResult();
			Ensenanza ensenanzaMatricula = (Ensenanza) em.createQuery(query2)
					.setParameter(":ensenanza", ensenanza)
					.getSingleResult();
			
			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setAlumno(alumno);
			alumnoMatricula.setCursoEscolar(cursoEscolar);
			alumnoMatricula.setCentro(centroMatricula);
			alumnoMatricula.setEnsenanza(ensenanzaMatricula);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);

			// Guardar matricula

			
			em.persist(alumnoMatricula);
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;

	}

	public boolean borrarMatricula(int idMatricula) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		try {

			// Borrar matricula

			em.getTransaction().begin();
			em.remove(idMatricula);
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (EntityExistsException e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;

	}

	public boolean modificarMatricula(Alumno idAlumno, int cursoEscolar,
			Centro centro, Ensenanza ensenanza, String modulo, int curso,
			int idMatricula) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		try {

			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setAlumno(idAlumno);
			alumnoMatricula.setCursoEscolar(cursoEscolar);
			alumnoMatricula.setCentro(centro);
			alumnoMatricula.setEnsenanza(ensenanza);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);
			alumnoMatricula.setId(idMatricula);

			// Modificar alumno

			em.getTransaction().begin();
			em.persist(alumnoMatricula);
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;

	}

	public ArrayList<AlumnoMatricula> getListadoMatricula(int idAlumno) {

		ArrayList<AlumnoMatricula> alumnoMatricula = null;

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();

			alumnoMatricula = (ArrayList<AlumnoMatricula>) em.createQuery(
					"from alumnoMatricula").getResultList();

			em.getTransaction().commit();

			em.close();

		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return alumnoMatricula;

	}

	public AlumnoMatricula getListaFichaMatricula(int idMatricula) {

		AlumnoMatricula alumnoFichaMatricula = null;

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		try {

			// String query = "from AlumnoMatricula m where m.id = "+
			// idMatricula;

			String query = "from AlumnoMatricula m where m.id = :idMatricula";

			em.getTransaction().begin();
			alumnoFichaMatricula = (AlumnoMatricula) em.createQuery(query)
					.setParameter(":idMatricula", idMatricula)
					.getSingleResult();

			em.getTransaction().commit();
			em.close();

		} catch (EntityExistsException e) {

			em.getTransaction().rollback();

			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return alumnoFichaMatricula;

	}
}
