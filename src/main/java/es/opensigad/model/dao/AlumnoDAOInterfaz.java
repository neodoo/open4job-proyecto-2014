package es.opensigad.model.dao;

import java.sql.Date;
import java.util.List;

import es.opensigad.model.vo.AlumnoVO;

public interface AlumnoDAOInterfaz {

	public List<AlumnoVO> getListAlumno();

	public AlumnoVO getDetalleAlumno(int num_expediente);

	public boolean insertAlumno(AlumnoVO alumnoVO);

	public boolean deleteAlumno(int id);
	
	public boolean modifyAlumno(int idAlumno, int numExpediente, String nombre,
			String apellido1, String apellido2, String sexo, String dni,
			String telefono, Date fecha_nacimiento, String pais,
			String provincia, String localidad, String domicilio, String email);

}
