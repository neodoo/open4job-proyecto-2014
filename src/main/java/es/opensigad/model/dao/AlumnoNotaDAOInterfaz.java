package es.opensigad.model.dao;

import java.util.ArrayList;

import es.opensigad.model.vo.AlumnoNota;

public interface AlumnoNotaDAOInterfaz {
	public ArrayList<AlumnoNota> getAllAlumnoNotas();

	public ArrayList<AlumnoNota> getNotasByIdMatricula(int idMatricula);

	public boolean insertarNotasAlumnoByIdMatricula(int idAlumnoMatricula,
			int idMateria, String evaluacion, int nota, String observacion);

	public boolean actualizarNotaByIdMatricula(int idAlumnoMatricula,int idMateria, String evaluacion,String nota, String observacion);

	public boolean borrarNotaByIdMatricula(int idMatricula);
}
