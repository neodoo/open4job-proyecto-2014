package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.AlumnoDireccion;
import es.opensigad.model.vo.Territorio;

@Stateless
public class AlumnoDAO implements AlumnoDAOInterfaz {

	@PersistenceContext(unitName = "opensigadUnit")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public static final Logger logger = Logger
			.getLogger(Alumno.class.getName());

	public AlumnoDAO() {
	}

	@Override
	public List<Alumno> getListAlumno() {

		List<Alumno> alumnoList = null;

		try {

			Query q = entityManager.createQuery("from Alumno a");
			alumnoList = q.getResultList();

			logger.log(Level.INFO, "AlumnoDAO.getListAlumno: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.getListAlumno: " + e.getMessage());

		}

		return alumnoList;

	}

	@Override
	public Alumno getDetalleAlumno(int numExpediente) {

		Alumno alumno = null;

		try {
			String query = "SELECT a FROM Alumno a WHERE num_expediente = "
					+ numExpediente;
			alumno = (Alumno) entityManager.createQuery(query)
					.getSingleResult();
			logger.log(Level.INFO, "AlumnoDAO.getDetalleAlumno: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.getDetalleAlumno: " + e.getMessage());

		}

		return alumno;

	}

	@Override
	public boolean insertAlumno(Alumno alumno) {

		boolean estado = false;

		try {

			entityManager.persist(alumno);
			logger.log(Level.INFO, "AlumnoDAO.insertAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.insertAlumno: " + e.getMessage());

		}

		return estado;
	}

	@Override
	public boolean deleteAlumno(int idAlumno) {

		boolean estado = false;

		try {

			Alumno alumno = new Alumno();
			alumno = entityManager.find(Alumno.class, idAlumno);
			entityManager.remove(alumno);

			logger.log(Level.INFO, "AlumnoDAO.deleteAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.deleteAlumno: " + e.getMessage());

		}

		return estado;

	}

	@Override
	public boolean modifyAlumno(Alumno alumno) {

		boolean estado = false;

		try {

			entityManager.merge(alumno);

			logger.log(Level.INFO, "AlumnoDAO.modifyAlumno: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.modifyAlumno: " + e.getMessage());

		}

		return estado;

	}

	@Override
	public boolean insertAlumnoContacto(AlumnoContacto alumnoContacto) {

		boolean estado = false;

		try {

			entityManager.persist(alumnoContacto);

			logger.log(Level.INFO, "AlumnoDAO.insertAlumnoContacto: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.insertAlumnoContacto: " + e.getMessage());

		}

		return estado;
	}

	@Override
	public boolean deleteAlumnoContacto(int idContacto) {

		boolean estado = false;

		try {
			AlumnoContacto alumnoContacto = new AlumnoContacto();
			alumnoContacto = entityManager.find(AlumnoContacto.class,
					idContacto);

			entityManager.remove(alumnoContacto);

			logger.log(Level.INFO, "AlumnoDAO.deleteAlumnoContacto: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.deleteAlumnoContacto: " + e.getMessage());

		}

		return estado;
	}

	@Override
	public boolean modifyAlumnoContacto(AlumnoContacto alumnoContacto) {
		boolean estado = false;

		try {

			entityManager.merge(alumnoContacto);

			logger.log(Level.INFO, "AlumnoDAO.modifyAlumnoContacto: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.modifyAlumnoContacto: " + e.getMessage());

		}

		return estado;
	}

	@Override
	public AlumnoContacto getDetalleAlumnoContacto(int idContacto) {

		AlumnoContacto alumnoContacto = null;

		try {

			alumnoContacto = entityManager.find(AlumnoContacto.class,
					idContacto);

			logger.log(Level.INFO, "AlumnoDAO.getDetalleAlumnoContacto: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.getDetalleAlumnoContacto: " + e.getMessage());

		}

		return alumnoContacto;
	}

	@Override
	public List<AlumnoContacto> getListAlumnoContacto(int idAlumno) {

		List<AlumnoContacto> alumnoContactoList = null;

		try {

			Query q = entityManager.createQuery("from AlumnoContacto a");
			alumnoContactoList = q.getResultList();

			logger.log(Level.INFO, "AlumnoDAO.getListAlumnoContacto: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.getListAlumnoContacto: " + e.getMessage());

		}

		return alumnoContactoList;

	}

	@Override
	public boolean insertAlumnoDireccion(AlumnoDireccion alumnoDireccion) {

		boolean estado = false;

		try {

			entityManager.persist(alumnoDireccion);

			logger.log(Level.INFO, "AlumnoDAO.insertAlumnoDireccion: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.insertAlumnoDireccion: " + e.getMessage());

		}

		return estado;

	}

	@Override
	public boolean deleteAlumnoDireccion(int idDireccion) {

		boolean estado = false;

		try {

			AlumnoDireccion alumnoDireccion = new AlumnoDireccion();
			alumnoDireccion = entityManager.find(AlumnoDireccion.class,
					idDireccion);

			entityManager.remove(alumnoDireccion);
			logger.log(Level.INFO, "AlumnoDAO.deleteAlumnoDireccion: OK.");

			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.deleteAlumnoDireccion: " + e.getMessage());

		}

		return estado;

	}

	@Override
	public boolean modifyAlumnoDireccion(AlumnoDireccion alumnoDireccion) {

		boolean estado = false;

		try {

			entityManager.merge(alumnoDireccion);
			logger.log(Level.INFO, "AlumnoDAO.modifyAlumnoDireccion: OK.");
			estado = true;

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.modifyAlumnoDireccion: " + e.getMessage());

		}

		return estado;

	}

	@Override
	public AlumnoDireccion getDetalleAlumnoDireccion(int idDireccion) {

		AlumnoDireccion alumnoDireccion = null;

		try {

			alumnoDireccion = entityManager.find(AlumnoDireccion.class,
					idDireccion);
			logger.log(Level.INFO, "AlumnoDAO.getDetalleAlumnoDireccion: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "AlumnoDAO.getDetalleAlumnoDireccion: "
					+ e.getMessage());

		}

		return alumnoDireccion;

	}

	@Override
	public List<AlumnoDireccion> getListAlumnoDireccion(int idAlumno) {

		List<AlumnoDireccion> alumnoDireccionList = null;

		try {

			Query q = entityManager
					.createQuery("from AlumnoDireccion a WHERE a.alumno.id = ?1");
			q.setParameter(1, idAlumno);
			alumnoDireccionList = q.getResultList();

			logger.log(Level.INFO, "AlumnoDAO.getListAlumnoDireccion: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE,
					"AlumnoDAO.getListAlumnoDireccion: " + e.getMessage());

		}
		return alumnoDireccionList;

	}

	@Override
	public List<Territorio> getListPais() {
		List<Territorio> territorioList = null;

		try {

			Query q = entityManager
					.createQuery("SELECT t FROM Territorio t WHERE LENGTH(codigo) = 2");

			territorioList = q.getResultList();

			logger.log(Level.INFO, "AlumnoDAO.getListPais: OK.");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "AlumnoDAO.getListPais: " + e.getMessage());

		}
		return territorioList;
	}

	@Override
	public List<Territorio> getListProvincia() {
		List<Territorio> territorioList = null;

		try {

			Query q = entityManager
					.createQuery("SELECT t FROM Territorio t WHERE LENGTH(codigo) > 2");

			territorioList = q.getResultList();

			logger.log(Level.INFO, "AlumnoDAO.getListPais: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "AlumnoDAO.getListPais: " + e.getMessage());

		}

		return territorioList;
	}

}
