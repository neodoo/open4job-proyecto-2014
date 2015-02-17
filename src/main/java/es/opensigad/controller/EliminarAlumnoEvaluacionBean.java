package es.opensigad.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoEvaluacionDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoEvaluacionBean {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String eliminarEvaluacionAlumno(int id) {
		String pagina = null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		
		if(alumnoEvaluacionDAO.EliminarEvaluacionAlumno(id)){
			pagina = "borrarAlumnoEvaluacion";
		}else{
			pagina = "borrarAlumnoEvaluacionFallo";
		}

		return pagina;
	}
}
