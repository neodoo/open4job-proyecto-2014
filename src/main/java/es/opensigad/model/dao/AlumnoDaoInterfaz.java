package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoVO;

public interface AlumnoDaoInterfaz {

	public List<AlumnoVO> getListAlumno();
	public AlumnoVO getDetalleAlumno(int num_expediente);
}
