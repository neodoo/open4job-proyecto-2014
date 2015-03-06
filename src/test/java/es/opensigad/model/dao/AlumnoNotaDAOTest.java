package es.opensigad.model.dao;

import java.util.List;

import junit.framework.TestCase;
import es.opensigad.model.vo.AlumnoNota;

public class AlumnoNotaDAOTest extends TestCase {

	public void testGetNotasByIdMatricula() {
		
		AlumnoNotaDaoPoolDB alumnoDao = new AlumnoNotaDaoPoolDB();
		List<AlumnoNota> alumnoNotas = alumnoDao.getNotasByIdMatricula(1);
	
		assertTrue(alumnoNotas.size() > 0);
	
	}

	/*
	 public void testInsertarBorrarNotasAlumnoByIdMatricula() {
	 
	 	AlumnoNotaDaoPoolDB alumnoDao = new AlumnoNotaDaoPoolDB(); 
	 	boolean estado = alumnoDao.insertarNotasAlumnoByIdMatricula(99, 99, 99, 3, 9);
	 
	 	assertTrue(estado); 
	 	estado = alumnoDao.borrarNotaByIdMatricula(99);
	 	
	 	assertTrue(estado); 
	 	
	 }
	 */
	
	public void testActualizarNotaByIdMatricula() {
		
		AlumnoNotaDaoPoolDB alumnoDao = new AlumnoNotaDaoPoolDB();
		// boolean estado = alumnoDao.actualizarNotaByIdMatricula(99, 99, 99,
		// 99,"2","2");
	
		// assertTrue(estado);
	
	}

}
