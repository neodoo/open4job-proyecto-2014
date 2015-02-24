package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoSeguimiento;

public interface AlumnoSeguimientoDAOInterfaz {

	public List<AlumnoSeguimiento> getListaAlumnoSeguimiento(int pidMatricula);

	public int insertarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento);
	
	public boolean actualizarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento);

	public boolean eliminarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento);

	public AlumnoSeguimiento getDetalleAlumnoSeguimiento(int pnumId);

}
