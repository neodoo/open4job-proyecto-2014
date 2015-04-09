package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import es.opensigad.model.vo.AlumnoSeguimiento;

@RunWith(MockitoJUnitRunner.class)
public class AlumnoSeguimientoMockTest {
	
	@Mock
	AlumnoSeguimientoDAO dao;
	
	public List<String> devolverObservacionesMayusculasTodosAlumnosSeguimiento(int idMatricula) {
		
		List<AlumnoSeguimiento> segs = dao.getListaAlumnoSeguimiento(idMatricula);
		List<String> obs = new ArrayList<String>();
		
		for (AlumnoSeguimiento alumnoSeguimiento : segs) {
			obs.add(alumnoSeguimiento.getObservaciones().toUpperCase());
		}
		return obs;
	}
	
	
	
	@Test
	public void testGetAlumnoSeguimientoLisT() {
		int idMatricula = 1;
		
		AlumnoSeguimiento alumno = new AlumnoSeguimiento();
		alumno.setId(1);
		alumno.setObservaciones("alumno 1");
		alumno.setFecha(new Date());
		
		AlumnoSeguimiento alumno2 = new AlumnoSeguimiento();
		alumno2.setId(1);
		alumno2.setObservaciones("alumno 2");
		alumno2.setFecha(new Date());
		
		
		List<AlumnoSeguimiento> listatest = new ArrayList<AlumnoSeguimiento>();
		listatest.add(alumno);
		listatest.add(alumno2);
		when(dao.getListaAlumnoSeguimiento(idMatricula)).thenReturn(listatest);
		
		
		
		//et
	
		List<String> obs = devolverObservacionesMayusculasTodosAlumnosSeguimiento(3);
	
		assertNotNull(obs);
		assertEquals(2, obs.size());
		assertEquals("ALUMNO 1", obs.get(0));
		assertEquals("ALUMNO 2", obs.get(1));
		
		
		
		//assertEquals(alumno, alumnosSeguimiento.get(0));
		
	}

}
