package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;

@ManagedBean
@RequestScoped
public class InsertarAlumnoNotaBean implements Serializable {
	
	private int idMatricula;
	private int idEnsenanza;
	private int idMateria;
	private int idEvaluacion;
	private int nota;

	public InsertarAlumnoNotaBean() {

	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public int getIdEnsenanza() {
		return idEnsenanza;
	}

	public void setIdEnsenanza(int idEnsenanza) {
		this.idEnsenanza = idEnsenanza;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}


	public String insertarNotaAlumno(int idAlumnoMatricula, int idMateria,
			 String evaluacion, int nota, String observacion) {
		String pagina = null;
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.insertarNotasAlumnoByIdMatricula(idAlumnoMatricula,
				 idMateria, evaluacion, nota, observacion)) {
			pagina = "insertarAlumnoNotaExito";
		} else {
			pagina = "insertarAlumnoNotaFallo";
		}
		return pagina;
	}

}
