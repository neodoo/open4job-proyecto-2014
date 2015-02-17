package es.opensigad.model.dao;

import java.sql.Date;
import java.util.List;

import es.opensigad.model.vo.AlumnoVO;

public interface AlumnoDAOInterfaz {

	public List<AlumnoVO> getListAlumno();

	public AlumnoVO getDetalleAlumno(int num_expediente);

	public boolean insertAlumno(AlumnoVO alumnoVO);

	public boolean deleteAlumno(int id);
	
	public boolean modifyAlumno(AlumnoVO alumnoVO);

}
