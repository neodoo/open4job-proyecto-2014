package es.opensigad.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.*;
import es.opensigad.model.vo.*;

@ManagedBean
@RequestScoped
public class VerAlumnoEvaluacionFichaBean {

	private int idEvaluacion;
	
	private ArrayList<AlumnoEvaluacionVO> listaEvaluacionDetalleVO;

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public ArrayList<AlumnoEvaluacionVO> getlistaEvaluacionDetalleVO() {
		return listaEvaluacionDetalleVO;
	}

	public void setAlumnoEvaluacionDetalleVO(
			ArrayList<AlumnoEvaluacionVO> alumnoEvaluacionDetalleVO) {
		this.listaEvaluacionDetalleVO = alumnoEvaluacionDetalleVO;
	}

	public String getDetalleEvaluacionAlumno(int idEvaluacion) {

		String pagina = "verAlumnoFichaEvaluacion";

		AlumnoEvaluacionDAO evaluacionAlumnoDAO = new AlumnoEvaluacionDAO();
		listaEvaluacionDetalleVO = evaluacionAlumnoDAO
				.getDetalleEvaluacion(idEvaluacion);
		
		return pagina;

	}

}
