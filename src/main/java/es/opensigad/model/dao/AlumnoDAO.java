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

import es.opensigad.model.vo.AlumnoVO;

public class AlumnoDAO implements AlumnoDAOInterfaz {

	public static final Logger logger = Logger.getLogger(AlumnoVO.class
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

	/**
	 * Devuelve un listado con todos los alumnos
	 */
	public List<AlumnoVO> getListAlumno() {

		List<AlumnoVO> listAlumno = new ArrayList<AlumnoVO>();
		Connection con = null;
		AlumnoVO alumnoVO = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			new ArrayList<AlumnoVO>();
			con = ds.getConnection();

			alumnoVO = null;
			ps = con.prepareStatement("SELECT * FROM alumno");

			result = ps.executeQuery();

			while (result.next()) {
				alumnoVO = new AlumnoVO(result.getInt("id"),
						result.getInt("num_expediente"),
						result.getString("nombre"),
						result.getString("apellido1"),
						result.getString("apellido2"),
						result.getString("sexo"), result.getString("dni"),
						result.getString("telefono"),
						result.getDate("fecha_nacimiento"),
						result.getString("pais"),
						result.getString("provincia"),
						result.getString("localidad"),
						result.getString("domicilio"),
						result.getString("email"));

				listAlumno.add(alumnoVO);
			}
			return listAlumno;
		} catch (SQLException e) {
			listAlumno = null;
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return null;
	}

	/**
	 * Devuelve un alumno
	 * 
	 * @param numExpediente
	 *            para filtrar el alumno a mostrar
	 */
	public AlumnoVO getDetalleAlumno(int numExpediente) {

		AlumnoVO alumnoVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			new ArrayList<AlumnoVO>();
			con = ds.getConnection();

			ps = con.prepareStatement("SELECT * FROM alumno WHERE num_expediente =?");
			ps.setInt(1, numExpediente);

			result = ps.executeQuery();

			while (result.next()) {
				alumnoVO = new AlumnoVO(result.getInt("id"),
						result.getInt("num_expediente"),
						result.getString("nombre"),
						result.getString("apellido1"),
						result.getString("apellido2"),
						result.getString("sexo"), result.getString("dni"),
						result.getString("telefono"),
						result.getDate("fecha_nacimiento"),
						result.getString("pais"),
						result.getString("provincia"),
						result.getString("localidad"),
						result.getString("domicilio"),
						result.getString("email"));
			}
			return alumnoVO;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return null;
	}

	/**
	 * Inserta un nuevo alumno
	 * 
	 * @param idAlumno
	 * @param numExpediente
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param sexo
	 * @param dni
	 * @param telefono
	 * @param fecha_nacimiento
	 * @param pais
	 * @param provincia
	 * @param localidad
	 * @param domicilio
	 * @param email
	 */
	public boolean insertAlumno(AlumnoVO alumnoVO) {

		Connection con = null;
		PreparedStatement ps = null;
		
		java.util.Date utilDate = alumnoVO.getFechaNacimiento();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		try {
			con = ds.getConnection();

			ps = con.prepareStatement("INSERT INTO alumno VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setInt(2, alumnoVO.getNumExpediente());
			ps.setString(3, alumnoVO.getNombre());
			ps.setString(4, alumnoVO.getApellido1());
			ps.setString(5, alumnoVO.getApellido2());
			ps.setString(6, alumnoVO.getSexo());
			ps.setString(7, alumnoVO.getDni());
			ps.setString(8, alumnoVO.getTelefono());
			ps.setDate(9, sqlDate);
			ps.setString(10, alumnoVO.getPais());
			ps.setString(11, alumnoVO.getLocalidad());
			ps.setString(12, alumnoVO.getProvincia());
			ps.setString(13, alumnoVO.getDomicilio());
			ps.setString(14, alumnoVO.getEmail());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;
	}

	/**
	 * Borra un alumno
	 * 
	 * @param idAlumno
	 */
	public boolean deleteAlumno(int idAlumno) {
		Connection con = null;
		PreparedStatement ps = null;
		int numFila;
		try {
			con = ds.getConnection();

			ps = con.prepareStatement("DELETE FROM alumno WHERE id = ?");
			ps.setInt(1, idAlumno);

			numFila = ps.executeUpdate();

			if (numFila > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Modifica el alumno
	 * 
	 * @param idAlumno
	 *            un alumno existente
	 * 
	 * @param numExpediente
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param sexo
	 * @param dni
	 * @param telefono
	 * @param fecha_nacimiento
	 * @param pais
	 * @param provincia
	 * @param localidad
	 * @param domicilio
	 * @param email
	 */
	public boolean modifyAlumno(AlumnoVO alumnoVO) {
		Connection con = null;
		PreparedStatement ps = null;

		java.util.Date utilDate = alumnoVO.getFechaNacimiento();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		try {
			con = ds.getConnection();

			ps = con.prepareStatement("UPDATE alumno SET "
					+ "nombre=?, " + "apellido1=?, "
					+ "apellido2 = ?, " + "sexo=?, " + "dni=?, "
					+ "telefono=?, " + "fecha_nacimiento=?, " + "pais=?, "
					+ "localidad=?, " + "provincia=?, " + "domicilio=?, "
					+ "email=? " + "WHERE num_expediente = ?");

			ps.setString(1, alumnoVO.getNombre());
			ps.setString(2, alumnoVO.getApellido1());
			ps.setString(3, alumnoVO.getApellido2());
			ps.setString(4, alumnoVO.getSexo());
			ps.setString(5, alumnoVO.getDni());
			ps.setString(6, alumnoVO.getTelefono());
			ps.setDate(7, sqlDate);
			ps.setString(8, alumnoVO.getPais());
			ps.setString(9, alumnoVO.getLocalidad());
			ps.setString(10, alumnoVO.getProvincia());
			ps.setString(11, alumnoVO.getDomicilio());
			ps.setString(12, alumnoVO.getEmail());
			ps.setInt(13, alumnoVO.getNumExpediente());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;
	}
}
