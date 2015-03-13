package es.opensigad.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoMatriculaDAOInterfaz;

@ManagedBean
@RequestScoped
public class InsertarAlumnoMatriculaBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@EJB
	private AlumnoMatriculaDAOInterfaz matriculaDAO = null;
	
	
	//private int idAlumno;
	private int cursoEscolar;
	private int idCentro;
	private int idEnsenanza;
	private String modulo;
	private int curso;

	private FacesMessage facesMessage;
	
	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionAlumno;

	public SesionBean getSesionAlumno() {
		return sesionAlumno;
	}


	public void setSesionAlumno(SesionBean sesionAlumno) {
		this.sesionAlumno = sesionAlumno;
	}


	public InsertarAlumnoMatriculaBean() {

	}

	
	public int getCursoEscolar() {
		return cursoEscolar;
	}

	public void setCursoEscolar(int cursoEscolar) {
		this.cursoEscolar = cursoEscolar;
	}

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public int getIdEnsenanza() {
		return idEnsenanza;
	}

	public void setIdEnsenanza(int idEnsenanza) {
		this.idEnsenanza = idEnsenanza;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public String insertarAlumnoMatricula(int cursoEscolar,
			int centro, int ensenanza, String modulo, int curso) {

		String pagina = "indexAlumnoMatricula";
		//AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();

		if (matriculaDAO.insertarMatricula(sesionAlumno.getIdAlumno(), cursoEscolar, centro,
				ensenanza, modulo, curso)) {

			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula se ha insertado correctamente ", null);

		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula no se ha insertado correctamente ", null);

		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		return pagina;
	}

}
