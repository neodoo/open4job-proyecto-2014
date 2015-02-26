package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoMatriculaDAO;

@ManagedBean
@SessionScoped
public class ActualizarAlumnoMatriculaBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private int idMatricula;
	private int cursoEscolar;
	private int centro;
	private int ensenanza;
	private String modulo;
	private int curso;
	private int idAlumno;
	private FacesMessage facesMessage;

	@ManagedProperty(value = "#{verAlumnoMatriculaFichaBean}")
	private VerAlumnoMatriculaFichaBean verAlumnoMatriculaFichaBean;

	public VerAlumnoMatriculaFichaBean getVerAlumnoMatriculaFichaBean() {
		return verAlumnoMatriculaFichaBean;
	}

	public void setVerAlumnoMatriculaFichaBean(
			VerAlumnoMatriculaFichaBean verAlumnoMatriculaFichaBean) {
		this.verAlumnoMatriculaFichaBean = verAlumnoMatriculaFichaBean;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public int getCursoEscolar() {
		return cursoEscolar;
	}

	public void setCursoEscolar(int cursoEscolar) {
		this.cursoEscolar = cursoEscolar;
	}

	public int getCentro() {
		return centro;
	}

	public void setCentro(int centro) {
		this.centro = centro;
	}

	public int getEnsenanza() {
		return ensenanza;
	}

	public void setEnsenanza(int ensenanza) {
		this.ensenanza = ensenanza;
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

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String modificarMatricula(int idAlumno, int cursoEscolar,
			int centro, int ensenanza, String modulo, int curso,
			int idMatricula) {
		String pagina = "indexAlumnoMatricula";
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		if (alumnoMatriculaDAO.modificarMatricula(idAlumno, cursoEscolar,
			centro, ensenanza, modulo, curso, idMatricula)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula se ha actualizado correctamente ", null);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula no se ha insertado correctamente ", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;
	}

}
