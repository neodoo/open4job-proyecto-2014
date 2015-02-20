package es.opensigad.model.dao;

import java.io.Serializable;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import es.opensigad.model.vo.AlumnoSeguimiento;


public class AlumnoSeguimientoDAO implements AlumnoSeguimientoDAOInterfaz, Serializable {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger.getLogger(AlumnoSeguimiento.class.getName());

	public EntityManagerFactory emf = null;	
	public EntityManager em = null;
	
	public AlumnoSeguimientoDAO() {
		emf = Persistence.createEntityManagerFactory("persistenceUnit");
		em = emf.createEntityManager();		
	}

	// Insertar/Actualizar alumno-seguimiento
	public int actualizarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {
		int id = 0;
		
		em.getTransaction().begin();
		em.merge(alumnoSeguimiento);
		
		try { 
			em.getTransaction().commit();
			id = alumnoSeguimiento.getId();
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: OK.");	        	
		} catch(Exception e) { 
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.actualizarAlumnoSeguimiento: ERROR. "
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
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: OK.");	        	
		} catch(Exception e) { 
			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoSeguimientoDAO.eliminarAlumnoSeguimiento: ERROR. "
					+ e.getMessage());	        	
		}
		
		em.close();
		return ok;
	}



}
