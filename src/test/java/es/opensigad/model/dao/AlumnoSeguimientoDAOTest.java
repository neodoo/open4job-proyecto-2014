package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoSeguimiento;
import junit.framework.TestCase;

public class AlumnoSeguimientoDAOTest extends TestCase {

	public static long idFalta = 0;
	public static long idAlumno = 999999999;

	AlumnoSeguimientoDAOPoolDB alumnoSeguimientoDAO = new AlumnoSeguimientoDAOPoolDB();

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	
	public void test1() {

		// Insertar falta
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento(idAlumno, sqlDate,
				"sesion_" + idAlumno, "materia_" + idAlumno,
				"tipo_" + idAlumno, "justificado_" + idAlumno, "observaciones_"
						+ idAlumno);
		idFalta = alumnoFaltaDAO.actualizarSeguimiento(alumnoFaltaVO);

		assertTrue(idFalta > 0);
	}

	public void test2() {
		// Visualizar una falta
		AlumnoSeguimiento alumnoSeguimiento = alumnoSeguimiento.getDetalleFalta(idFalta);

		assertTrue(alumnoSeguimiento != null);
	}

	public void test3() {
		// Actualizar falta
		AlumnoSeguimiento alumnoSeguimiento = new AlumnoSeguimiento(idFalta, idAlumno,
				sqlDate, "sesion_000", "materia_000", "tipo_000",
				"justificado_000", "observaciones_000");
		alumnoSeguimientoDAO.actualizarSeguimiento(alumnoSeguimiento);

		assertNotNull(alumnoFaltaVO);
	}

	public void test4() {
		// Visualizar faltas por alumno
		List<AlumnoSeguimiento> alumnoFaltasVO = alumnoSeguimientoDAO
				.getListaFaltas(idAlumno);

		assertNotNull(alumnoFaltasVO);
	}

	public void test5() {
		// Eliminar falta
		alumnoSeguimientoDAO.eliminarSeguimiento(idFalta);

		assertTrue(idFalta > 0);
	}

}
