package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;

@ManagedBean
@RequestScoped
public class ActualizarAlumnoNotaBean implements Serializable {
	
	private int idMatricula;
	private int idEnsenanza;
	private int idMateria;
	private int idEvaluacion;
	private int nota;

	public ActualizarAlumnoNotaBean() {

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

	public String actualizarNotaByIdMatricula(int idMatricula, int idEnsenanza, int idMateria, int idEvalucion, int nota) {
		String pagina=null;
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.actualizarNotaByIdMatricula(idMatricula, idEnsenanza, idMateria, idEvalucion, nota)){
			pagina = "actualizarAlumnoNotaExito";
		}else{
			pagina = "actualizarAlumnoNotaFallo";
		}
		return pagina;
	}

}
