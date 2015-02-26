package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class TutorDAO implements TutorDAOInterface {

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger.getLogger(TutorDAO.class.getName());

	public TutorDAO() {

	}

	public List<Tutor> getListaTutor() {

		List<Tutor> listAlumnoTutor = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			// Recuperamos el objeto relacion Alumno_tutor para recuperar todos
			// los datos
			Query q = em.createQuery("SELECT at FROM Tutor at");
			
			listAlumnoTutor = q.getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "TutorDAO.getListaTutor: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "TutorDAO.getListaTutor: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return listAlumnoTutor;

	}
	
	public List<AlumnoTutor> getListaAlumnoTutor() {

		List<AlumnoTutor> listAlumnoTutor = null;

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			// Recuperamos el objeto relacion Alumno_tutor para recuperar todos
			// los datos
			Query q = em.createQuery("SELECT at FROM AlumnoTutor at");
			
			listAlumnoTutor = q.getResultList();

			em.getTransaction().commit();

			logger.log(Level.INFO, "TutorDAO.getListaTutor: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "TutorDAO.getListaAlumnoTutor: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return listAlumnoTutor;

	}

	// borra 1 tutor con el idTutor recibido
	public boolean deleteAlumnoTutor(int idAlumnoTutor) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			AlumnoTutor alumnoTutor; //= new AlumnoTutor();
			//alumnoTutor.setId(idAlumnoTutor);
			alumnoTutor=em.find(AlumnoTutor.class, idAlumnoTutor);
			
			em.remove(alumnoTutor);

			em.getTransaction().commit();

			estado = true;
			logger.log(Level.INFO, "TutorDAO.deleteTutor: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "TutorDAO.deleteTutor: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}
		
		return estado;
		
	}

	// modifica un tutor con el id recibido
	public boolean updateTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.util.Date fechaNac, String parentesco,
			String sexo, String telefono, String email) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			AlumnoTutor alumnoTutor = new AlumnoTutor();
			Tutor tutor = new Tutor();
			Alumno alumno = new Alumno();

			alumno.setId(idAlumno);
			// rellenamos el objeto Tutor
			tutor.setId(idTutor);
			tutor.setNombre(nombre);
			tutor.setApellido1(apellido1);
			tutor.setApellido2(apellido2);
			tutor.setTipoDocumento(tipoDocumento);
			tutor.setDocumento(documento);
			java.sql.Date fecha = new java.sql.Date(fechaNac.getTime());
			tutor.setFechaNacimiento(fecha);
			tutor.setSexo(sexo);
			tutor.setTelefono(telefono);
			tutor.setEmail(email);

			// Rellenamos el objeto AlumnoTutor
			alumnoTutor.setAlumno(alumno);
			alumnoTutor.setTutor(tutor);
			alumnoTutor.setParentesco(parentesco);
			
			em.merge(tutor);
			
			em.merge(alumnoTutor);
			// em.persist(alumnoTutor);

			em.getTransaction().commit();

			estado = true;
			
			logger.log(Level.INFO, "TutorDAO.updateTutor: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "TutorDAO.updateTutor: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}
		
		return estado;

	}

	public boolean insertarTutor(int id, String nombre, String apellido1,
			String apellido2, String tipoDocumento, String documento,
			java.util.Date fechaNac, String parentesco, String sexo,
			String telefono, String email) {

		boolean estado = false;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
			em = emf.createEntityManager();

			em.getTransaction().begin();

			AlumnoTutor alumnoTutor = new AlumnoTutor();
			Alumno alumno = new Alumno();
			Tutor tutor = new Tutor();
			// rellenamos el objeto Tutor

			tutor.setNombre(nombre);
			tutor.setApellido1(apellido1);
			tutor.setApellido2(apellido2);
			tutor.setTipoDocumento(tipoDocumento);
			tutor.setDocumento(documento);
			java.sql.Date fecha = new java.sql.Date(fechaNac.getTime());
			tutor.setFechaNacimiento(fecha);
			tutor.setSexo(sexo);
			tutor.setTelefono(telefono);
			tutor.setEmail(email);

			em.persist(tutor);

			// Rellenamos el objeto AlumnoTutor
			alumno.setId(id);
			alumnoTutor.setAlumno(alumno);
			alumnoTutor.setTutor(tutor);
			alumnoTutor.setParentesco(parentesco);

			em.persist(alumnoTutor);

			em.getTransaction().commit();
		
			estado = true;

			logger.log(Level.INFO, "TutorDAO.insertarTutor: OK.");
			
		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "TutorDAO.insertarTutor: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}
		
		return estado;
		
	}

	public Tutor getDetalleTutor(int idTutor) {

		Tutor tutor = null;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {

			emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);

			em = emf.createEntityManager();

			em.getTransaction().begin();

			// Recuperamos los datos de l tabla tutor con el id que nos llega
			Query q = em
					.createQuery("SELECT t FROM Tutor t WHERE t.tutor.id = "
							+ idTutor); // WHERE t.tutor.id =
										// :varTutor");
			// q.setParameter("varTutor", idTutor);
			
			tutor = (Tutor) q.getSingleResult();

			logger.log(Level.INFO, "TutorDAO.getDetalleTutor: OK.");

		} catch (Exception e) {

			em.getTransaction().rollback();
			logger.log(Level.SEVERE, "TutorDAO.getDetalleTutor: " + e.getMessage());

		} finally {

			try { em.close(); } catch (Exception e) { }
			try { emf.close(); } catch (Exception e) { }

		}

		return tutor;
		
	}

}
