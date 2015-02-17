package es.opensigad.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.*;
import es.opensigad.model.vo.*;

@ManagedBean
@RequestScoped
public class VerAlumnoEvaluacionFichaBean {

	private int id;
	
	private ArrayList<AlumnoEvaluacionVO> listaEvaluacionDetalleVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<AlumnoEvaluacionVO> getlistaEvaluacionDetalleVO() {
		return listaEvaluacionDetalleVO;
	}

	public void setAlumnoEvaluacionDetalleVO(
			ArrayList<AlumnoEvaluacionVO> alumnoEvaluacionDetalleVO) {
		this.listaEvaluacionDetalleVO = alumnoEvaluacionDetalleVO;
	}

	public String getDetalleEvaluacionAlumno(int id) {

		String pagina = "verAlumnoFichaEvaluacion";

		AlumnoEvaluacionDAO evaluacionAlumnoDAO = new AlumnoEvaluacionDAO();
		listaEvaluacionDetalleVO = evaluacionAlumnoDAO
				.getDetalleEvaluacion(id);
		
		return pagina;

	}

}
