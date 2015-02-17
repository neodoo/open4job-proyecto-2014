package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;
import es.opensigad.model.vo.AlumnoMatriculaVO;

@ManagedBean
@SessionScoped
public class ActualizarAlumnoMatriculaBean implements Serializable{

	private int idMatricula;
	private String fechaCurso;
	private String centro;
	private String tipoEnsenanza;
	private String ensenanza;
	private String curso;
	private int idAlumno;
	
	@ManagedProperty(value = "#{verAlumnoMatriculaFichaBean}")
	private VerAlumnoMatriculaFichaBean verAlumnoMatriculaFichaBean;
	/*private AlumnoMatriculaVO matriculaVO = new AlumnoMatriculaVO ();
	
	public AlumnoMatriculaVO getMatriculaVO() {
		return matriculaVO;
	}

	public void setMatriculaVO(AlumnoMatriculaVO matriculaVO) {
		this.matriculaVO = matriculaVO;
	}

	public ActualizarAlumnoMatriculaBean(){
		
	}*/
	
	
	public int getIdMatricula() {
		return idMatricula;
	}

	public VerAlumnoMatriculaFichaBean getVerAlumnoMatriculaFichaBean() {
		return verAlumnoMatriculaFichaBean;
	}

	public void setVerAlumnoMatriculaFichaBean(
			VerAlumnoMatriculaFichaBean verAlumnoMatriculaFichaBean) {
		this.verAlumnoMatriculaFichaBean = verAlumnoMatriculaFichaBean;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}
	public String getFechaCurso() {
		return fechaCurso;
	}
	public void setFechaCurso(String fechaCurso) {
		this.fechaCurso = fechaCurso;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getTipoEnsenanza() {
		return tipoEnsenanza;
	}
	public void setTipoEnsenanza(String tipoEnsenanza) {
		this.tipoEnsenanza = tipoEnsenanza;
	}
	public String getEnsenanza() {
		return ensenanza;
	}
	public void setEnsenanza(String ensenanza) {
		this.ensenanza = ensenanza;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	public String modificarMatricula (int idAlumno, String fecha,
			String centro, String tipoEnsenanza, String ensenanza, String curso, int idMatricula ){
		String pagina=null;
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		if (alumnoMatriculaDAO.modificarMatricula(idAlumno, fecha,
			centro, tipoEnsenanza, ensenanza,  curso, idMatricula)){
			pagina="actualizarAlumnoMatriculaExito";
		}else{
			pagina="actualizarAlumnoMatriculaFallo";
		}
		return pagina;
	}

}
