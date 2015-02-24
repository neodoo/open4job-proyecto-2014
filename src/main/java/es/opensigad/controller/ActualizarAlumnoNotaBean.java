package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;

@ManagedBean
@RequestScoped
public class ActualizarAlumnoNotaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idMatricula;
	private int idEnsenanza;
	private int idMateria;
	private int idEvaluacion;
	private String nota;

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

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String actualizarNotaByIdMatricula(int idAlumnoMatricula,int idMateria, String evaluacion,String nota, String observacion) {
		String pagina=null;
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.actualizarNotaByIdMatricula(idAlumnoMatricula, idMateria, evaluacion, nota,observacion)){
			pagina = "actualizarAlumnoNotaExito";
		}else{
			pagina = "actualizarAlumnoNotaFallo";
		}
		return pagina;
	}

}
