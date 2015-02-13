package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class ActualizarAlumnoFaltaBean implements Serializable {
	
	private int id;
	private int idAlumno;
	private Date fecha;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String observaciones;

	public ActualizarAlumnoFaltaBean() {

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


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String actualizarFalta(AlumnoFaltaVO falta) {
		String pagina=null;
		AlumnoFaltaDAO alumnoFaltaDAO = new AlumnoFaltaDAO();
		if (alumnoFaltaDAO.actualizarFalta(falta)){
			pagina = "actualizarAlumnoFaltaExito";
		}else{
			pagina = "actualizarAlumnoFaltaFallo";
		}
		return pagina;
	}

}
