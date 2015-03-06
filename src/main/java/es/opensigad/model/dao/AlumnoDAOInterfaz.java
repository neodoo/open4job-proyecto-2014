package es.opensigad.model.dao;

import java.util.List;

import javax.ejb.Remote;

import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.AlumnoDireccion;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.Territorio;

@Remote
public interface AlumnoDAOInterfaz {

	public List<Alumno> getListAlumno();

	public Alumno getDetalleAlumno(int num_expediente);

	public boolean insertAlumno(Alumno alumno);

	public boolean deleteAlumno(int id);
	
	public boolean modifyAlumno(Alumno alumno);
	
	
	public boolean insertAlumnoContacto(AlumnoContacto alumnoContacto);
	
	public boolean deleteAlumnoContacto(int id);
	
	public boolean modifyAlumnoContacto(AlumnoContacto alumnoContacto);
	
	public AlumnoContacto getDetalleAlumnoContacto(int id);
	
	public List<AlumnoContacto> getListAlumnoContacto(int idAlumno);
	
	public boolean insertAlumnoDireccion(AlumnoDireccion alumnoDireccion);
	
	public boolean deleteAlumnoDireccion(int id);
	
	public boolean modifyAlumnoDireccion(AlumnoDireccion alumnoDireccion);
	
	public AlumnoDireccion getDetalleAlumnoDireccion(int id);
	
	public List<AlumnoDireccion> getListAlumnoDireccion(int idAlumno);
	
	public List<Territorio> getListPais();
	
	public List<Territorio> getListProvincia();
}
