package es.opensigad.controller;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;


@ManagedBean
@RequestScoped
public class VerTutorBean {
	
	private int id;

	private int idAlumno;

	private Tutor tutor;

	private List<Tutor> tutorLista;
	
	private List<AlumnoTutor> alumnoTutorLista;
	
	
	
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

	public String getDetalleTutor(int idTutor) {

		String pagina = "verTutoresPorAlumno";

		TutorDAO tutorDAO = new TutorDAO();
		tutor = tutorDAO.getDetalleTutor(idTutor);
		
		return pagina;

	}
	
	public  String getListaTutor() {
		
		String pagina = "verListaAlumnoTutor";
		
		//ofe
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("idAlumno", idAlumno);
		TutorDAO tutorDAO = new TutorDAO();
		alumnoTutorLista = tutorDAO.getListaAlumnoTutor2();
		
		return pagina;

	}
}
