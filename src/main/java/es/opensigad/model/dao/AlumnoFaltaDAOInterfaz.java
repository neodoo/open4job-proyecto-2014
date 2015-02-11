package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoFaltaVO;


public interface AlumnoFaltaDAOInterfaz {
/* defines standard operations to be performed on POJO*/
   public abstract List<AlumnoFaltaVO> getListFaltasAlumno(int idAlumno);
   public abstract AlumnoFaltaVO getDetalleFalta(int id);
   public abstract void actualizarFalta(AlumnoFaltaVO falta);
   public abstract void borrarFalta(int id);
}