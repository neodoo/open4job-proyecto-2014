package es.opensigad.controller;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.Alumno;


@ManagedBean
@RequestScoped
public class VerAlumnoListaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Alumno> alumnoLista;
	private List<Alumno> alumnoFiltro;

	public VerAlumnoListaBean() {
		getListAlumno();
	}

	public List<Alumno> getAlumnoFiltro() {
		return alumnoFiltro;
	}

	public void setAlumnoFiltro(List<Alumno> alumnoFiltro) {
		this.alumnoFiltro = alumnoFiltro;
	}

	public List<Alumno> getAlumnoLista() {
		return alumnoLista;
	}

	public void setAlumnoLista(List<Alumno> alumnoLista) {
		this.alumnoLista = alumnoLista;
	}

	public void getListAlumno() {

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoLista = alumnoDAO.getListAlumno();
	}

}