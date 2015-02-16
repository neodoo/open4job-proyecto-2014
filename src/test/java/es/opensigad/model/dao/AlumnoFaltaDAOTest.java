package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoFaltaVO;
import junit.framework.TestCase;

public class AlumnoFaltaDAOTest extends TestCase {

	long idFalta = 0;
	long idAlumno = 999;

	AlumnoFaltaDAOPoolDB alumnoFaltaDAO = new AlumnoFaltaDAOPoolDB();

	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	
	
	public void test1() {

		// Insertar falta
		AlumnoFaltaVO alumnoFaltaVO = new AlumnoFaltaVO(idAlumno, sqlDate,
				"sesion_" + idAlumno, "materia_" + idAlumno, "tipo_"+ idAlumno, "justificado_"+ idAlumno,
				"observaciones_"+ idAlumno);
		idFalta = alumnoFaltaDAO.insertarFalta(alumnoFaltaVO);

		assertTrue(idFalta > 0);
	}

	public void test2() {
		// Visualizar una falta
		AlumnoFaltaVO alumnoFaltaVO = alumnoFaltaDAO.getDetalleFalta(idFalta);

		assertTrue(alumnoFaltaVO != null);
	}

	public void test3() {
		// Actualizar falta
		AlumnoFaltaVO alumnoFaltaVO = new AlumnoFaltaVO(idFalta, idAlumno,
				sqlDate, "sesion_000", "materia_000", "tipo_000",
				"justificado_000", "observaciones_000");
		alumnoFaltaDAO.actualizarFalta(alumnoFaltaVO);

		assertNotNull(alumnoFaltaVO);
	}

	public void test4() {
		// Visualizar faltas por alumno
		List<AlumnoFaltaVO> alumnoFaltasVO = alumnoFaltaDAO
				.getListaFaltas(idAlumno);

		assertNotNull(alumnoFaltasVO);
	}

	public void test5() {
		// Eliminar falta
		alumnoFaltaDAO.eliminarFalta(idFalta);

		assertTrue(idFalta > 0);
	}

}
