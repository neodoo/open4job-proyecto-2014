package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoNota;

public interface AlumnoNotaDAOInterfaz {
	
	public List<AlumnoNota> getAllAlumnoNotas();

	public List<AlumnoNota> getNotasByIdMatricula(int idMatricula);

	public boolean insertarNotasAlumnoByIdMatricula(int idAlumnoMatricula, int idMateria, String evaluacion, String nota, String observacion);

	public boolean actualizarNotaByIdMatricula(int idAlumnoMatricula, int idMateria, String evaluacion, String nota, String observacion);

	public boolean borrarNotaByIdMatricula(int idMatricula);

}
