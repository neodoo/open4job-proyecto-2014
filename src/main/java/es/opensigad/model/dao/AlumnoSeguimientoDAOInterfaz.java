package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoFaltaVO;


public interface AlumnoFaltaDAOInterfaz {
/* defines standard operations to be performed on POJO*/
   public abstract List<AlumnoFaltaVO> getListaFaltas(long idAlumno);
   public abstract AlumnoFaltaVO getDetalleFalta(long id);
   public abstract long insertarFalta(AlumnoFaltaVO falta);
   public abstract long actualizarFalta(AlumnoFaltaVO falta);
   public abstract long eliminarFalta(long id);
}