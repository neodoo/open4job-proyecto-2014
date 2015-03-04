package es.opensigad.model.dao;

import java.util.List;

import javax.ejb.Remote;

import es.opensigad.model.vo.AlumnoNota;
@Remote
public interface AlumnoNotaDAOInterfaz {
	
	public List<AlumnoNota> getAllAlumnoNotas();

	public List<AlumnoNota> getNotasByIdAlumno(int id);

	public boolean insertarNotasAlumnoByIdMatricula(int idMateria, int idAlumnoMatricula, String evaluacion, String nota, String observacion);
	
	public boolean actualizarNotaByIdMatricula(int id,int idAlumnoMatricula, int idMateria, String evaluacion, String nota, String observacion);

	public boolean borrarNotaById(int id);

}