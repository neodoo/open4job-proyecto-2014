package es.opensigad.controller;

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


	public AlumnoMatricula getMatricula() {
		return matricula;
	}



	public void setMatricula(AlumnoMatricula matricula) {
		this.matricula = matricula;
	}



	public String getDetalleMatricula() {

		String pagina = "verAlumnoMatriculaFicha";

		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		matricula = matriculaDAO.getListaFichaMatricula(idMatricula);

		return pagina;

	}
}
