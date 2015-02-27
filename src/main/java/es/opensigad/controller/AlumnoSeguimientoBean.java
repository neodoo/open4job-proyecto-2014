package es.opensigad.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import es.opensigad.model.dao.AlumnoSeguimientoDAO;
import es.opensigad.model.vo.AlumnoSeguimiento;

@ManagedBean(name="seguimientoBean")
@ViewScoped

public class AlumnoSeguimientoBean {

	public static final String TIPO_FALTA = "falta";
	public static final String TIPO_INCIDENCIA = "incidencia";

	//public static final int TIPO_FALTA = 0;
	//public static final int TIPO_INCIDENCIA = 1;

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
	
	@ManagedProperty(value="#{sesionBean}")
	private SesionBean sesionBean;
	
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


	public void setObse0rvaciones(String observaciones) {
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
	
	@PostConstruct
	public void init(){
		getListaAlumnoSeguimiento(sesionBean.getIdMatricula());
	}
	

	public String getDetalleAlumnoSeguimiento() {

		String pagina = "alumnoSeguimiento";
		AlumnoSeguimientoDAO seguimientoDAO = new AlumnoSeguimientoDAO();
		seguimiento = seguimientoDAO.getDetalleAlumnoSeguimiento(id);
		
		return pagina;
	}	
	
	public void getListaAlumnoSeguimiento(int idMatricula) {
	
		AlumnoSeguimientoDAO seguimientoDAO = new AlumnoSeguimientoDAO();
		seguimientos = seguimientoDAO.getListaAlumnoSeguimiento(idMatricula);

	}	

	
	public String insertarAlumnoSeguimiento() {
		
		String pagina = null;
		AlumnoSeguimientoDAO alumnoSeguimientoDAO = new AlumnoSeguimientoDAO();

		int valor = alumnoSeguimientoDAO.insertarAlumnoSeguimiento(seguimiento);
		
		if (valor > 0) {
			pagina = "actualizarAlumnoSeguimientoExito";
		} else {
			pagina = "actualizarAlumnoSeguimientoFallo";
		}
	
		return pagina;
	
	}	
	
	public String actualizarAlumnoSeguimiento() {
	
		String pagina = null;
		AlumnoSeguimientoDAO alumnoSeguimientoDAO = new AlumnoSeguimientoDAO();

		boolean estado = alumnoSeguimientoDAO.actualizarAlumnoSeguimiento(seguimiento);
		
		if (estado) {
			pagina = "actualizarAlumnoSeguimientoExito";
		} else {
			pagina = "actualizarAlumnoSeguimientoFallo";
		}
	
		return pagina;
	
	}

	public String eliminarAlumnoSeguimiento() {
	
		String pagina = null;
		AlumnoSeguimientoDAO alumnoSeguimientoDAO = new AlumnoSeguimientoDAO();

		boolean estado = alumnoSeguimientoDAO.eliminarAlumnoSeguimiento(seguimiento);

		if (estado) {
			pagina = "eliminarAlumnoSeguimientoExito";
		} else {
			pagina = "eliminarAlumnoSeguimientoFallo";
		}
	
		return pagina;

	}

}
