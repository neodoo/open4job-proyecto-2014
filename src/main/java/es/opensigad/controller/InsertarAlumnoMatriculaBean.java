package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.Centro;
import es.opensigad.model.vo.Ensenanza;

@ManagedBean
@RequestScoped
public class InsertarAlumnoMatriculaBean implements Serializable {

	private int idAlumno;
	private int cursoEscolar;
	private String centro;
	private String ensenanza;
	private String modulo;
	private int curso;

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

	public String getCentro() {
		return centro;
	}
	//
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
	}//

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public String insertarAlumnoMatricula(int idAlumno, int cursoEscolar,
			String centro, String ensenanza, String modulo, int curso) {
		String pagina = null;
		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		
		
		if (matriculaDAO.insertarMatricula(idAlumno, cursoEscolar, centro,
				ensenanza, modulo, curso)) {
			pagina = "insertarAlumnoMatriculaExito";
		} else {
			pagina = "insertarAlumnoMatriculaFallo";
		}

		return pagina;
	}

}
