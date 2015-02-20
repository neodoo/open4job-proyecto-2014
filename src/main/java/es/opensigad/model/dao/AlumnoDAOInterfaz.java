package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.opensigad.model.vo.AlumnoEvaluacionVO;

public interface AlumnoDAOInterfaz {

	public abstract ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado();

	public ArrayList<AlumnoEvaluacionVO> getDetalleEvaluacion(int id);

	public boolean actualizarEvaluacionAlumno(int id,
			int idCentroEstudio, int numero, String descripcion, Date fechaInicio,
			Date fechaFin, Date fechaSesion, Date fechaPublicacion);

	public boolean EliminarEvaluacionAlumno(int id);
}
