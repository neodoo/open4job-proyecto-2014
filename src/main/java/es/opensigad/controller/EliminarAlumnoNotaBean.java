package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoNotaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;

	public EliminarAlumnoNotaBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String borrarNotaById(int id) {
		String pagina=null;
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.borrarNotaById(id)){
			pagina = "borrarAlumnoNotaExito";
		}else{
			pagina = "borrarAlumnoNotaFallo";
		}
		return pagina;
	}

}
