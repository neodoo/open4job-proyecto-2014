package es.opensigad.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.AlumnoTutor;

@ManagedBean
@RequestScoped
public class EliminarTutorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private AlumnoTutor alumnoTutor = new AlumnoTutor();

	public AlumnoTutor getAlumnoTutor() {
		return alumnoTutor;
	}

	public void setAlumnoTutor(AlumnoTutor alumnoTutor) {
		this.alumnoTutor = alumnoTutor;
	}

	public String deleteTutor(int idTutor) {

		String pagina = "indexAlumnoTutor";

		TutorDAO tutorDAO = new TutorDAO();
		
		if(tutorDAO.deleteAlumnoTutor(idTutor))
			return pagina;
		else
			return "indexAlumnoTutor";

	}
	
}
