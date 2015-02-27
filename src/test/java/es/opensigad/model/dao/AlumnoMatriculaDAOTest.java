package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoMatricula;

import junit.framework.TestCase;

public class AlumnoMatriculaDAOTest extends TestCase {
	
	AlumnoMatriculaDAOPoolDB alumnoMatriculaDAO = new AlumnoMatriculaDAOPoolDB();

	public void testInsertarMatricula() {
	
		
		boolean matricula = alumnoMatriculaDAO.insertarMatricula(2,2015,1,1,"modulo",1);

		assertTrue(matricula != false);
		
	}
	
	public void testModificarMatricula() {
		
		boolean matricula = alumnoMatriculaDAO.modificarMatricula(10,2015,1,1,"prueba",1,4);

		assertTrue(matricula != false);
		
		/*
		int id=500;
		int curso_escolar=2014;
		int curso=1;
		
		AlumnoMatriculaVO matricula1 = alumnoMatriculaDAO.getListaFichaMatricula(id);
		
		alumnoMatriculaDAO.modificarMatricula(2,curso_escolar,"centross","ensenanza","modulo",curso, id);
	    
		AlumnoMatriculaVO matricula2 = alumnoMatriculaDAO.getListaFichaMatricula(id);
	    
		assertTrue(matricula1.getCentro() != matricula2.getCentro());*/
		
	}

	public void testBorrarMatricula() {
		
		int id=45;
		
		boolean matricula = alumnoMatriculaDAO.borrarMatricula(id);
		
		
		assertTrue(matricula != false);
	
	}

	

	public void testGetListadoMatricula() {
		
		List<AlumnoMatricula> matricula = alumnoMatriculaDAO.getListadoMatricula(2);

		assertTrue(matricula.size() > 0);
	}
	
	public void testGetListaFichaMatricula() {

		AlumnoMatricula matricula = alumnoMatriculaDAO.getListaFichaMatricula(3);

		assertTrue(matricula != null);
	}

}
