package es.opensigad.model.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoSeguimiento;
import junit.framework.TestCase;

public class AlumnoSeguimientoDAOTest extends TestCase {

	public static int idSeguimiento = 0;
	public static int idAlumnoMatricula = 999999999;

	AlumnoSeguimientoDAOPoolDB alumnoSeguimientoDAO = new AlumnoSeguimientoDAOPoolDB();

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	
	public void test1() {

		// Alumno-Matricula
		AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
		alumnoMatricula.setId(idAlumnoMatricula);
		
		// Alumno-Seguimiento
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();
		alumnoSeguimiento.setAlumnoMatricula(alumnoMatricula);
	
		Date fechaSql = null;
		try {
			fechaSql = new SimpleDateFormat("dd/MM/yyy").parse("01/01/1901");
		} catch (ParseException e) {
			e.printStackTrace();
		}				
		//falta.setFecha(new Date());
		alumnoSeguimiento.setFecha(fechaSql);

		alumnoSeguimiento.setSesion("sesion_I_TEST");
		alumnoSeguimiento.setTipo("tipo_I_TEST");
		alumnoSeguimiento.setJustificante(0);
		alumnoSeguimiento.setObservaciones("observaciones_I_TEST");		
		
		idSeguimiento = alumnoSeguimientoDAO.actualizarAlumnoSeguimiento(alumnoSeguimiento);
		
		assertTrue(idSeguimiento > 0);
	}

	public void test2() {
		// Visualizar una falta
		//AlumnoSeguimiento alumnoSeguimiento = alumnoSeguimiento.getDetalleFalta(idFalta);

		//assertTrue(alumnoSeguimiento != null);

	}

	public void test3() {
		// Actualizar Alumno-Seguimiento
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();
	
		Date fechaSql = null;
		try {
			fechaSql = new SimpleDateFormat("dd/MM/yyy").parse("02/02/1902");
		} catch (ParseException e) {
			e.printStackTrace();
		}				
		//falta.setFecha(new Date());
		alumnoSeguimiento.setFecha(fechaSql);

		alumnoSeguimiento.setSesion("sesion_U_TEST");
		alumnoSeguimiento.setTipo("tipo_U_TEST");
		alumnoSeguimiento.setObservaciones("observaciones_U_TEST");		
		
		idSeguimiento = alumnoSeguimientoDAO.actualizarAlumnoSeguimiento(alumnoSeguimiento);		
		
		assertTrue(idSeguimiento > 0);
	}

	public void test4() {
		// Visualizar faltas por alumno
		//List<AlumnoSeguimiento> alumnoFaltasVO = alumnoSeguimientoDAO
		//		.getListaFaltas(idAlumno);

		//assertNotNull(alumnoFaltasVO);
	}

	public void test5() {		
		// Eliminar Seguimiento
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento();
		alumnoSeguimiento.setId(idSeguimiento);

		idSeguimiento = alumnoSeguimientoDAO.eliminarAlumnoSeguimiento(alumnoSeguimiento);

		assertTrue(idSeguimiento > 0);
	}

}
