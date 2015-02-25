package es.opensigad.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.TutorDAO;

@ManagedBean
@RequestScoped
public class EliminarTutorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idAlumnoTutor;

	public int getIdAlumnoTutor() {
		return idAlumnoTutor;
	}

	public void setIdAlumnoTutor(int idAlumnoTutor) {
		this.idAlumnoTutor = idAlumnoTutor;
	}

	//@ManagedProperty(value="#{verTutorBean}")
	private VerTutorBean verTutorBean;
	
	public VerTutorBean getVerTutorBean() {
		return verTutorBean;
	}

	public void setVerAlumnoFichaBean(VerTutorBean verTutorBean) {
		this.verTutorBean = verTutorBean;
	}

	public String deleteTutor() {

		String pagina = "indexAlumnoTutor.xhtml";

		TutorDAO tutorDAO = new TutorDAO();
		
		if(tutorDAO.deleteAlumnoTutor(idAlumnoTutor))
			return pagina;
		else
			return "index.xhtml";

	}
	
}
