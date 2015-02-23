package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.AlumnoMatricula;

@ManagedBean
@RequestScoped
public class VerAlumnoMatriculaListadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private List<AlumnoMatricula> listaMatricula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AlumnoMatricula> getListaMatricula() {
		return listaMatricula;
	}

	public void setListaMatricula(List<AlumnoMatricula> listaMatriculaVO) {
		this.listaMatricula = listaMatricula;
	}

	public String getListaMatricula(int idAlumno) {

		String pagina = "verAlumnoMatriculaListado";
		
		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		listaMatricula = matriculaDAO.getListadoMatricula(idAlumno);
		
		return pagina;

	}

}
