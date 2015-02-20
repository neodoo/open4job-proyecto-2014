package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoSeguimientoDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class InsertarAlumnoFaltaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long idAlumno;
	private Date fecha;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String observaciones;
	
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

	public InsertarAlumnoFaltaBean() {
	}

	public String insertarFalta(AlumnoFaltaVO falta) {
		String pagina = null;
		AlumnoSeguimientoDAO alumnoFaltaDAO = new AlumnoSeguimientoDAO();
		if (alumnoFaltaDAO.insertarFalta(falta) > 0) {
			pagina = "insertarAlumnoFaltaExito";
		} else {
			pagina = "insertarAlumnoFaltaFallo";
		}
		return pagina;
	}

}
