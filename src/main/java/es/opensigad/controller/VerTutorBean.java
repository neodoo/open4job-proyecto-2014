package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import es.opensigad.model.dao.TutorDAOInterface;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class VerTutorBean implements Serializable {

	@EJB
	private TutorDAOInterface tutorDAOInterface = null;

	private static final long serialVersionUID = 1L;

	public TutorDAOInterface getTutorDAOInterface() {
		return tutorDAOInterface;
	}

	public void setTutorDAOInterface(TutorDAOInterface tutorDAOInterface) {
		this.tutorDAOInterface = tutorDAOInterface;
	}

	private int id;

	private int idAlumno;

	private Tutor tutor = new Tutor();

	private Tutor tutorSeleccionado = new Tutor();

	public Tutor getTutorSeleccionado() {
		return tutorSeleccionado;
	}

	public void setTutorSeleccionado(Tutor tutorSeleccionado) {
		this.tutorSeleccionado = tutorSeleccionado;
	}

	private List<Tutor> tutorLista;

	private List<AlumnoTutor> alumnoTutorLista;

	private String parentescoActual;

	@PostConstruct
	public void init() {
		getListaAlumnoTutor();
	}

	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	public VerTutorBean() {
	}

	// GETTERS & SETTERS

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public List<AlumnoTutor> getAlumnoTutorLista() {
		return alumnoTutorLista;
	}

	public void setAlumnoTutorLista(List<AlumnoTutor> alumnoTutorLista) {
		this.alumnoTutorLista = alumnoTutorLista;
	}

	public List<Tutor> getTutorLista() {
		return tutorLista;
	}

	public void setTutorLista(List<Tutor> tutorLista) {
		this.tutorLista = tutorLista;
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

	public String getParentescoActual() {
		return parentescoActual;
	}

	public void setParentescoActual(String parentescoActual) {
		this.parentescoActual = parentescoActual;
	}

	
	public void getListaAlumnoTutor() {

		tutorLista = tutorDAOInterface.getListaTutor(sesionBean.getIdAlumno());
	}
	
	

	public String getListaTutor() {

		String pagina = "verListaAlumnoTutor.xhtml";

		sesionBean.setIdAlumno(idAlumno);

		alumnoTutorLista = tutorDAOInterface.getListaAlumnoTutor(sesionBean
				.getIdAlumno());
		return pagina;
	}
	
	

	public String getDetalleTutor(int idTutor) {

		String pagina = "verTutorFicha.xhtml";

		tutor = tutorDAOInterface.getDetalleTutor(idTutor);
		
		parentescoActual = tutorDAOInterface.getParentesco(sesionBean.getIdAlumno(), idTutor);

		if (tutor != null) {
			sesionBean.setIdTutor(tutor.getId());
			
			return pagina;
		}

		pagina = "indexAlumnoTutor.xhtml";
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "El tutor con el id "
						+ idTutor + " no existe", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		return pagina;

	}

}
