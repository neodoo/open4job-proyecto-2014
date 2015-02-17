package es.opensigad.model.dao;

import java.util.List;

import junit.framework.TestCase;
import es.opensigad.model.vo.AlumnoVO;

public class AlumnoDAOTest extends TestCase {

	AlumnoDAOPoolDB alumnoDAO = new AlumnoDAOPoolDB();

	public void testGetListAlumno() {

		List<AlumnoVO> alumnos = alumnoDAO.getListAlumno();

		assertTrue(alumnos.size() > 0);

	}

	public void testGetDetalleAlumno() {

		AlumnoVO alumno = alumnoDAO.getDetalleAlumno(1);

		assertTrue(alumno != null);
	}

	public void testInsertAlumno() {
		int id = 200;
		java.util.Date utilDate = new java.util.Date();
		
		AlumnoVO alumno = new AlumnoVO(id, id, "nom", "ape", "ape", "h", "dni" + id,
				"tfno", utilDate, "pais", "prov", "loc", "dom", "email");
		
		alumnoDAO.insertAlumno(alumno);

		alumno = alumnoDAO.getDetalleAlumno(id);

		alumno.toString();
		assertTrue(alumno != null);
	}

	public void testDeleteAlumno() {

		int id = 100;

		AlumnoVO alumno = alumnoDAO.getDetalleAlumno(id);
		
		alumnoDAO.deleteAlumno(id);

		//AlumnoVO alumno = alumnoDAO.getDetalleAlumno(id);

		assertTrue(alumno != null);
	}

	public void testModifyAlumno() {

		int id = 200;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		AlumnoVO alumno1 = alumnoDAO.getDetalleAlumno(id);
		AlumnoVO alumno2 = new AlumnoVO(id, id, "nom" + id, "ape", "ape", "h", "dni"
				+ id, "tfno", sqlDate, "pais", "prov", "loc", "dom", "email");

		alumnoDAO.modifyAlumno(alumno2);

		alumno2 = alumnoDAO.getDetalleAlumno(id);

		assertTrue(alumno1.getNombre() != alumno2.getNombre());
	}

}
