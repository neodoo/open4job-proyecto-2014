package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoTutor;
import junit.framework.TestCase;

public class TutorDAOTest extends TestCase {
	
	public void testGetListaTutor() 
	{
		TutorDAOPoolDB tutorDAO = new TutorDAOPoolDB();
		int idAlumno= 1;
		List <AlumnoTutor> tutores = tutorDAO.getlistaTutor(idAlumno);
		assertTrue (tutores.size() > 0);
	}
}
