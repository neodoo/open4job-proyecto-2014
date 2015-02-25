package es.opensigad.controller;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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

	private List<AlumnoTutor> tutorLista;
	
	public List<AlumnoTutor> getTutorLista() {
		return tutorLista;
	}

	public void setTutorLista(List<AlumnoTutor> tutorLista) {
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
	
	public  String getListaAlumnoTutor() {
		
		String pagina = "verListaAlumnoTutor";
		
		TutorDAO tutorDAO = new TutorDAO();
		tutorLista = tutorDAO.getListaAlumnoTutor(idAlumno);
		
		return pagina;

	}
}
