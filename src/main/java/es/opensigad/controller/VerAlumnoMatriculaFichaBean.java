package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.AlumnoMatricula;

@ManagedBean
@SessionScoped
public class VerAlumnoMatriculaFichaBean {

	private int idMatricula;

	private AlumnoMatricula matricula = new AlumnoMatricula ();


	
	public int getIdMatricula() {
		return idMatricula;
	}



	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}



	public AlumnoMatricula getMatriculaVO() {
		return matricula;
	}



	public void setMatriculaVO(AlumnoMatricula matriculaVO) {
		this.matricula = matriculaVO;
	}



	public String getDetalleMatricula() {

		String pagina = "verAlumnoMatriculaFicha";

		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		matricula = matriculaDAO.getListaFichaMatricula(idMatricula);

		return pagina;

	}
}
