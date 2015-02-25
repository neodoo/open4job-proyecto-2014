package es.opensigad.controller;
<<<<<<< HEAD
/*
import java.util.ArrayList;
=======

import java.io.Serializable;
>>>>>>> c2b8c9ba47b72a3d86ba7b7b570ba42ecbcd6ff4
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
*/