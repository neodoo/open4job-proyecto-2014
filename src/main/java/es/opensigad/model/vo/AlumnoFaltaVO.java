package es.opensigad.model.vo;

import java.util.Date;

public class AlumnoFaltaVO {

	private long id;
	private long idAlumno;
	private Date fecha;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String observaciones;

	public AlumnoFaltaVO() {
	}

	public AlumnoFaltaVO(long id, long idAlumno, Date fecha, String sesion,
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
	
	
	public AlumnoFaltaVO(long idAlumno, Date fecha, String sesion,
			String materia, String tipo, String justificado,
			String observaciones) {
		this.idAlumno = idAlumno;
		this.fecha = fecha;
		this.sesion = sesion;
		this.materia = materia;
		this.tipo = tipo;
		this.justificado = justificado;
		this.observaciones = observaciones;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdAlumno() {
		return idAlumno;	
	}

	public void setIdAlumno(long idAlumno) {
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

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String toString() {
		return ("[" + "id = " + id + ", idAlumno = " + idAlumno + ", fecha = "
				+ fecha + ", sesion = " + sesion + ", materia = " + materia
				+ ", tipo = " + tipo + ", justificado = " + justificado
				+ ", obtervaciones = " + observaciones + "]");
	}

}
