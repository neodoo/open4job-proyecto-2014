package es.opensigad.model.dao;

import junit.framework.TestCase;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoContacto;

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
		
		alumno.setId(300);
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

	public void testDeleteAlumno() {

		int id = 6;
		assertTrue(alumnoDAO.deleteAlumno(id));
	}

	public void testModifyAlumno() {

		java.util.Date utilDate = new java.util.Date();
		//Alumno alumno = alumnoDAO.getDetalleAlumno(200);
		Alumno alumno = new Alumno();
		
		alumno.setId(10);
		alumno.setNumExpediente(10);
		alumno.setNombre("carlitos");
		alumno.setApellido1("cano");
		alumno.setApellido2("perez");
		alumno.setFechaNacimiento(utilDate);
		alumno.setTipoDocumento("dni");
		alumno.setDocumento("12345678X");
		alumno.setSexo("h");
		alumno.setImagen("image");
		alumno.setLocalidadNacimiento("tudela");
		
		alumnoDAO.modifyAlumno(alumno);

		assertTrue(alumnoDAO.modifyAlumno(alumno));
	}

	public void testInsertAlumnoContacto() {
		
		AlumnoContacto alumnoContacto = new AlumnoContacto();
		Alumno alumno = new Alumno();
		alumno.setId(1);
		alumnoContacto.setAlumno(alumno);
		alumnoContacto.setTipo("email");
		alumnoContacto.setContacto("hola@open4job.com");
		alumnoContacto.setPrincipal(0);
		
		assertTrue(alumnoDAO.insertAlumnoContacto(alumnoContacto));
	}

	public void testDeleteAlumnoContacto() {
		
		assertTrue(alumnoDAO.deleteAlumnoContacto(2));
	}

	public void testModifyAlumnoContacto() {
		
		AlumnoContacto alumnoContacto = new AlumnoContacto();
		Alumno alumno = new Alumno();
		
		//hay que pasarle el id_alumno. Pase el que pase, se cambiará en el contacto.
		alumno.setId(1);
		
		//id del contacto que deseamos modificar
		alumnoContacto.setId(3);
		alumnoContacto.setAlumno(alumno);
		alumnoContacto.setTipo("telefono");
		alumnoContacto.setContacto("999888777");
		alumnoContacto.setPrincipal(1);
		
		assertTrue(alumnoDAO.modifyAlumnoContacto(alumnoContacto));
		
	}
/*
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
