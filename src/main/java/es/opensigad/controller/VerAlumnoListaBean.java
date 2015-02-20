package es.opensigad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.*;
import es.opensigad.model.vo.*;


@ManagedBean
@SessionScoped
public class VerAlumnoListaBean {

	
	private List<AlumnoVO> alumnoLista;
	private List<AlumnoVO> alumnoFiltro;
	

	


	public List<AlumnoVO> getAlumnoFiltro() {
		return alumnoFiltro;
	}



	public void setAlumnoFiltro(List<AlumnoVO> alumnoFiltro) {
		this.alumnoFiltro = alumnoFiltro;
	}



	public List<AlumnoVO> getAlumnoLista() {
		return alumnoLista;
	}



	public void setAlumnoLista(List<AlumnoVO> alumnoLista) {
		this.alumnoLista = alumnoLista;
	}

	public  String getListAlumno() {

		String pagina = "verAlumnoLista";
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoLista = new ArrayList<AlumnoVO>();
		alumnoLista = alumnoDAO.getListAlumno();

		return pagina;

	}
	
	public String eliminarEvaluacionAlumno(int idEvaluacion) {
		String pagina = null;
		AlumnoEvaluacionDAO alumnoEvaluacionDAO = new AlumnoEvaluacionDAO();
		
		if(alumnoEvaluacionDAO.EliminarEvaluacionAlumno(idEvaluacion)){
			pagina = "eliminarAlumnoEvaluacion";
		}else{
			pagina = "eliminarAlumnoEvaluacionFallo";
		}

		return pagina;
	}

}
