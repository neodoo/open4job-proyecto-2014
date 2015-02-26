package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;

public class AlumnoNotaDAO implements AlumnoNotaDAOInterfaz {

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger.getLogger(AlumnoNotaDAO.class
			.getName());

	public EntityManagerFactory emf = null;
	public EntityManager em = null;

	public AlumnoNotaDAO() {

		emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
		em = emf.createEntityManager();

	}

	public List<AlumnoNota> getAllAlumnoNotas() {

		List<AlumnoNota> listaNotas = null;

		try {

			em.getTransaction().begin();

			listaNotas = em.createQuery("from AlumnoNota").getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoNotaDAO.getAllAlumnoNotas: OK.");

		} catch (Exception e) {
			
			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "	+ e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return listaNotas;

	}

	public List<AlumnoNota> getNotasByIdAlumno(int id) {

		List<AlumnoNota> alumnos = null;
	
		try {

			em.getTransaction().begin();

			//String query = "FROM AlumnoNota an WHERE an.id = " + id;
			
			// TODO
			String query = " SELECT an FROM AlumnoNota an";
			//+ " FROM Alumno a, AlumnoNota an, AlumnoMatricula am WHERE "
			//+ " a.id=am.alumno.id "
			//+ " and am.alumno.alumnoNotas.id = an.id"
			//+ " and a.id= " + id;
			
			/*String query= " SELECT an"
					+ " FROM Alumno a, AlumnoNota an, AlumnoMatricula am, EnsenanzaMateria em WHERE "
					+ " a.id=am.alumno.id "
					+ " and am.alumno.alumnoNotas.id = an.id"
					+ " and em.id=ensenanzaMateria "
					+ " and a.id= " + id;
			
			String query= " SELECT an "
					+ " FROM Alumno a, AlumnoMatricula am, AlumnoNota an "
					+ " a.id = am.alumno.id "
					+ " AND am.alumno.alumnoNotas.id = an.id "
					+ " AND a.id = " + id;*/
			
			/*SELECT 
			em.materia,an.nota, an.evaluacion, an.observacion 
			FROM opensigad.alumno a , opensigad.alumno_nota an , opensigad.alumno_matricula  am,
			opensigad.ensenanza_materia em
			WHERE 
			a.id=am.id_alumno and am.id=an.id_alumno_matricula and em.id=an.id_materia and
			a.id=1*/

			alumnos = em.createQuery(query).getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoNotaDAO.getNotasByIdAlumno: OK.");

		} catch (Exception e) {

			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			logger.log(Level.SEVERE, "AlumnoNotaDAO.getNotasByIdAlumno: ERROR. " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return alumnos;

	}

	public boolean insertarNotasAlumnoByIdMatricula(int idMateria,
			int idAlumnoMatricula, String evaluacion, String nota, String observacion) {

		boolean estado = false;
		
		AlumnoNota alumnoNota = null;
		
		AlumnoMatricula alumnoMatricula = null;
		
		EnsenanzaMateria ensenanzaMateria = null;
		
		try {

			em.getTransaction().begin();
			 
			alumnoNota = new AlumnoNota();
			
			ensenanzaMateria = new EnsenanzaMateria();
			ensenanzaMateria.setId(idMateria);
			alumnoNota.setEnsenanzaMateria(ensenanzaMateria);
			
			alumnoMatricula = new AlumnoMatricula();
			alumnoMatricula.setId(idAlumnoMatricula);
			alumnoNota.setAlumnoMatricula(alumnoMatricula);
			
			alumnoNota.setEvaluacion(evaluacion);
			alumnoNota.setNota(nota);
			alumnoNota.setObservacion(observacion);

			em.persist(alumnoNota);
		
			em.getTransaction().commit();
		
			estado = true;
			
			logger.log(Level.INFO, "AlumnoNotaDAO.insertarNotasAlumnoByIdMatricula: OK.");

		} catch (Exception e) {

			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			logger.log(Level.SEVERE, "AlumnoNotaDAO.insertarNotasAlumnoByIdMatricula: ERROR. "	+ e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return estado;

	}

	public boolean actualizarNotaByIdMatricula(int id, int idAlumnoMatricula,
			int idMateria, String evaluacion, String nota, String observacion) {

		boolean estado = false;
		
		try {
			
			em.getTransaction().begin();
			
			AlumnoMatricula matricula = new AlumnoMatricula();
			matricula.setId(idAlumnoMatricula);

			EnsenanzaMateria ensenanzaMateria = new EnsenanzaMateria();
			ensenanzaMateria.setId(idMateria);

			AlumnoNota alumnoNota = new AlumnoNota();
			alumnoNota.setId(id);
			alumnoNota.setAlumnoMatricula(matricula);
			alumnoNota.setEnsenanzaMateria(ensenanzaMateria);
			alumnoNota.setEvaluacion(evaluacion);
			alumnoNota.setNota(nota);
			alumnoNota.setObservacion(observacion);

			em.merge(alumnoNota);

			em.getTransaction().commit();

			estado = true;
			
			logger.log(Level.INFO, "AlumnoNotaDAO.actualizarNotaByIdMatricula: OK.");
			
		} catch (Exception e) {

			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "	+ e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return estado;

	}

	public boolean borrarNotaById(int id) {

		boolean estado = false;
		
		try {

			em.getTransaction().begin();
			
			AlumnoNota alumnoNota = new AlumnoNota();
			alumnoNota.setId(id);
			
			alumnoNota = em.find(AlumnoNota.class, id);
			em.remove(alumnoNota);

			em.getTransaction().commit();
			
			estado = true;
			
			logger.log(Level.INFO, "AlumnoNotaDAO.borrarNotaById: OK.");

		} catch (Exception e) {

			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "	+ e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return estado;

	}
	public List<EnsenanzaMateria> listMateriaCombo() {
		
		List<EnsenanzaMateria> listMateria = null;
		try {
			em.getTransaction().begin();
			listMateria= em.createQuery("select em from EnsenanzaMateria em").getResultList();
			em.getTransaction().commit();
			
			logger.log(Level.INFO, "AlumnoNotaDAO.listMateriaCombo: OK.");
		} catch (Exception e) {
			
			try { em.getTransaction().rollback(); } catch (Exception ex) { }
			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "	+ e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}	
		
		return listMateria;
		
	}
	

}
