package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoFaltaVO;


public interface AlumnoFaltaDAOInterfaz {
/* defines standard operations to be performed on POJO*/
   public abstract List<AlumnoFaltaVO> getListaFaltas(int idAlumno);
   public abstract AlumnoFaltaVO getDetalleFalta(int id);
   public abstract boolean insertarFalta(AlumnoFaltaVO falta);
   public abstract boolean actualizarFalta(AlumnoFaltaVO falta);
   public abstract boolean eliminarFalta(int id);
}