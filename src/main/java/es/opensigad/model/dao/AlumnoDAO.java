package es.opensigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.AlumnoDireccion;
import es.opensigad.model.vo.Alumno;

public class AlumnoDAO implements AlumnoDAOInterfaz {

	public static final Logger logger = Logger.getLogger(Alumno.class
			.getName());

	DataSource ds;

	public AlumnoDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<Alumno> getListAlumno() {

		

		return null;
	}

	public Alumno getDetalleAlumno(int numExpediente) {

	
		return null;
	}

	public boolean insertAlumno(Alumno alumno) {



		return false;
	}

	public boolean deleteAlumno(int idAlumno) {
		
		return false;
	}

	public boolean modifyAlumno(Alumno alumno) {
		

		return false;
	}

	public boolean insertAlumnoContacto(AlumnoContacto alumnoContacto) {
		

		return false;
	}

	public boolean deleteAlumnoContacto(int idContacto) {
		
		return false;
	}

	public boolean modifyAlumnoContacto(AlumnoContacto alumnoContacto) {
		

		return false;
	}

	public AlumnoContacto getDetalleAlumnoContacto(int idContacto) {
		

		return null;
	}

	public List<AlumnoContacto> getListAlumnoContacto(int idAlumno) {
		
		return null;
	}

	public boolean insertAlumnoDireccion(AlumnoDireccion alumnoDireccion) {
	

		return false;
	}

	public boolean deleteAlumnoDireccion(int idDireccion) {
		
		return false;
	}

	public boolean modifyAlumnoDireccion(AlumnoDireccion alumnoDireccion) {
		
			
		return false;
	}

	public AlumnoDireccion getDetalleAlumnoDireccion(int idDireccion) {
		

		return null;
	}

	public List<AlumnoDireccion> getListAlumnoDireccion(int idAlumno) {
		
		return null;
	}
}
