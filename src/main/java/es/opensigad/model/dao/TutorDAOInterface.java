package es.opensigad.model.dao;
import es.opensigad.model.vo.Tutor;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;




public interface TutorDAOInterface {

	// recibe 1 idtutor y devuelve ese tutor
	public abstract Tutor getDetalleTutor(int id);

	// borra 1 tutor con el id recibido
	public abstract boolean deleteTutor(int id);

	// modifica un tutor con el id recibido
	public abstract boolean updateTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.util.Date fechaNac, String parentesco,
			String sexo, String telefono, String email);

    public abstract boolean insertarTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, java.util.Date fechaNac, String parentesco,
			String sexo, String telefono, String email);
	
}
