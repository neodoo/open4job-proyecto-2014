package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoNotaBean implements Serializable {
	
	private int idMatricula;

	public EliminarAlumnoNotaBean() {

	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String borrarNotaByIdMatricula(int idMatricula) {
		String pagina=null;
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.borrarNotaByIdMatricula(idMatricula)){
			pagina = "borrarAlumnoNotaExito";
		}else{
			pagina = "borrarAlumnoNotaFallo";
		}
		return pagina;
	}

}
