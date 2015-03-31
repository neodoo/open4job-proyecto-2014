package es.opensigad.controller;

import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.dao.TutorDAOInterface;
import es.opensigad.model.vo.AlumnoTutor;

@ManagedBean
@RequestScoped
public class EliminarTutorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private TutorDAOInterface tutorDAOInterface = null;
	
	private AlumnoTutor alumnoTutor = new AlumnoTutor();
	
	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;
	
	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public TutorDAOInterface getTutorDAOInterface() {
		return tutorDAOInterface;
	}

	public void setTutorDAOInterface(TutorDAOInterface tutorDAOInterface) {
		this.tutorDAOInterface = tutorDAOInterface;
	}

	public AlumnoTutor getAlumnoTutor() {
		return alumnoTutor;
	}

	public void setAlumnoTutor(AlumnoTutor alumnoTutor) {
		this.alumnoTutor = alumnoTutor;
	}

	public String deleteTutor() {

		String pagina = "verListaAlumnoTutor";

		
		if(tutorDAOInterface.deleteAlumnoTutor(sesionBean.getIdAlumno(),sesionBean.getIdTutor()))
			return pagina;
		else
			return pagina;

	}
	
}
