package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoSeguimiento;

public interface AlumnoSeguimientoDAOInterfaz {
	/* defines standard operations to be performed on POJO */
	public abstract List<AlumnoSeguimiento> getListaAlumnoSeguimiento(
			int pidMatricula);

	public abstract AlumnoSeguimiento getDetalleFalta(long pnumId);
	
	public abstract int actualizarAlumnoSeguimiento(
			AlumnoSeguimiento alumnoSeguimiento);

	public abstract int eliminarAlumnoSeguimiento(
			AlumnoSeguimiento alumnoSeguimiento);

}
