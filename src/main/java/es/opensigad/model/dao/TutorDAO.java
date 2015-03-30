package es.opensigad.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;

//@ManagedBean
//@SessionScoped
@Stateless
public class TutorDAO implements TutorDAOInterface {

	@PersistenceContext(unitName = "opensigadUnit")
	private EntityManager em = null;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public static final Logger logger = Logger.getLogger(TutorDAO.class.getName());
	
	public TutorDAO() {

	}

	@Override
	public List<Tutor> getListaTutor(int idAlumno) {

		List<Tutor> listAlumnoTutor = null;

		try {

			Query q = em.createQuery("SELECT at FROM AlumnoTutor at WHERE at.alumno.id = "+ idAlumno);
			listAlumnoTutor = q.getResultList();

			logger.log(Level.INFO, "TutorDAO.getListaTutor: OK.");

		} catch (Exception e) {


			logger.log(Level.SEVERE, "TutorDAO.getListaTutor: " + e.getMessage());

		} 


		return listAlumnoTutor;

	}
	
	
	@Override
	public List<AlumnoTutor> getListaAlumnoTutor(int idAlumno) {

		List<AlumnoTutor> listAlumnoTutor = null;

	
		try {
			
			Query q = em.createQuery("SELECT at FROM AlumnoTutor at WHERE at.alumno.id = "
				+ idAlumno);

			listAlumnoTutor = q.getResultList();

	
			logger.log(Level.INFO, "TutorDAO.getListaTutor: OK.");

		} catch (Exception e) {


			logger.log(Level.SEVERE, "TutorDAO.getListaTutor: " + e.getMessage());

		} 

		return listAlumnoTutor;

	}
	
	// borra 1 tutor con el idTutor recibido
	@Override
	public boolean deleteAlumnoTutor(int idAlumnoTutor) {

		boolean estado = false;
		
		try {
			AlumnoTutor alumnoTutor; 
			alumnoTutor=em.find(AlumnoTutor.class, idAlumnoTutor);
			
			em.remove(alumnoTutor);
			estado = true;
			
			logger.log(Level.INFO, "TutorDAO.deleteTutor: OK.");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "TutorDAO.deleteTutor: " + e.getMessage());
		} 
		
		return estado;
		
	}

	// modifica un tutor con el id recibido
	@Override
	public boolean updateTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.util.Date fechaNac, String parentesco,
			String sexo, String telefono, String email) {

		boolean estado = false;
		
		try {
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

			estado = true;
			
			logger.log(Level.INFO, "TutorDAO.updateTutor: OK.");

		} catch (Exception e) {

			logger.log(Level.SEVERE, "TutorDAO.updateTutor: " + e.getMessage());
		} 	
		return estado;

	}
	

	@Override
	public boolean insertarTutor(int id, String nombre, String apellido1,
			String apellido2, String tipoDocumento, String documento,
			java.util.Date fechaNac, String parentesco, String sexo,
			String telefono, String email) {

		boolean estado = false;

		try {
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
			estado = true;

			logger.log(Level.INFO, "TutorDAO.insertarTutor: OK.");
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "TutorDAO.insertarTutor: " + e.getMessage());
		} 
	
		return estado;
		
	}

	@Override
	public Tutor getDetalleTutor(int idTutor) {

		Tutor tutor = null;

		try {
			// Recuperamos los datos de la tabla tutor con el id que nos llega
			Query q = em
					.createQuery("SELECT t FROM Tutor t WHERE t.id = "
							+ idTutor);	
			tutor = (Tutor) q.getSingleResult();

			logger.log(Level.INFO, "TutorDAO.getDetalleTutor: OK.");

		} catch (Exception e) {
			logger.log(Level.SEVERE, "TutorDAO.getDetalleTutor: " + e.getMessage());
		}
		
		return tutor;
		
	}
	
	public String getParentesco(int idAlumno, int idTutor){
		String parentesco = null;
		
		try{
			//Recuperamos el parentesco entre los 2 ids que nos llegan
			Query q = em.
					createQuery("SELECT a.parentesco FROM AlumnoTutor a WHERE a.alumno.id = " 
							+ idAlumno + " AND a.tutor.id = " + idTutor);
			parentesco = (String)q.getSingleResult();
			
			logger.log(Level.INFO, "TutorDAO.getParentesco: OK.");
		}catch(Exception e){
			
			logger.log(Level.INFO, "TutorDAO.getParentesco: " + e.getMessage());
		}
		return parentesco;
		
	}

}