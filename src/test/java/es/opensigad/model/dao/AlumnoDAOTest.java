package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoVO;
import junit.framework.TestCase;

public class AlumnoDAOTest extends TestCase {

	public void testGetListAlumno() {
		
		AlumnoDAOPoolDB alumnoDAO = new AlumnoDAOPoolDB();
		
		List <AlumnoVO> alumnos = alumnoDAO.getListAlumno();
		
		assertTrue (alumnos.size() > 0);
			
	}

}
