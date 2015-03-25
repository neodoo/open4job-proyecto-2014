package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import es.opensigad.model.vo.AlumnoSeguimiento;

@Stateless
public class AlumnoSeguimientoDAO implements AlumnoSeguimientoDAOInterfaz {

	// public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger
			.getLogger(AlumnoSeguimientoDAO.class.getName());

	@PersistenceContext(unitName = "opensigadUnit")
	private EntityManager em;

	// private EntityManagerFactory emf = null;
	// private EntityManager em = null;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	// public AlumnoSeguimientoDAO() {
	// emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
	// em = emf.createEntityManager();
	// }

	// Listar seguimientos de un alumno
	public List<AlumnoSeguimiento> getListaAlumnoSeguimiento(int idMatricula) {

		List<AlumnoSeguimiento> seguimientos = null;

		try {

			// em.getTransaction().begin();

			String query = "SELECT alumnoSeguimiento FROM AlumnoSeguimiento alumnoSeguimiento "
					+ " WHERE alumnoSeguimiento.alumnoMatricula.id = :pidMatricula";

			seguimientos = em.createQuery(query)
					.setParameter("pidMatricula", idMatricula).getResultList();

			logger.log(Level.INFO,
					"AlumnoSeguimientoDAO.getListaAlumnoSeguimiento: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getListaAlumnoSeguimiento: ERROR. "
							+ e.getMessage());

		}

		return seguimientos;

	}

	// Datos de un seguimiento
	public AlumnoSeguimiento getDetalleAlumnoSeguimiento(int idSeguimiento) {

		AlumnoSeguimiento seguimiento = null;

		try {

			String query = "from AlumnoSeguimiento aseg where aseg.id ="
					+ idSeguimiento;

			seguimiento = (AlumnoSeguimiento) em.createQuery(query)
					.getSingleResult();

			logger.log(Level.INFO,
					"AlumnoSeguimientoDAO.getDetalleAlumnoSeguimiento: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getDetalleAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		return seguimiento;

	}

	// Insertar alumno-seguimiento
	public int insertarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {

		int id = 0;

		try {

			em.persist(alumnoSeguimiento);

			id = alumnoSeguimiento.getId();

			logger.log(Level.INFO,
					"AlumnoSeguimientoDAO.insertarAlumnoSeguimiento: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.insertarAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		return id;

	}

	// Actualizar alumnos
	public boolean actualizarAlumnoSeguimiento(
			AlumnoSeguimiento alumnoSeguimiento) {

		boolean estado = false;

		try {

			em.merge(alumnoSeguimiento);

			estado = true;

			logger.log(Level.INFO,
					"AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		return estado;

	}

	// Eliminar alumno-seguimiento
	public boolean eliminarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {

		boolean estado = false;

		try {

			em.remove(em.merge(alumnoSeguimiento));

			estado = true;

			logger.log(Level.INFO,
					"AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		return estado;

	}

	// Obtener datos correo
	public String getContactoCorreoAlumnoSeguimiento(int idMatricula) {
		String contacto = null;

		try {
			/*
			Query query = em
					.createNativeQuery("SELECT alumno_contacto.contacto" 
							+ " FROM alumno_contacto"
							+ " INNER JOIN alumno_matricula"
							+ " ON alumno_contacto.id_alumno = alumno_matricula.id_alumno"
							+ " WHERE alumno_matricula.id = ?"
							+ " AND alumno_contacto.tipo='email'"
							+ " AND alumno_contacto.principal = 1");

			query.setParameter(1, idMatricula);
			contacto = (String) query.getSingleResult();
			*/
			
			StoredProcedureQuery spq = em.createStoredProcedureQuery("ContactoCorreoAlumnoSeguimiento");
			spq.registerStoredProcedureParameter("id_matricula", Integer.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter("contacto", String.class, ParameterMode.OUT);

			spq.execute();
			contacto = (String) spq.getOutputParameterValue("contacto");
			
			logger.log(Level.INFO,
					"AlumnoSeguimientoDAO.getContactoCorreoAlumnoSeguimiento: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getContactoCorreoAlumnoSeguimiento: ERROR. "
							+ e.getMessage());

		}

		return contacto;
	}

}