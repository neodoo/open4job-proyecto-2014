package es.opensigad.model.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.Territorio;

public class AlumnoDAOTest extends JPABaseTest {

	AlumnoDAOPoolDB alumnoDAO;
	Territorio pais;
	Territorio provincia;
	
	@Before
	public void setUp() {
		alumnoDAO = new AlumnoDAOPoolDB();
		alumnoDAO.setEntityManager(super.getEm());
	}
		
	@Before
	public void prepareData() {
		beginTransaction();
		pais = prepareTerritorio("EN", "England");
		provincia = prepareTerritorio("EN001", "London");
		commitTransaction();
	}

	@After
	public void tearDown() {
		//XXX: otra opción sería mover los deletes a setUp, 
		//lo que nos permitiría evaluar el estado de la base de datos después de un test fallido 
		beginTransaction();
		em.createQuery("delete from Territorio").executeUpdate();
		em.createQuery("delete from Alumno").executeUpdate();
		commitTransaction();
	}

	@Test
	public void testInsertGetListAlumno() {
		beginTransaction();
				
		Alumno alumno = new Alumno();
		alumno.setApellido1("Doe");
		alumno.setApellido2("Doe");
		alumno.setNombre("John");
		alumno.setDocumento("11111111N");
		alumno.setImagen("myimg.png");
		alumno.setSexo("m");
		alumno.setNumExpediente(10012);
		alumno.setTipoDocumento("nif");
		alumno.setTerritorio1(pais);
		alumno.setTerritorio2(provincia);

		alumnoDAO.insertAlumno(alumno);
		List<Alumno> alumnos = alumnoDAO.getListAlumno();
		assertTrue(alumnos.size() > 0);
		
		commitTransaction();
	}
	
	
	private Territorio prepareTerritorio(String codigo, String descripcion) {
		Territorio england = new Territorio();
		england.setCodigo(codigo);
		england.setDescripcion(descripcion);
		em.merge(england);
		return england;
	}
	
}