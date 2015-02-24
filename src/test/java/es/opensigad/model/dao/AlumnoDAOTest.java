package es.opensigad.model.dao;

import junit.framework.TestCase;
import es.opensigad.model.vo.Alumno;

public class AlumnoDAOTest extends TestCase {

	AlumnoDAOPoolDB alumnoDAO = new AlumnoDAOPoolDB();

	/*public void testGetListAlumno() {

		List<Alumno> alumnos = alumnoDAO.getListAlumno();

		assertTrue(alumnos.size() > 0);

	}
*/
	public void testGetDetalleAlumno() {

		Alumno alumno = alumnoDAO.getDetalleAlumno(1);

		assertTrue(alumno != null);
	}

	public void testInsertAlumno() {
		java.util.Date utilDate = new java.util.Date();
		boolean alum;
		
		Alumno alumno = new Alumno();
		
		alumno.setId(200);
		alumno.setNumExpediente(200);
		alumno.setNombre("carlos");
		alumno.setApellido1("cano");
		alumno.setApellido2("perez");
		alumno.setFechaNacimiento(utilDate);
		alumno.setTipoDocumento("dni");
		alumno.setDocumento("12345678X");
		alumno.setSexo("h");
		alumno.setImagen("image");
		alumno.setLocalidadNacimiento("tudela");
		
		alum = alumnoDAO.insertAlumno(alumno);

		assertTrue(alum == true);
	}
/*
	public void testDeleteAlumno() {

		int id = 200;

		Alumno alumno = alumnoDAO.getDetalleAlumno(id);

		alumnoDAO.deleteAlumno(id);

		// AlumnoVO alumno = alumnoDAO.getDetalleAlumno(id);

		assertTrue(alumno != null);
	}

	public void testModifyAlumno() {

		int id = 200;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		Alumno alumno1 = alumnoDAO.getDetalleAlumno(id);
		Alumno alumno2 = new Alumno(id, id, "nombre", "apellido1",
				"apellido2", "h", "img", "dni", "12345678X", sqlDate,
				"Tudela", "NA", "ES");

		alumnoDAO.modifyAlumno(alumno2);

		alumno2 = alumnoDAO.getDetalleAlumno(id);

		assertTrue(alumno1.getNombre() != alumno2.getNombre());
	}

	public void testInsertAlumnoContacto() {
		int idContacto = 2000;

		AlumnoContacto alumnoContacto = new AlumnoContacto(idContacto, 10,
				"telefono", "999888777", 0);
		
		assertTrue(alumnoDAO.insertAlumnoContacto(alumnoContacto));
	}

	public void testDeleteAlumnoContacto() {
		int id = 16;
		
		assertTrue(alumnoDAO.deleteAlumnoContacto(id));
	}

	public void testModifyAlumnoContacto() {
		int idContacto = 15;

		java.util.Date utilDate = new java.util.Date();

		// cargo dos objetos. El original y el modificado
		AlumnoContacto alumnoContacto1 = alumnoDAO.getDetalleAlumnoContacto(idContacto);
		AlumnoContacto alumnoContacto2 = new AlumnoContacto(idContacto, 10,
				"telefono", "999888777", 0);

		alumnoDAO.modifyAlumnoContacto(alumnoContacto2);

		alumnoContacto2 = alumnoDAO.getDetalleAlumnoContacto(idContacto);

		assertTrue(alumnoContacto1 != alumnoContacto2);
	}

	public void testGetDetalleAlumnoContacto() {
		
		int idContacto = 15;
		
		AlumnoContacto alumnoContacto = alumnoDAO.getDetalleAlumnoContacto(idContacto);

		assertTrue(alumnoContacto != null);
	}

	public void testGetListAlumnoContacto() {
		
		//sin acabar
		
		List<AlumnoContacto> alumnosContacto = alumnoDAO.getListAlumnoContacto(10);

		assertTrue(alumnosContacto.size() > 0);
	}

	public void testInsertAlumnoDireccion() {
		fail("Not yet implemented");
	}

	public void testDeleteAlumnoDireccion() {
		fail("Not yet implemented");
	}

	public void testModifyAlumnoDireccion() {
		fail("Not yet implemented");
	}

	public void testGetDetalleAlumnoDireccion() {
		fail("Not yet implemented");
	}

	public void testGetListAlumnoDireccion() {
		fail("Not yet implemented");
	}*/

}
