package es.opensigad.model.dao;

import java.util.List;

import javax.ejb.Local;

import es.opensigad.model.vo.AlumnoNota;

@Local
public interface AlumnoNotaDAOInterfaz {

	public List<AlumnoNota> getNotasByIdMatricula(int id);

	public boolean insertarNotasAlumnoByIdMatricula(int idMateria,
			int idAlumnoMatricula, String evaluacion, String nota,
			String observacion);

	public boolean actualizarNotaByIdMatricula(int id, int idAlumnoMatricula,
			int idMateria, String evaluacion, String nota, String observacion);

	public boolean borrarNotaById(int id);
	public List<AlumnoNota> getDetalleNotasByIdMatricula(int idMatricula, int idFila);
}