package es.opensigad.model.dao;

import java.util.ArrayList;

import es.opensigad.model.vo.AlumnoMatriculaVO;
import junit.framework.TestCase;

public class AlumnoMatriculaDAOTest extends TestCase {
	
	AlumnoMatriculaDAOPoolDB alumnoMatriculaDAO = new AlumnoMatriculaDAOPoolDB();

	public void testInsertarMatricula() {
		
		int id=500;
		int curso_escolar=2014;
		int curso=1;
	
		boolean matricula = alumnoMatriculaDAO.insertarMatricula(id,curso_escolar,"centro","ensenanza","modulo",curso);

		assertTrue(matricula != false);
		
	}
	
	public void testModificarMatricula() {
		
		int id=500;
		int curso_escolar=2014;
		int curso=1;
		
		AlumnoMatriculaVO matricula1 = alumnoMatriculaDAO.getListaFichaMatricula(id);
		
	    alumnoMatriculaDAO.modificarMatricula(2,curso_escolar,"centross","ensenanza","modulo",curso, id);
	    
	    AlumnoMatriculaVO matricula2 = alumnoMatriculaDAO.getListaFichaMatricula(id);
	    
	    assertTrue(matricula1.getCentro() != matricula2.getCentro());
		
		
		
	}

	public void testBorrarMatricula() {
		
		int id=90;
		
		boolean matricula = alumnoMatriculaDAO.borrarMatricula(id);
		
		
		assertTrue(matricula != true);
	
	}

	

	public void testGetListadoMatricula() {
		
		ArrayList<AlumnoMatriculaVO> matricula = alumnoMatriculaDAO.getListadoMatricula(2);

		assertTrue(matricula.size() > 0);
	}
	
	public void getListaFichaMatricula() {

		AlumnoMatriculaVO matricula = alumnoMatriculaDAO.getListaFichaMatricula(2);

		assertTrue(matricula != null);
	}

}
