package es.opensigad.model.dao;

import java.util.List;

import junit.framework.TestCase;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.AlumnoDireccion;
import es.opensigad.model.vo.Territorio;

public class AlumnoDAOTest extends TestCase {

	AlumnoDAOPoolDB alumnoDAO = new AlumnoDAOPoolDB();

	/*
	 * public void testGetListAlumno() {
	 * 
	 * List<Alumno> alumnos = alumnoDAO.getListAlumno();
	 * 
	 * assertTrue(alumnos.size() > 0);
	 * 
	 * }
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
		// Alumno alumno = alumnoDAO.getDetalleAlumno(200);
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

		// hay que pasarle el id_alumno. Pase el que pase, se cambiará en el
		// contacto.
		alumno.setId(1);

		// id del contacto que deseamos modificar
		alumnoContacto.setId(3);
		alumnoContacto.setAlumno(alumno);
		alumnoContacto.setTipo("telefono");
		alumnoContacto.setContacto("999888777");
		alumnoContacto.setPrincipal(1);

		assertTrue(alumnoDAO.modifyAlumnoContacto(alumnoContacto));

	}

	public void testGetDetalleAlumnoContacto() {

		int idContacto = 3;

		AlumnoContacto alumnoContacto = alumnoDAO
				.getDetalleAlumnoContacto(idContacto);

		assertTrue(alumnoContacto != null);
	}

	public void testGetListAlumnoContacto() {

		int idAlumno = 1;

		List<AlumnoContacto> alumnosContacto = alumnoDAO
				.getListAlumnoContacto(idAlumno);

		assertTrue(alumnosContacto.size() > 0);
	}

	public void testInsertAlumnoDireccion() {

		AlumnoDireccion alumnoDireccion = new AlumnoDireccion();

		Alumno alumno = new Alumno();
		alumno.setId(1);

		Territorio provincia = new Territorio();
		provincia.setCodigo("BE1");
		Territorio pais = new Territorio();
		pais.setCodigo("BE");

		alumnoDireccion.setAlumno(alumno);
		alumnoDireccion.setDomicilio("calle loroo");
		alumnoDireccion.setCodigoPostal(50005);
		alumnoDireccion.setLocalidad("zgz");
		alumnoDireccion.setTerritorio1(provincia);
		alumnoDireccion.setTerritorio2(pais);
		alumnoDireccion.setPrincipal(0);

		assertTrue(alumnoDAO.insertAlumnoDireccion(alumnoDireccion));
	}

	public void testDeleteAlumnoDireccion() {

		assertTrue(alumnoDAO.deleteAlumnoDireccion(4));
	}

	public void testModifyAlumnoDireccion() {

		AlumnoDireccion alumnoDireccion = new AlumnoDireccion();

		Alumno alumno = new Alumno();

		// id del alumno al que va a pertenecer esta dirección.
		// si no es el original se cambiará.
		alumno.setId(1);

		Territorio provincia = new Territorio();
		provincia.setCodigo("BE1");
		Territorio pais = new Territorio();
		pais.setCodigo("BE");

		alumnoDireccion.setId(3); // id de la dirección a modificar
		alumnoDireccion.setAlumno(alumno);
		alumnoDireccion.setDomicilio("calle tiririi");
		alumnoDireccion.setCodigoPostal(50005);
		alumnoDireccion.setLocalidad("localidad");
		alumnoDireccion.setTerritorio1(provincia);
		alumnoDireccion.setTerritorio2(pais);
		alumnoDireccion.setPrincipal(0);

		assertTrue(alumnoDAO.modifyAlumnoDireccion(alumnoDireccion));
	}

	public void testGetDetalleAlumnoDireccion() {
		
		int idDireccion = 3;

		AlumnoDireccion alumnoDireccion = alumnoDAO
				.getDetalleAlumnoDireccion(idDireccion);

		assertTrue(alumnoDireccion != null);
	}

	public void testGetListAlumnoDireccion() {
		
		int idAlumno = 1;

		List<AlumnoDireccion> alumnosDireccion = alumnoDAO
				.getListAlumnoDireccion(idAlumno);

		assertTrue(alumnosDireccion.size() > 0);
	}

}
