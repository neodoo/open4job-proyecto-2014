package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;

@Stateless
public class AlumnoNotaDAO implements AlumnoNotaDAOInterfaz {

	@PersistenceContext(unitName = "opensigadUnit")
	public EntityManager em = null;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public static final Logger logger = Logger.getLogger(AlumnoNotaDAO.class
			.getName());

	public AlumnoNotaDAO() {

	}
	
	public List<AlumnoNota> getDetalleNotasByIdMatricula(int idMatricula, int idFila){
		List<AlumnoNota> alumnos = null;
		try {

			String query = "SELECT an "
					+ " FROM AlumnoNota an, AlumnoMatricula am"
					+ " WHERE an.alumnoMatricula.id = am.id" 
					+ " AND am.id = " + idMatricula +" AND an.id = "+idFila;

			alumnos = em.createQuery(query).getResultList();
			logger.log(Level.INFO, "AlumnoNotaDAO.getNotasByIdMatricula: OK.");

		} catch (Exception e) {

			logger.log(
					Level.SEVERE,
					"AlumnoNotaDAO.getNotasByIdMatricula: ERROR. "
							+ e.getMessage());

		}
		return alumnos;
	}
	
	public List<AlumnoNota> getNotasByIdMatricula(int id) {

		List<AlumnoNota> alumnos = null;

		try {

			String query = "SELECT an "
					+ " FROM AlumnoNota an, AlumnoMatricula am"
					+ " WHERE an.alumnoMatricula.id = am.id" 
					+ " AND am.id = " + id;

			alumnos = em.createQuery(query).getResultList();
			logger.log(Level.INFO, "AlumnoNotaDAO.getNotasByIdMatricula: OK.");

		} catch (Exception e) {

			logger.log(
					Level.SEVERE,
					"AlumnoNotaDAO.getNotasByIdMatricula: ERROR. "
							+ e.getMessage());

		}

		return alumnos;

	}

	public boolean insertarNotasAlumnoByIdMatricula(int idMateria,
			int idAlumnoMatricula, String evaluacion, String nota,
			String observacion) {

		boolean estado = false;

		AlumnoNota alumnoNota = null;

		AlumnoMatricula alumnoMatricula = null;

		EnsenanzaMateria ensenanzaMateria = null;

		try {

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

			estado = true;

			logger.log(Level.INFO,
					"AlumnoNotaDAO.insertarNotasAlumnoByIdMatricula: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoNotaDAO.insertarNotasAlumnoByIdMatricula: ERROR. "
							+ e.getMessage());

		}
		return estado;

	}

	public boolean actualizarNotaByIdMatricula(int id, int idAlumnoMatricula,
			int idMateria, String evaluacion, String nota, String observacion) {

		boolean estado = false;

		try {

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

			estado = true;

			logger.log(Level.INFO,
					"AlumnoNotaDAO.actualizarNotaByIdMatricula: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "
					+ e.getMessage());

		}

		return estado;

	}

	public boolean borrarNotaById(int id) {

		boolean estado = false;

		try {

			AlumnoNota alumnoNota = new AlumnoNota();
			alumnoNota.setId(id);

			alumnoNota = em.find(AlumnoNota.class, id);
			em.remove(alumnoNota);

			estado = true;

			logger.log(Level.INFO, "AlumnoNotaDAO.borrarNotaById: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "
					+ e.getMessage());

		}

		return estado;

	}

	public List<EnsenanzaMateria> listMateriaCombo() {

		List<EnsenanzaMateria> listMateria = null;
		try {
			

 //listaNotas = em.createQuery("from AlumnoNota").getResultList();
 
			String query = "from EnsenanzaMateria em";
 			listMateria = em.createQuery(query).getResultList();
 
			//String query = " from EnsenanzaMateria em";
			//listMateria = em.createQuery("from EnsenanzaMateria em")
				//	.getResultList();
			logger.log(Level.INFO, "AlumnoNotaDAO.listMateriaCombo: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "AlumnoNotaDAO.getAllAlumnoNotas: ERROR. "
					+ e.getMessage());

		}

		return listMateria;

	}

}
