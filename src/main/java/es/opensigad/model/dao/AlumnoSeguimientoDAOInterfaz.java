package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoSeguimiento;

public interface AlumnoSeguimientoDAOInterfaz {

	public abstract List<AlumnoSeguimiento> getListaAlumnoSeguimiento(
			int pidMatricula);

	/* defines standard operations to be performed on POJO */
	public abstract int actualizarAlumnoSeguimiento(
			AlumnoSeguimiento alumnoSeguimiento);

	public abstract int eliminarAlumnoSeguimiento(
			AlumnoSeguimiento alumnoSeguimiento);

	public AlumnoSeguimiento getDetalleFalta(long pnumId);

}
