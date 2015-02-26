package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.Centro;
import es.opensigad.model.vo.Ensenanza;

@ManagedBean
@RequestScoped
public class InsertarAlumnoMatriculaBean implements Serializable {

	private int idAlumno;
	private int cursoEscolar;
	private int idCentro;
	private int idEnsenanza;
	private String modulo;
	private int curso;
	
	private FacesMessage facesMessage;

	public InsertarAlumnoMatriculaBean() {

	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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

	public String insertarAlumnoMatricula(int idAlumno, int cursoEscolar,
			int centro, int ensenanza, String modulo, int curso) {
		
		String pagina = "indexAlumnoMatricula";
		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		
		if (matriculaDAO.insertarMatricula(idAlumno, cursoEscolar, centro,
				ensenanza, modulo, curso)) {
			
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula se ha insertado correctamente ",
					null);
			//FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula no se ha insertado correctamente ", null);
			//FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		
		return pagina;
	}

}
