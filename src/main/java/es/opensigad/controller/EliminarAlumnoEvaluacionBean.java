package es.opensigad.controller;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoEvaluacionDAO;


@ManagedBean
@RequestScoped
public class EliminarAlumnoEvaluacionBean {
	private int idEvaluacion;

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public String eliminarEvaluacionAlumno(int idEvaluacion) {
		String pagina = null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		
		if(alumnoEvaluacionDAO.EliminarEvaluacionAlumno(idEvaluacion)){
			pagina = "borrarAlumnoEvaluacion";
		}else{
			pagina = "borrarAlumnoEvaluacionFallo";
		}

		return pagina;
	}
}
