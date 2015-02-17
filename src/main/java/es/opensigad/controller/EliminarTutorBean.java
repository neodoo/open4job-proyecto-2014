package es.opensigad.controller;

import java.io.Serializable;

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
	private int idTutor;
	
	
	public int getIdTutor() {
		return idTutor;
	}
	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}
	
	//@ManagedProperty(value="#{verTutorBean}")
	private VerTutorBean verTutorBean;
	
	public VerTutorBean getVerTutorBean() {
		return verTutorBean;
	}

	public void setVerAlumnoFichaBean(VerTutorBean verTutorBean) {
		this.verTutorBean = verTutorBean;
	}

	public String deleteTutor(int idTutor) {

		String pagina = "indexAlumnoTutor";

		TutorDAO tutorDAO = new TutorDAO();
		tutorDAO.deleteTutor(idTutor);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"El Tutor con id " + idTutor
						+ " ha sido eliminado", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}
}
