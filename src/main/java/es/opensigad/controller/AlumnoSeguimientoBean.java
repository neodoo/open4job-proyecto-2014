package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	// con la inyeccion equivalente al AlumnoSeguimientoDAOInterfaz bean =
	// dolookUp() del otro ejecicio

	public AlumnoSeguimientoDAOInterfaz getAlumnoSeguimientoDAOInterfaz() {
		return alumnoSeguimientoDAOInterfaz;
	}

	public void setAlumnoSeguimientoDAOInterfaz(AlumnoSeguimientoDAOInterfaz alumnoSeguimientoDAOInterfaz) {
		this.alumnoSeguimientoDAOInterfaz = alumnoSeguimientoDAOInterfaz;
	}

	public static final String TIPO_FALTA = "falta";
	public static final String TIPO_INCIDENCIA = "incidencia";

	// public static final int TIPO_FALTA = 0;
	// public static final int TIPO_INCIDENCIA = 1;

	private int id;
	private int idMatricula;
	private Date fecha;
	private String sesion;
	private int idMateria;
	private String tipo;
	private int justificante;
	private String observaciones;

	private AlumnoSeguimiento seguimiento = new AlumnoSeguimiento();

	private List<AlumnoSeguimiento> seguimientos;
	private List<AlumnoSeguimiento> seguimientosFiltro;

	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	@PostConstruct
	public void init() {
		getListaAlumnoSeguimiento(sesionBean.getIdMatricula());
	}
	
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

	public List<AlumnoSeguimiento> getSeguimientos() {
		return seguimientos;
	}

	public void setSeguimientos(List<AlumnoSeguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public List<AlumnoSeguimiento> getSeguimientosFiltro() {
		return seguimientosFiltro;
	}

	public void setSeguimientosFiltro(List<AlumnoSeguimiento> seguimientosFiltro) {
		this.seguimientosFiltro = seguimientosFiltro;
	}

	public String getDetalleAlumnoSeguimiento() {

		String pagina = "alumnoSeguimiento";

		seguimiento = alumnoSeguimientoDAOInterfaz.getDetalleAlumnoSeguimiento(id);

		return pagina;
	}

	public String getListaAlumnoSeguimiento(int idMatricula) {

		String pagina = "alumnoSeguimientoListado";

		seguimientos = alumnoSeguimientoDAOInterfaz.getListaAlumnoSeguimiento(idMatricula);

		return pagina;

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