package es.opensigad.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoFaltaBean implements Serializable {
	
	private int id;

	public EliminarAlumnoFaltaBean() {

	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String eliminarFalta(int id) {
		String pagina=null;
		AlumnoFaltaDAO alumnoFaltaDAO = new AlumnoFaltaDAO();
		if (alumnoFaltaDAO.eliminarFalta(id)){
			pagina = "eliminarAlumnoFaltaExito";
		}else{
			pagina = "eliminarAlumnoFaltaFallo";
		}
		return pagina;
	}

}
