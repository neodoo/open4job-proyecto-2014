package es.opensigad.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SesionBean {

	private int idAlumno;
	private int NumExpediente;
	private int idMatricula;

	// GETTERS Y SETTERS
	
	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getNumExpediente() {
		return NumExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		NumExpediente = numExpediente;
	}
}
