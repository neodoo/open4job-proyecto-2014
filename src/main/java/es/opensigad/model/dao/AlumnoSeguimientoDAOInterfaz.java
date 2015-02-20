package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoSeguimiento;


public interface AlumnoSeguimientoDAOInterfaz {
/* defines standard operations to be performed on POJO*/
   public abstract List<AlumnoSeguimiento> getListaAlumnoSeguimiento(int pidMatricula);
   public abstract AlumnoSeguimiento getDetalleAlumnoSeguimiento(int id);
   public abstract int insertarAlumnoSeguimiento(AlumnoSeguimiento seguimiento);
   public abstract int actualizarAlumnoSeguimiento(AlumnoSeguimiento seguimiento);
   public abstract int eliminarAlumnoSeguimiento(int id);
}