package es.opensigad.controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoSeguimientoDAO;
import es.opensigad.model.vo.AlumnoSeguimiento;

@ManagedBean
@RequestScoped
public class AlumnoSeguimientoFichaBean {

	private int id;
	private int idAlumno;
	private Date fecha;
	private String sesion;
	private String materia;
	private String tipo;
	private String justificado;
	private String observaciones;

	private AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();
	private List<AlumnoSeguimiento> alumnoSeguimientos;


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getIdAlumno() {
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
	
	
	public AlumnoSeguimiento getAlumnoSeguimiento() {
		return alumnoSeguimiento;
	}

	public void setFaltaVO(AlumnoSeguimiento alumnoSeguimiento) {
		this.alumnoSeguimiento = alumnoSeguimiento;
	}

	
	public List<AlumnoFaltaVO> getFaltasVO() {
		return faltasVO;
	}
	
	
	public void setFaltasVO(List<AlumnoFaltaVO> faltasVO) {
		this.faltasVO = faltasVO;
	}


	
	public String getDetalleFalta() {
		String pagina = "AlumnoFalta";
		AlumnoSeguimientoDAO faltaDAO = new AlumnoSeguimientoDAO();
		faltaVO = faltaDAO.getDetalleFalta(id);
		
		return pagina;
	}
	
	public String getAlumnoFaltaListado() {
		String pagina = "AlumnoFaltaListado";
		AlumnoSeguimientoDAO faltaDAO = new AlumnoSeguimientoDAO();
		faltasVO = faltaDAO.getListaFaltas(idAlumno);

		return pagina;
	}
	
	public String insertarFalta() {
		String pagina=null;
		AlumnoSeguimientoDAO alumnoFaltaDAO = new AlumnoSeguimientoDAO();

		long count = alumnoFaltaDAO.insertarFalta(faltaVO);
		if (count == 1){
			pagina = "insertarAlumnoFaltaExito";
		}else{
			pagina = "insertarAlumnoFaltaFallo";
		}
		return pagina;
	}
	
	public String actualizarFalta() {
		String pagina=null;
		AlumnoSeguimientoDAO alumnoFaltaDAO = new AlumnoSeguimientoDAO();

		long count = alumnoFaltaDAO.actualizarFalta(faltaVO);
		
		if (count == 1){
			pagina = "actualizarAlumnoFaltaExito";
		}else{
			pagina = "actualizarAlumnoFaltaFallo";
		}
		return pagina;
	}

	public String eliminarFalta() {
		String pagina=null;
		AlumnoSeguimientoDAO alumnoFaltaDAO = new AlumnoSeguimientoDAO();
	
		long count = alumnoFaltaDAO.eliminarFalta(faltaVO.getId());
		
		if (count == 1){
			pagina = "eliminarAlumnoFaltaExito";
		}else{
			pagina = "eliminarAlumnoFaltaFallo";
		}
		return pagina;
	}
}