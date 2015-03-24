package es.opensigad.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoMatriculaDAOInterfaz;
import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.EnsenanzaMateria;

@ManagedBean
@RequestScoped
public class InsertarAlumnoNotaBean implements Serializable {
	private FacesMessage facesMessage;
	@EJB
	private AlumnoNotaDAOInterfaz alumnoNotaDAO=null;
	
	private static final long serialVersionUID = 1L;
 
	private AlumnoMatricula alumnoMatricula=new AlumnoMatricula();

	private EnsenanzaMateria ensenanzaMateria = new EnsenanzaMateria();
	private int evaluacion;
	private String nota;
	private String observacion;
	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}
	public InsertarAlumnoNotaBean() {

	}

	public AlumnoNotaDAOInterfaz getAlumnoNotaDAO() {
		return alumnoNotaDAO;
	}

	public void setAlumnoNotaDAO(AlumnoNotaDAOInterfaz alumnoNotaDAO) {
		this.alumnoNotaDAO = alumnoNotaDAO;
	}

	public AlumnoMatricula getAlumnoMatricula() {
		return alumnoMatricula;
	}

	public void setAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		this.alumnoMatricula = alumnoMatricula;
	}

	public EnsenanzaMateria getEnsenanzaMateria() {
		return ensenanzaMateria;
	}

	public void setEnsenanzaMateria(EnsenanzaMateria ensenanzaMateria) {
		this.ensenanzaMateria = ensenanzaMateria;
	}

	public int getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String insertarNotaAlumno(int idMateria,
			 String evaluacion, String nota, String observacion) {
		
		String pagina = "verAlumnoNotaListado";	
		if (alumnoNotaDAO.insertarNotasAlumnoByIdMatricula(idMateria,sesionBean.getIdMatricula(), evaluacion, nota, observacion)) {
			
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La nota del alumno con matricula "
							+ sesionBean.getIdMatricula()
							+ " ha sido insertada.", null);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La nota del alumno con matricula "
							+ sesionBean.getIdMatricula()
							+ " NO ha sido insertada.", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;
	}
}
