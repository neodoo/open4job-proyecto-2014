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
	public boolean insertarMatricula(Alumno idAlumno, int cursoEscolar,
			Centro centro, Ensenanza ensenanza, String modulo, int curso) {

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

			// Guardar matricula

			em.getTransaction().begin();
			em.persist(alumnoMatricula);
			em.getTransaction().commit();
			em.close();

			return true;

		} catch (EntityExistsException e) {

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

		} catch (EntityExistsException e) {

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

		/*
		 * Connection conn; ArrayList<AlumnoMatricula> lista = new
		 * ArrayList<AlumnoMatricula>(); try { conn = ds.getConnection();
		 * 
		 * PreparedStatement stmt = conn .prepareStatement(
		 * "SELECT * FROM alumno_matricula where id_alumno = ?" );
		 * stmt.setInt(1, idAlumno); ResultSet rs = stmt.executeQuery(); while
		 * (rs.next()) { lista.add(new AlumnoMatricula(rs.getInt(1),
		 * rs.getInt(2), rs .getInt(3), rs.getString(4), rs.getString(5), rs
		 * .getString(6), rs.getInt(7))); }
		 * 
		 * } catch (SQLException e) { logger.log(Level.SEVERE, "SQLException : "
		 * + e.getMessage()); }
		 */

	}

	public AlumnoMatricula getListaFichaMatricula(int idMatricula) {

		/*
		 * Connection conn; AlumnoMatricula fichamatricula = null; try { conn =
		 * ds.getConnection();
		 * 
		 * PreparedStatement stmt = conn
		 * .prepareStatement("SELECT * FROM alumno_matricula where id= ?");
		 * stmt.setInt(1, idMatricula); ResultSet rs = stmt.executeQuery();
		 * while (rs.next()) { fichamatricula = (new
		 * AlumnoMatricula(rs.getInt(1), rs.getInt(2), rs .getInt(3),
		 * rs.getString(4), rs.getString(5), rs .getString(6), rs.getInt(7))); }
		 * 
		 * } catch (SQLException e) { logger.log(Level.SEVERE, "SQLException : "
		 * + e.getMessage()); }
		 */

		return null;

	}

}
