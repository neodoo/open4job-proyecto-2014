package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;

@ManagedBean
@RequestScoped
public class InsertarAlumnoMatriculaBean implements Serializable {

	private int idAlumno;
	private String fecha;
	private String tipoEnsenanza;
	private String centro;
	private String ensenanza;
	private String curso;

	public InsertarAlumnoMatriculaBean() {

	}



	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getTipoEnsenanza() {
		return tipoEnsenanza;
	}

	public void setTipoEnsenanza(String tipoEnsenanza) {
		this.tipoEnsenanza = tipoEnsenanza;
	}

	public String getEnsenanza() {
		return ensenanza;
	}

	public void setEnsenanza(String ensenanza) {
		this.ensenanza = ensenanza;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String insertarAlumnoMatricula(int idAlumno, String fecha,
			String centro, String tipoEnsenanza, String ensenanza, String curso) {
		String pagina = null;
		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();

		if (matriculaDAO.insertarMatricula(idAlumno, fecha, centro,
				tipoEnsenanza, ensenanza, curso)) {
			pagina = "insertarAlumnoMatriculaExito";
		} else {
			pagina = "insertarAlumnoMatriculaFallo";
		}

		return pagina;
	}
}
