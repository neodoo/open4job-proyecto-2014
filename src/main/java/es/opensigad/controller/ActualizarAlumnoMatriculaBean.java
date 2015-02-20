package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.AlumnoSeguimientoDAO;
import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.AlumnoMatricula;

@ManagedBean
@SessionScoped
public class ActualizarAlumnoMatriculaBean implements Serializable {

	private int idMatricula;
	private int cursoEscolar;
	private String centro;
	private String ensenanza;
	private String modulo;
	private int curso;
	private int idAlumno;

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

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getEnsenanza() {
		return ensenanza;
	}

	public void setEnsenanza(String ensenanza) {
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
			String centro, String ensenanza, String modulo, int curso,
			int idMatricula) {
		String pagina = null;
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		if (alumnoMatriculaDAO.modificarMatricula(idAlumno, cursoEscolar,
				centro, ensenanza, modulo, curso, idMatricula)) {
			pagina = "actualizarAlumnoMatriculaExito";
		} else {
			pagina = "actualizarAlumnoMatriculaFallo";
		}
		return pagina;
	}

}
