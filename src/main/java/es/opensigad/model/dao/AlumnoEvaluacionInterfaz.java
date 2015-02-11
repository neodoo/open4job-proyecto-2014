package es.opensigad.model.dao;

import java.util.ArrayList;

import es.opensigad.model.vo.AlumnoEvaluacionVO;


public interface AlumnoEvaluacionInterfaz{
	
	 public abstract  ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado() ;
	 public void InsertarEvaluacionesVO();
	 public abstract void EditarEvaluacionesVO();
	 public abstract void EliminarEvaluacionesVO();
	 
}
