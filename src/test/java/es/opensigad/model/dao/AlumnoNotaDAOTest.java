package es.opensigad.model.dao;

import junit.framework.TestCase;

import java.util.ArrayList;

import es.opensigad.controller.VerAlumnoNotaListadoBean;
import es.opensigad.model.vo.AlumnoNota;


public class AlumnoNotaDAOTest extends TestCase {

	public void testGetNotasByIdMatricula() {
		AlumnoNotaDaoPoolDB alumnoDao = new  AlumnoNotaDaoPoolDB();
		ArrayList <AlumnoNota> alumnoNotas = alumnoDao.getNotasByIdMatricula(1);
		assertTrue(alumnoNotas.size()>0);
	}

	public void testInsertarBorrarNotasAlumnoByIdMatricula() {
		AlumnoNotaDaoPoolDB alumnoDao = new AlumnoNotaDaoPoolDB();
		boolean estado = alumnoDao.insertarNotasAlumnoByIdMatricula(99, 99, 99, 3, 9);
		assertTrue(estado);
		estado = alumnoDao.borrarNotaByIdMatricula(99);
		assertTrue(estado);
	}

	public void testActualizarNotaByIdMatricula() {
		AlumnoNotaDaoPoolDB alumnoDao = new AlumnoNotaDaoPoolDB();
		boolean estado = alumnoDao.actualizarNotaByIdMatricula(99, 99, 99, 99, 2);
		assertTrue(estado);
	}

}
