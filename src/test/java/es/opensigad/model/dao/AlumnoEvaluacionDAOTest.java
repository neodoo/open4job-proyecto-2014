package es.opensigad.model.dao;

import java.util.ArrayList;
import es.opensigad.model.vo.AlumnoEvaluacionVO;
import junit.framework.TestCase;

public class AlumnoEvaluacionDAOTest extends TestCase {
	AlumnoEvaluacionDaoPoolDB evaluacionDAO = new AlumnoEvaluacionDaoPoolDB();

	public void testgetAlumnoEvaluacionListado() {
		ArrayList<AlumnoEvaluacionVO> evaluaciones = evaluacionDAO
				.getAlumnoEvaluacionListado();
		assertTrue(evaluaciones.size() > 0);
		

	}

	public void testgetDetalleEvaluacion() {
		
		ArrayList<AlumnoEvaluacionVO> evaluacion = evaluacionDAO
				.getDetalleEvaluacion(2);
		
		assertTrue(evaluacion.size()>0);

	}

	public void testinsertarEvaluacionAlumno() {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		boolean funciona = evaluacionDAO.insertarEvaluacionAlumno(1, 1, 3,
				sqlDate, sqlDate, sqlDate, sqlDate);
		assertTrue(funciona == true);
		

	}

	public void testEliminarEvaluacionAlumno() {
		
		boolean estado=evaluacionDAO.EliminarEvaluacionAlumno(1);

		assertTrue(estado);
	}
}
