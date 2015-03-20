package es.opensigad.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.api.UIData;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import es.opensigad.model.dao.TutorDAOInterface;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;


@ManagedBean
@RequestScoped
public class VerTutorBean {
	
	@EJB
	private TutorDAOInterface tutorDAOInterface =null;
	
	private int id;

	private int idAlumno;

	private Tutor tutor;

	private List<Tutor> tutorLista;
		
	private List<AlumnoTutor> alumnoTutorLista;
	
	@ManagedProperty(value="#{sesionBean}")
	private SesionBean sesionBean;
	
	
	//GETTERS & SETTERS
	public TutorDAOInterface getTutorDAOInterface() {
		return tutorDAOInterface;
	}
	public void setTutorDAOInterface(TutorDAOInterface tutorDAOInterface) {
		this.tutorDAOInterface = tutorDAOInterface;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public List<Tutor> getTutorLista() {
		return tutorLista;
	}

	public void setTutorLista(List<Tutor> tutorLista) {
		this.tutorLista = tutorLista;
	}
	
	public List<AlumnoTutor> getAlumnoTutorLista() {
		return alumnoTutorLista;
	}

	public void setAlumnoTutorLista(List<AlumnoTutor> alumnoTutorLista) {
		this.alumnoTutorLista = alumnoTutorLista;
	}

	
	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}
	
	public  String getListaTutor() {
		
		String pagina = "verListaAlumnoTutor";
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("idAlumno", idAlumno); //sesionBean.getIdAlumno());
		alumnoTutorLista = tutorDAOInterface.getListaAlumnoTutor();
		
		return pagina;

	}
}
