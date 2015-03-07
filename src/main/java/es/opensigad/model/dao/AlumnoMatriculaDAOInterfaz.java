package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.Centro;

@Local
public interface AlumnoMatriculaDAOInterfaz {

	public boolean insertarMatricula(int idAlumno, int cursoEscolar, int centro, int ensenanza, String modulo, int curso);

	public boolean modificarMatricula(int idAlumno, int cursoEscolar, int centro, int ensenanza, String modulo, int curso, int idMatricula);

	public boolean borrarMatricula(int idMatricula);

	public List<AlumnoMatricula> getListadoMatricula(int idAlumno);

	public AlumnoMatricula getListaFichaMatricula(int idMatricula);
	
	public ArrayList<Centro> getCentroList();

	public ArrayList<Alumno> getAlumnoList();
}
