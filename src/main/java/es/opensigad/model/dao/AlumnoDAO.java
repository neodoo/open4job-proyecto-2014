package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.AlumnoDireccion;

/*
 

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger.getLogger(Alumno.class.getName());

	public AlumnoDAO() {
	}

	public List<Alumno> getListAlumno() {

		List<Alumno> alumnoList = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Query q = em.createQuery("from Alumno a");
			alumnoList = q.getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.getListAlumno: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoDAO.getListAlumno: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}
		
		return alumnoList;

	}

	public Alumno getDetalleAlumno(int numExpediente) {

		Alumno alumno = null;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();
			
			String query = "SELECT a FROM Alumno a WHERE num_expediente = "
					+ numExpediente;

			alumno = (Alumno) em.createQuery(query).getSingleResult();

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.getDetalleAlumno: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoDAO.getDetalleAlumno: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return alumno;

	}

	public boolean insertAlumno(Alumno a) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Alumno alumno = a;
			em.merge(alumno);

			em.getTransaction().commit();
			
			logger.log(Level.INFO, "AlumnoDAO.insertAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoDAO.insertAlumno: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return estado;
	}

	public boolean deleteAlumno(int idAlumno) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Alumno alumno = new Alumno();
			alumno = em.find(Alumno.class, idAlumno);
			em.remove(alumno);
			
			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.deleteAlumno: OK.");

			estado = true;
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoDAO.deleteAlumno: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return estado;
		
	}

	public boolean modifyAlumno(Alumno a) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Alumno alumno = a;
			em.merge(alumno);
			
			em.getTransaction().commit();
			
			logger.log(Level.INFO, "AlumnoDAO.modifyAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "AlumnoDAO.modifyAlumno: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}
		
		return estado;
	
	}

	public boolean insertAlumnoContacto(AlumnoContacto alumnoContacto) {

		return false;
	}

	public boolean deleteAlumnoContacto(int idContacto) {

		return false;
	}

	public boolean modifyAlumnoContacto(AlumnoContacto alumnoContacto) {

		return false;
	}

	public AlumnoContacto getDetalleAlumnoContacto(int idContacto) {

		return null;
	}

	public List<AlumnoContacto> getListAlumnoContacto(int idAlumno) {

		return null;

	}

	public boolean insertAlumnoDireccion(AlumnoDireccion alumnoDireccion) {

		return false;

	}

	public boolean deleteAlumnoDireccion(int idDireccion) {

		return false;

	}

	public boolean modifyAlumnoDireccion(AlumnoDireccion alumnoDireccion) {

		return false;

	}

	public AlumnoDireccion getDetalleAlumnoDireccion(int idDireccion) {

		return null;

	}

	public List<AlumnoDireccion> getListAlumnoDireccion(int idAlumno) {

		return null;

	}

}
*/