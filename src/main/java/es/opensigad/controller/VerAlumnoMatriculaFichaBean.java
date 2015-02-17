package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.AlumnoMatriculaVO;

@ManagedBean
@SessionScoped
public class VerAlumnoMatriculaFichaBean {

	private int idMatricula;

	private AlumnoMatriculaVO matriculaVO = new AlumnoMatriculaVO ();


	
	public int getIdMatricula() {
		return idMatricula;
	}



	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}



	public AlumnoMatriculaVO getMatriculaVO() {
		return matriculaVO;
	}



	public void setMatriculaVO(AlumnoMatriculaVO matriculaVO) {
		this.matriculaVO = matriculaVO;
	}



	public String getDetalleMatricula() {

		String pagina = "verAlumnoMatriculaFicha";

		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		matriculaVO = matriculaDAO.getListaFichaMatricula(idMatricula);

		return pagina;

	}
}
