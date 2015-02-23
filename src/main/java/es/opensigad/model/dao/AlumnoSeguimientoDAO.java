package es.opensigad.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.opensigad.model.vo.AlumnoSeguimiento;

public class AlumnoSeguimientoDAO implements AlumnoSeguimientoDAOInterfaz,
		Serializable {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger
			.getLogger(AlumnoSeguimiento.class.getName());

	public EntityManagerFactory emf = null;
	public EntityManager em = null;

	public AlumnoSeguimientoDAO() {
		emf = Persistence.createEntityManagerFactory("persistenceUnit");
		em = emf.createEntityManager();
	}

	// Listar seguimientos de un alumno
	public List<AlumnoSeguimiento> getListaAlumnoSeguimiento(int pidMatricula) {

		List<AlumnoSeguimiento> seguimientos = null;

		try {
			String query = "SELECT alumnoSeguimiento FROM AlumnoSeguimiento alumnoSeguimiento "
					+ " WHERE alumnoSeguimiento.alumnoMatricula.id = :pidMatricula";

			em.getTransaction().begin();
			seguimientos = em.createQuery(query)
					.setParameter("pidMatricula", pidMatricula).getResultList();
			em.getTransaction().commit();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getListaAlumnoSeguimiento: OK.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getListaAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		em.close();
		return seguimientos;

	}

	// Datos de una falta
	public AlumnoSeguimiento getDetalleAlumnoSeguimiento(int pnumId) {

		List<AlumnoSeguimiento> seguimiento = null;

		String query = "from AlumnoSeguimiento aseg where aseg.id =" + pnumId;
		em.getTransaction().begin();
		seguimiento = em.createQuery(query).getResultList();

		try {
			em.getTransaction().commit();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getDetalleAlumnoSeguimiento: OK.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.getDetalleAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		em.close();

		return (AlumnoSeguimiento) seguimiento;

	}

	// Insertar/Actualizar alumno-seguimiento
	public int actualizarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {
		int id = 0;

		em.getTransaction().begin();
		em.merge(alumnoSeguimiento);

		try {
			em.getTransaction().commit();
			id = alumnoSeguimiento.getId();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: OK.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		em.close();
		return id;

	}

	// Eliminar alumno-seguimiento
	public int eliminarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {
		int ok = 0;

		em.getTransaction().begin();
		em.remove(alumnoSeguimiento);

		try {
			em.getTransaction().commit();
			ok = 1;
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: OK.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: ERROR. "
							+ e.getMessage());
		}

		em.close();
		return ok;
	}
}
