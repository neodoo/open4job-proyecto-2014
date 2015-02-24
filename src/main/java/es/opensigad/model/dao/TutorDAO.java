package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class TutorDAO implements TutorDAOInterface {

	public final static String ENTITY_MANAGER = "opensigadUnit";

	public static final Logger logger = Logger
			.getLogger(Alumno.class.getName());

	private EntityManagerFactory emf;
	private EntityManager em;

	public TutorDAO() {

		emf = Persistence.createEntityManagerFactory(ENTITY_MANAGER);
		em = emf.createEntityManager();

	}

	public List<AlumnoTutor> getlistaTutor(int idAlumno) {

		// Recuperamos el objeto relacion Alumno_tutor para recuperar todos los datos
		Query q = em
				.createQuery("SELECT at FROM AlumnoTutor at INNER JOIN Tutor t "
						+ "ON at.idTutor = t.id "
						+ "WHERE at.alumno.id " + idAlumno);
						 						//= :varAlumno");
		
		//q.setParameter("varAlumno", idAlumno);
		List<AlumnoTutor> listAlumnoTutor = q.getResultList();

		return listAlumnoTutor;

	}

	// borra 1 tutor con el idTutor recibido
	public boolean deleteTutor(int id) {

		try {

			em.getTransaction().begin();

			AlumnoTutor alumnoTutor = new AlumnoTutor();
			Tutor tutor = new Tutor();
			tutor.setId(id);
			alumnoTutor.setTutor(tutor);

			em.remove(alumnoTutor);

			em.getTransaction().commit();
		
			return true;

		} catch (ConstraintViolationException cve) {
			em.getTransaction().rollback();
			return false;
		}

	}

	// modifica un tutor con el id recibido
	public boolean updateTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.util.Date fechaNac, String parentesco,
			String sexo, String telefono, String email) {

		try {

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

			em.merge(alumnoTutor);

			// em.persist(alumnoTutor);

			em.getTransaction().commit();

			return true;

		} catch (ConstraintViolationException cve) {
			em.getTransaction().rollback();
			return false;

		}

	}

	public boolean insertarTutor(int idAlumno, String nombre, String apellido1,
			String apellido2, String tipoDocumento, String documento,
			java.util.Date fechaNac, String parentesco, String sexo,
			String telefono, String email) {

		try {
			
			em.getTransaction().begin();

			AlumnoTutor alumnoTutor = new AlumnoTutor();
			Tutor tutor = new Tutor();
			Alumno alumno = new Alumno();

			alumno.setId(idAlumno);
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

			alumnoTutor.setAlumno(alumno);
			alumnoTutor.setTutor(tutor);
			alumnoTutor.setParentesco(parentesco);

			em.persist(alumnoTutor);

			em.getTransaction().commit();
			return true;

		} catch (ConstraintViolationException cve) {
			em.getTransaction().rollback();
			return false;
		}

	}

	public Tutor getDetalleTutor(int idTutor) {

		Tutor tutor = null;

		// Recuperamos los datos de l tabla tutor con el id que nos llega
		Query q = em.createQuery("SELECT t FROM Tutor t WHERE t.tutor.id " + idTutor); // WHERE t.tutor.id =
																						// :varTutor");
		//q.setParameter("varTutor", idTutor);
		tutor = (Tutor) q.getSingleResult();

		return tutor;

	}

}
