package es.opensigad.model.dao;

import java.io.IOException;
import java.util.List;

import org.dbunit.dataset.DataSetException;
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
	public void prepareData() throws DataSetException, IOException {
		beginTransaction();
		loadDataSet("/territorios.xml");
		commitTransaction();
		pais = getTerritorio("EN");
		provincia = getTerritorio("EN001");
	}

	@After
	public void tearDown() {
		//XXX: otra opción sería mover los deletes a setUp, 
		//lo que nos permitiría evaluar el estado de la base de datos después de un test fallido 
		beginTransaction();
		em.createQuery("delete from Alumno").executeUpdate();
		em.createQuery("delete from Territorio").executeUpdate();
		commitTransaction();
	}

	@Test
	public void testInsertGetListAlumno() {
		beginTransaction();
				
		//TODO: usar un dataset con alumnos en lugar de insertar, 
		//y crear otro test que compruebe a parte la inserción.
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
	
	
	private Territorio getTerritorio(String codigo) {
		return em.find(Territorio.class, codigo);
	}
}