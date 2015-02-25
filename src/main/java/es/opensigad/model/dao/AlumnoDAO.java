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

public class AlumnoDAO implements AlumnoDAOInterfaz {

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger
			.getLogger(Alumno.class.getName());

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
			logger.log(Level.SEVERE,
					"AlumnoDAO.getListAlumno: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

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
			logger.log(Level.SEVERE,
					"AlumnoDAO.getDetalleAlumno: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return alumno;

	}

	public boolean insertAlumno(Alumno alumno) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.merge(alumno);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.insertAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.insertAlumno: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

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
			logger.log(Level.SEVERE,
					"AlumnoDAO.deleteAlumno: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return estado;

	}

	public boolean modifyAlumno(Alumno alumno) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.merge(alumno);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.modifyAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.modifyAlumno: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return estado;

	}

	public boolean insertAlumnoContacto(AlumnoContacto alumnoContacto) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.merge(alumnoContacto);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.insertAlumnoContacto: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.insertAlumnoContacto: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return estado;
	}

	public boolean deleteAlumnoContacto(int idContacto) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();
			AlumnoContacto alumnoContacto = new AlumnoContacto();
			alumnoContacto = em.find(AlumnoContacto.class, idContacto);

			em.remove(alumnoContacto);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.deleteAlumnoContacto: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.deleteAlumnoContacto: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return estado;
	}

	public boolean modifyAlumnoContacto(AlumnoContacto alumnoContacto) {
		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.merge(alumnoContacto);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.modifyAlumnoContacto: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.modifyAlumnoContacto: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}
		}

		return estado;
	}

	public AlumnoContacto getDetalleAlumnoContacto(int idContacto) {

		AlumnoContacto alumnoContacto = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			alumnoContacto = em.find(AlumnoContacto.class, idContacto);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.getDetalleAlumnoContacto: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.getDetalleAlumnoContacto: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return alumnoContacto;
	}

	public List<AlumnoContacto> getListAlumnoContacto(int idAlumno) {

		List<AlumnoContacto> alumnoContactoList = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Query q = em.createQuery("from AlumnoContacto a");
			alumnoContactoList = q.getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.getListAlumnoContacto: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.getListAlumnoContacto: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return alumnoContactoList;

	}

	public boolean insertAlumnoDireccion(AlumnoDireccion alumnoDireccion) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.merge(alumnoDireccion);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.insertAlumnoDireccion: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.insertAlumnoDireccion: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return estado;

	}

	public boolean deleteAlumnoDireccion(int idDireccion) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();
			AlumnoDireccion alumnoDireccion = new AlumnoDireccion();
			alumnoDireccion = em.find(AlumnoDireccion.class, idDireccion);

			em.remove(alumnoDireccion);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.deleteAlumnoDireccion: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.deleteAlumnoDireccion: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return estado;

	}

	public boolean modifyAlumnoDireccion(AlumnoDireccion alumnoDireccion) {

		boolean estado = false;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			em.merge(alumnoDireccion);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.modifyAlumnoDireccion: OK.");

			estado = true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.modifyAlumnoDireccion: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}
		}

		return estado;

	}

	public AlumnoDireccion getDetalleAlumnoDireccion(int idDireccion) {

		AlumnoDireccion alumnoDireccion = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			alumnoDireccion = em.find(AlumnoDireccion.class, idDireccion);

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.getDetalleAlumnoDireccion: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.getDetalleAlumnoDireccion: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return alumnoDireccion;

	}

	public List<AlumnoDireccion> getListAlumnoDireccion(int idAlumno) {

		List<AlumnoDireccion> alumnoDireccionList = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			Query q = em.createQuery("from AlumnoDireccion a");
			alumnoDireccionList = q.getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "AlumnoDAO.getListAlumnoDireccion: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE,
					"AlumnoDAO.getListAlumnoDireccion: " + e.getMessage());

		} finally {

			try {
				em.close();
			} catch (Exception e) {
			}
			try {
				emf.close();
			} catch (Exception e) {
			}

		}

		return alumnoDireccionList;

	}

}
