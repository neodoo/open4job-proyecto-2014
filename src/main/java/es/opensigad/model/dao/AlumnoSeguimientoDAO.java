package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.opensigad.model.vo.AlumnoSeguimiento;

public class AlumnoSeguimientoDAO implements AlumnoSeguimientoDAOInterfaz {

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger.getLogger(AlumnoSeguimientoDAO.class.getName());

	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public AlumnoSeguimientoDAO() {

		emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
		em = emf.createEntityManager();

	}

	// Listar seguimientos de un alumno
	public List<AlumnoSeguimiento> getListaAlumnoSeguimiento(int pidMatricula) {

		List<AlumnoSeguimiento> seguimientos = null;

		try {
			
			em.getTransaction().begin();

			String query = "SELECT alumnoSeguimiento FROM AlumnoSeguimiento alumnoSeguimiento "
					+ " WHERE alumnoSeguimiento.alumnoMatricula.id = :pidMatricula";


			seguimientos = em.createQuery(query)
					.setParameter("pidMatricula", pidMatricula).getResultList();
			
			em.getTransaction().commit();
			
			logger.log(Level.INFO, "AlumnoSeguimientoDAO.getListaAlumnoSeguimiento: OK.");
		
		} catch (Exception e) {
		
			try { em.getTransaction().rollback(); } catch (Exception ex) {}
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.getListaAlumnoSeguimiento: ERROR. " + e.getMessage());
		
		} finally {
		
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}
		
		return seguimientos;

	}

	// Datos de una falta
	public AlumnoSeguimiento getDetalleAlumnoSeguimiento(int pnumId) {

		AlumnoSeguimiento seguimiento = null;
		
		try {
			
			em.getTransaction().begin();

			String query = "from AlumnoSeguimiento aseg where aseg.id =" + pnumId;

			seguimiento = (AlumnoSeguimiento) em.createQuery(query).getSingleResult();
		
			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoSeguimientoDAO.getDetalleAlumnoSeguimiento: OK.");
	
		} catch (Exception e) {
			
			try { em.getTransaction().rollback(); } catch (Exception ex) {}
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.getDetalleAlumnoSeguimiento: ERROR. " + e.getMessage());
		
		} finally {
		
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}

		return seguimiento;

	}

	// Insertar/Actualizar alumno-seguimiento
	public int actualizarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {

		int id = 0;

		try {
		
			em.getTransaction().begin();
			
			em.merge(alumnoSeguimiento);

			em.getTransaction().commit();
			id = alumnoSeguimiento.getId();

			logger.log(Level.INFO, "AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: OK.");
			
		} catch (Exception e) {
			
			try { em.getTransaction().rollback(); } catch (Exception ex) {}
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: ERROR. " + e.getMessage());

		} finally {
		
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		
		}

		return id;

	}

	// Eliminar alumno-seguimiento
	public boolean eliminarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {

		boolean estado = false;

		try {

			em.getTransaction().begin();
			
			em.remove(alumnoSeguimiento);
			
			em.getTransaction().commit();
		
			estado = true;
			
			logger.log(Level.INFO, "AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: OK.");
		
		} catch (Exception e) {
			
			try { em.getTransaction().rollback(); } catch (Exception ex) {}
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: ERROR. " + e.getMessage());

		} finally {
			try { em.close(); } catch (Exception e) {}
			try { emf.close(); } catch (Exception e) {}
		}

		em.close();

		return estado;

	}

}
