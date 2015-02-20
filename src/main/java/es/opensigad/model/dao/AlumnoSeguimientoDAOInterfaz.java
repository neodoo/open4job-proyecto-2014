package es.opensigad.model.dao;

import es.opensigad.model.vo.AlumnoSeguimiento;

public interface AlumnoSeguimientoDAOInterfaz {
/* defines standard operations to be performed on POJO*/
   public abstract int actualizarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento);
   public abstract int eliminarAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento);
}