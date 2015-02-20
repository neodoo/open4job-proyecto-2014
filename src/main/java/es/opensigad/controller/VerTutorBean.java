package es.opensigad.controller;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.TutorDAO;


@ManagedBean
@RequestScoped
public class VerTutorBean {
	
	private int id;
/*
	private TutorVO tutorVO;
	private List<TutorVO> tutorLista;
	
	public List<TutorVO> getTutorLista() {
		return tutorLista;
	}

	public void setTutorLista(List<TutorVO> tutorLista) {
		this.tutorLista = tutorLista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TutorVO getTutorVO() {
		return tutorVO;
	}

	public void setTutorVO(TutorVO tutorVO) {
		this.tutorVO = tutorVO;
	}

	public String getDetalleTutor(int idTutor) {

		String pagina = "verTutoresPorAlumno";

		TutorDAO tutorDAO = new TutorDAO();
		tutorLista = tutorDAO.getlistaTutor(id);

		return pagina;

	}
	
	public  String getListaTutor() {

		String pagina = "verTutoresPorAlumno.xhtml";
		TutorDAO tutorDAO = new TutorDAO();
		tutorLista = new ArrayList<TutorVO>();
		tutorLista = tutorDAO.getlistaTutor(id);

		return pagina;

	}
	*/
}
