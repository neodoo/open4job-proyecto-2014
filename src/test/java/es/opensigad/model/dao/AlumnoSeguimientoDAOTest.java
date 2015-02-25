package es.opensigad.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoSeguimiento;
import es.opensigad.model.vo.EnsenanzaMateria;
import junit.framework.TestCase;

public class AlumnoSeguimientoDAOTest extends TestCase {

	public static int idSeguimiento = 0;
	public static int idMatricula = 6;
	public static int idEnsenanza = 1;

	AlumnoSeguimientoDAOPoolDB alumnoSeguimientoDAO = new AlumnoSeguimientoDAOPoolDB();

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	public void test1() {
		// Alumno-Seguimiento
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();

		// Alumno-Matricula
		AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
		alumnoMatricula.setId(idMatricula);
		alumnoSeguimiento.setAlumnoMatricula(alumnoMatricula);
		
		// Enseñanza-Materia
		EnsenanzaMateria ensenanzaMateria = new EnsenanzaMateria();		
		ensenanzaMateria.setId(idEnsenanza);
		alumnoSeguimiento.setEnsenanzaMateria(ensenanzaMateria);
	
		Date fechaSql = null;
		try {
			fechaSql = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1901");
		} catch (ParseException e) {
			e.printStackTrace();
		}				
		//falta.setFecha(new Date());
		alumnoSeguimiento.setFecha(fechaSql);

		alumnoSeguimiento.setSesion("sesion_I_TEST");
		alumnoSeguimiento.setTipo("incidencia");
		
		alumnoSeguimiento.setJustificante(0);
		alumnoSeguimiento.setObservaciones("observaciones_I_TEST");		
		
		idSeguimiento = alumnoSeguimientoDAO.insertarAlumnoSeguimiento(alumnoSeguimiento);
		
		assertTrue(idSeguimiento > 0);
	}

	public void test2() {
		// Visualizar una falta
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();
		alumnoSeguimiento = alumnoSeguimientoDAO.getDetalleAlumnoSeguimiento(idSeguimiento);
		
		// Actualizar Alumno-Seguimiento			
		Date fechaSql = null;
		try {
			fechaSql = new SimpleDateFormat("dd/MM/yyyy").parse("02/02/1902");
		} catch (ParseException e) {
			e.printStackTrace();
		}				
		//falta.setFecha(new Date());
		alumnoSeguimiento.setFecha(fechaSql);

		alumnoSeguimiento.setSesion("sesion_U_TEST");
		alumnoSeguimiento.setTipo("falta");
		alumnoSeguimiento.setObservaciones("observaciones_U_TEST");		
		
		boolean estado = alumnoSeguimientoDAO.actualizarAlumnoSeguimiento(alumnoSeguimiento);		
		
		assertTrue(estado);
	}

	public void test3() {
		// Visualizar faltas por matricula
		List<AlumnoSeguimiento> alumnoSeguimiento = alumnoSeguimientoDAO.getListaAlumnoSeguimiento(idMatricula);
		
		assertNotNull(alumnoSeguimiento);
	}

	public void test4() {		
		
		// Eliminar Seguimiento
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();
		alumnoSeguimiento.setId(idSeguimiento);

		boolean estado = alumnoSeguimientoDAO.eliminarAlumnoSeguimiento(alumnoSeguimiento);

		assertTrue(estado);
	}

}
