package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import es.opensigad.model.dao.AlumnoSeguimientoDAOInterfaz;
import es.opensigad.model.vo.AlumnoSeguimiento;

@ManagedBean
@ViewScoped
public class AlumnoSeguimientoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private AlumnoSeguimientoDAOInterfaz alumnoSeguimientoDAOInterfaz = null;

	public AlumnoSeguimientoDAOInterfaz getAlumnoSeguimientoDAOInterfaz() {
		return alumnoSeguimientoDAOInterfaz;
	}

	public void setAlumnoSeguimientoDAOInterfaz(AlumnoSeguimientoDAOInterfaz alumnoSeguimientoDAOInterfaz) {
		this.alumnoSeguimientoDAOInterfaz = alumnoSeguimientoDAOInterfaz;
	}

	public static final String TIPO_FALTA = "falta";
	public static final String TIPO_INCIDENCIA = "incidencia";

	private int id;
	private int idMatricula;
	private Date fecha;
	private String sesion;
	private int idMateria;
	private String tipo;
	private int justificante;
	private String observaciones;

	private AlumnoSeguimiento seguimiento = new AlumnoSeguimiento();

	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	/*
	@PostConstruct
	public void init() {
		getDetalleAlumnoSeguimiento(sesionBean.getIdSeguimiento());
	}
	*/
	
	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
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

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getJustificante() {
		return justificante;
	}

	public void setJustificante(int justificante) {
		this.justificante = justificante;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public AlumnoSeguimiento getSeguimiento() {
		return seguimiento;
	}

	public void setSeguimiento(AlumnoSeguimiento seguimiento) {
		this.seguimiento = seguimiento;
	}

	public void getDetalleAlumnoSeguimiento(int id) {
		seguimiento = alumnoSeguimientoDAOInterfaz.getDetalleAlumnoSeguimiento(id);
	}

	public String insertarAlumnoSeguimiento() {
		
		String pagina = null;

		int valor = alumnoSeguimientoDAOInterfaz.insertarAlumnoSeguimiento(seguimiento);

		if (valor > 0) {
			pagina = "actualizarAlumnoSeguimientoExito";
		} else {
			pagina = "actualizarAlumnoSeguimientoFallo";
		}

		return pagina;

	}

	public String actualizarAlumnoSeguimiento() {

		String pagina = null;

		boolean estado = alumnoSeguimientoDAOInterfaz.actualizarAlumnoSeguimiento(seguimiento);

		if (estado) {
			pagina = "actualizarAlumnoSeguimientoExito";
		} else {
			pagina = "actualizarAlumnoSeguimientoFallo";
		}

		return pagina;

	}

	public String eliminarAlumnoSeguimiento() {

		String pagina = null;

		boolean estado = alumnoSeguimientoDAOInterfaz.eliminarAlumnoSeguimiento(seguimiento);

		if (estado) {
			pagina = "eliminarAlumnoSeguimientoExito";
		} else {
			pagina = "eliminarAlumnoSeguimientoFallo";
		}

		return pagina;

	}

}