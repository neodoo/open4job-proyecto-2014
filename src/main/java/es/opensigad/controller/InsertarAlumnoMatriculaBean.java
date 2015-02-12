package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;

@ManagedBean
@RequestScoped
public class InsertarAlumnoMatriculaBean implements Serializable{
	
	private int idAlumno;
	private Date fecha;
	private String centro;
	private String tipoEnsenanza;
	private String ensenanza;
	private String curso;

	InsertarAlumnoMatriculaBean() {

	}

	public String insertarAlumnoMatricula(int idAlumno, Date fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso) {
		String pagina = null;/*
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.insertarNotasAlumnoByIdMatricula(idMatricula,
				idEnsenanza, idMateria, idEvalucion, nota)) {
			pagina = "insertarAlumnoNotaExito";
		} else {
			pagina = "insertarAlumnoNotaFallo";
		}*/
		return pagina;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
}
