package es.opensigad.controller;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.Tutor;


@ManagedBean
@RequestScoped
public class VerTutorBean {
	
	private int id;

	private Tutor tutorVO;
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

	public Tutor getTutor() {
		return tutorVO;
	}

	public void setTutor(Tutor tutorVO) {
		this.tutorVO = tutorVO;
	}

	public String getDetalleTutor(int idTutor) {

		String pagina = "verTutoresPorAlumno";

		TutorDAO tutorDAO = new TutorDAO();
		tutorLista = tutorDAO.getListaTutor(id);

		return pagina;

	}
	
	public  String getListaTutor() {

		String pagina = "verTutoresPorAlumno.xhtml";
		TutorDAO tutorDAO = new TutorDAO();
		//tutorLista = new ArrayList<AlumnoTutor>();
		tutorLista = tutorDAO.getListaTutor(id);

		return pagina;

	}
}
