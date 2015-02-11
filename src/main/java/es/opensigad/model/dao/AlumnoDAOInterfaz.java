package es.opensigad.model.dao;

import java.util.List;

import es.opensigad.model.vo.AlumnoVO;

public interface AlumnoDAOInterfaz {

	public List<AlumnoVO> getListAlumno();

	public AlumnoVO getDetalleAlumno(int idAlumno);

}
