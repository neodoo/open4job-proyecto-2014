package es.opensigad.model.vo;

import java.util.Date;

public class AlumnoFaltaVO {

	private int id;
	private int idAlumno;
	private Date fecha;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String observaciones;

	public AlumnoFaltaVO() {
	}
	
	public AlumnoFaltaVO(int id, int idAlumno, Date fecha, String sesion,
			String materia, String tipo, String justificado,
			String observaciones) {
		this.id = id;
		this.idAlumno = idAlumno;
		this.fecha = fecha;
		this.sesion = sesion;
		this.materia = materia;
		this.tipo = tipo;
		this.justificado = justificado;
		this.observaciones = observaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getJustificado() {
		return justificado;
	}

	public void setJustificado(String justificado) {
		this.justificado = justificado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String obtervaciones) {
		this.observaciones = obtervaciones;
	}

	public String toString() {
		return ("[" + "id = " + id + ", idAlumno = " + idAlumno + ", fecha = "
				+ fecha + ", sesion = " + sesion + ", materia = " + materia
				+ ", tipo = " + tipo + ", justificado = " + justificado
				+ ", obtervaciones = " + observaciones + "]");
	}

}
