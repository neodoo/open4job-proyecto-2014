package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoFaltaVO;
import junit.framework.TestCase;

public class AlumnoFaltaDAOTest extends TestCase {
	public void testGetListAlumnoFalta() {
		
		int idAlumno =1;
		
		AlumnoFaltaDAOPoolDB alumnoFaltaDAO = new AlumnoFaltaDAOPoolDB();
		
		List <AlumnoFaltaVO> alumnoFaltas = alumnoFaltaDAO.getListaFaltas(idAlumno);
		
		assertTrue (alumnoFaltas.size() > 0);
			
		
		int idFalta =1;
		
		AlumnoFaltaVO alumnoFalta = alumnoFaltaDAO.getDetalleFalta(idFalta);
		
		assertNotNull (alumnoFalta);


	}
}
