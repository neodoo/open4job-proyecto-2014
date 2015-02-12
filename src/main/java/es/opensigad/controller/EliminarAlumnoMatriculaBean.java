package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoMatriculaBean implements Serializable {

	private int idMatricula;

	public EliminarAlumnoMatriculaBean() {

	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String borrarMatricula(int idMatricula) {
		String pagina = null;
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		if (alumnoMatriculaDAO.borrarMatricula(idMatricula)) {
			pagina = "borrarAlumnoMatriculaExito";
		} else {
			pagina = "borrarAlumnoMatriculaFallo";
		}
		return pagina;
	}

}
