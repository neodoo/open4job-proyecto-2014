package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoMatricula;

public interface AlumnoMatriculaDAOInterfaz {

	public boolean insertarMatricula(int idAlumno, int cursoEscolar, int centro, int ensenanza, String modulo, int curso);

	public boolean modificarMatricula(int idAlumno, int cursoEscolar, int centro, int ensenanza, String modulo, int curso, int idMatricula);

	public boolean borrarMatricula(int idMatricula);

	public List<AlumnoMatricula> getListadoMatricula(int idAlumno);

	public AlumnoMatricula getListaFichaMatricula(int idMatricula);

}
