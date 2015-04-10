package es.opensigad.model.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;

public class AlumnoNotaDAOTest extends JPABaseTest {

	AlumnoNotaDAO alumnoNotaDAO;
	EnsenanzaMateria materia;
	AlumnoMatricula matricula;

	@Before
	public void setUp() {
		alumnoNotaDAO = new AlumnoNotaDAO();
		alumnoNotaDAO.setEntityManager(super.getEm());
	}

	@Before
	public void prepareData() {
		beginTransaction();
		materia = prepareMateria(1);
		matricula = prepareMatricula(1);
		commitTransaction();
	}

	@After
	public void tearDown() {
		beginTransaction();
		em.createQuery("delete from AlumnoNota").executeUpdate();
		commitTransaction();
	}

	@Test
	public void testGetNotasByIdMatricula() {
		beginTransaction();
		
		alumnoNotaDAO.insertarNotasAlumnoByIdMatricula(1, 1,
				"3", "1", "Muy bien");
		
		List<AlumnoNota> alumnoNotas = alumnoNotaDAO.getNotasByIdMatricula(1);
		assertTrue(alumnoNotas.size() > 0);

		commitTransaction();
	}

	@Test
	public void testInsertarNotasAlumnoByIdMatricula() {

		beginTransaction();

		boolean estado = alumnoNotaDAO.insertarNotasAlumnoByIdMatricula(1, 1,
				"3", "10", "observacion");
		assertTrue(estado);

		commitTransaction();

	}

	@Test
	public void testActualizarNotaByIdMatricula() {
		beginTransaction();

		boolean estado = alumnoNotaDAO.actualizarNotaByIdMatricula(1, 1, 1,
				"3", "nota", "observacion");
		assertTrue(estado);

		commitTransaction();

	}

	private EnsenanzaMateria prepareMateria(int id) {
		EnsenanzaMateria materia = new EnsenanzaMateria();
		materia.setId(id);
		em.merge(materia);
		return materia;
	}

	private AlumnoMatricula prepareMatricula(int id) {
		AlumnoMatricula matricula = new AlumnoMatricula();
		matricula.setId(id);
		em.merge(matricula);
		return matricula;
	}

}
