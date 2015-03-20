package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;

import javax.ejb.Local;


@Local
public interface TutorDAOInterface {
	

	// Recoge un idAlumno y devuelve los tutores asignados a ese alumno
	public List<Tutor> getListaTutor();

	// recibe 1 idtutor y devuelve ese tutor
	public Tutor getDetalleTutor(int id);

	// borra 1 tutor con el id recibido
	public boolean deleteAlumnoTutor(int idAlumnoTutor);

	// modifica un tutor con el id recibido
	public boolean updateTutor(int idAlumno, int idTutor, String nombre, String apellido1, String apellido2, String tipoDocumento, 
			String documento, java.util.Date fechaNac, String parentesco, String sexo, String telefono, String email);

	public boolean insertarTutor(int id, String nombre, String apellido1, String apellido2, String tipoDocumento,
			String documento, java.util.Date fechaNac, String parentesco, String sexo, String telefono, String email);
	
	//Metodos despues de la addicion de ejb con jpa
	
	public List<AlumnoTutor> getListaAlumnoTutor();
	
	//public List<AlumnoTutor> getListaAlumnoTutor2();
}
