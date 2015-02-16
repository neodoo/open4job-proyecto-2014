package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.opensigad.model.vo.AlumnoEvaluacionVO;


public interface AlumnoEvaluacionInterfaz{
	
	 public abstract  ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado() ;
	 public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int idEvaluacion);
	 public boolean insertarEvaluacionAlumno(int idEnsenanza, int idCurso,
				int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion,
				Date fechaPublicacion);
	 public abstract void EditarEvaluacionesVO();
	 public abstract boolean EliminarEvaluacionAlumno(int idEValuacion);
	 
}
