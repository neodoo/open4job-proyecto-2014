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
		try {
			AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setAlumno(idAlumno);
			alumnoMatricula.setCursoEscolar(cursoEscolar);
			alumnoMatricula.setCentro(centro);
			alumnoMatricula.setEnsenanza(ensenanza);
			alumnoMatricula.setModulo(modulo);
			alumnoMatricula.setCurso(curso);

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("persistenceUnit");
			EntityManager em = emf.createEntityManager();

			// Guardar matricula
			em.getTransaction().begin();
			em.persist(alumnoMatricula);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (EntityExistsException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		return false;

	}

	public boolean borrarMatricula(int idMatricula) {
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("persistenceUnit");
			EntityManager em = emf.createEntityManager();
			
			//Borrar matricula
			em.getTransaction().begin();
			em.remove(idMatricula);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (EntityExistsException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;

	}

	public boolean modificarMatricula(int idAlumno, int cursoEscolar,
			String centro, String ensenanza, String modulo, int curso,
			int idMatricula) {

		/*
		 * Connection conn; try { conn = ds.getConnection();
		 * 
		 * PreparedStatement stmt = conn .prepareStatement(
		 * "UPDATE alumno_matricula SET curso_escolar=?, centro=?, ensenanza=?, modulo=?, "
		 * + "curso=?, id_alumno=? WHERE id=?"); stmt.setInt(1, cursoEscolar);
		 * stmt.setString(2, centro); stmt.setString(3, ensenanza);
		 * stmt.setString(4, modulo); stmt.setInt(5, curso); stmt.setInt(6,
		 * idAlumno); stmt.setInt(7, idMatricula); int count =
		 * stmt.executeUpdate(); if( count == 1) return true;
		 * 
		 * } catch (SQLException e1) { logger.log(Level.SEVERE,
		 * "SQLException : " + e1.getMessage()); }
		 */

		return false;

	}

	public ArrayList<AlumnoMatricula> getListadoMatricula(int idAlumno) {

		/*
		 * Connection conn; ArrayList<AlumnoMatricula> lista = new
		 * ArrayList<AlumnoMatricula>(); try { conn = ds.getConnection();
		 * 
		 * PreparedStatement stmt = conn
		 * .prepareStatement("SELECT * FROM alumno_matricula where id_alumno = ?"
		 * ); stmt.setInt(1, idAlumno); ResultSet rs = stmt.executeQuery();
		 * while (rs.next()) { lista.add(new AlumnoMatricula(rs.getInt(1),
		 * rs.getInt(2), rs .getInt(3), rs.getString(4), rs.getString(5), rs
		 * .getString(6), rs.getInt(7))); }
		 * 
		 * } catch (SQLException e) { logger.log(Level.SEVERE, "SQLException : "
		 * + e.getMessage()); }
		 */
		return null;

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
