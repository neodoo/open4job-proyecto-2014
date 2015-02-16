package es.opensigad.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoFaltaVO;

public class AlumnoFaltaDAO implements AlumnoFaltaDAOInterfaz, Serializable {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger.getLogger(AlumnoFaltaVO.class
			.getName());

	public DataSource ds = null;

	public AlumnoFaltaDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// Faltas de un alumno
	public List<AlumnoFaltaVO> getListaFaltas(int pidAlumno) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<AlumnoFaltaVO> listFaltas = new ArrayList<AlumnoFaltaVO>();
		AlumnoFaltaVO faltaVO = null;

		try {

			String query = "SELECT * FROM faltas WHERE id_alumno =? ORDER BY id";

			con = ds.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, pidAlumno);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int idAlumno = rs.getInt(2);
				Date fecha = rs.getDate(3);
				String sesion = rs.getString(4);
				String materia = rs.getString(5);
				String tipo = rs.getString(6);
				String justificado = rs.getString(7);
				String observaciones = rs.getString(8);

				faltaVO = new AlumnoFaltaVO(id, idAlumno, fecha, sesion,
						materia, tipo, justificado, observaciones);
				listFaltas.add(faltaVO);
			}

		} catch (SQLException e) {
			listFaltas = null;
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.getListaFaltas : " + e.getMessage());
		}
		return listFaltas;
	}

	// Datos de una falta
	public AlumnoFaltaVO getDetalleFalta(int idFalta) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		AlumnoFaltaVO faltaVO = null;

		try {
			String query = "SELECT * FROM faltas WHERE id =?";

			con = ds.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, idFalta);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int id_alumno = rs.getInt(2);
				Date fecha = rs.getDate(3);
				String sesion = rs.getString(4);
				String materia = rs.getString(5);
				String tipo = rs.getString(6);
				String justificado = rs.getString(7);
				String observaciones = rs.getString(8);

				faltaVO = new AlumnoFaltaVO(id, id_alumno, fecha, sesion,
						materia, tipo, justificado, observaciones);
			}

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.getDetalleFalta : " + e.getMessage());
		}
		return faltaVO;
	}

	// Insertar una falta
	public int insertarFalta(AlumnoFaltaVO falta) {
		
		int numReg = 0;
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO faltas (id_Alumno, fecha, sesion, materia, tipo, justificado, observaciones) VALUES (?,?,?,?,?,?,?)";

			con = ds.getConnection();
			ps = con.prepareStatement(query);		
			ps.setInt(1, falta.getIdAlumno());
			
			java.sql.Date fechaSql = new java.sql.Date(falta.getFecha().getTime());
			ps.setDate(2, fechaSql);
			
			ps.setString(3, falta.getSesion());
			ps.setString(4, falta.getMateria());
			ps.setString(5, falta.getTipo());
			ps.setString(6, falta.getJustificado());
			ps.setString(7, falta.getObservaciones());
			
			numReg = ps.executeUpdate();

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.insertarFalta : " + e.getMessage());
		}

		return numReg;
	}

	// Actualizar una falta
	public int actualizarFalta(AlumnoFaltaVO falta) {

		int numReg = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE faltas SET fecha = ?, sesion = ?, materia = ?, tipo = ?, justificado = ?, observaciones = ? WHERE id = ?";

			con = ds.getConnection();
			ps = con.prepareStatement(query);
								
			java.sql.Date fechaSql = new java.sql.Date(falta.getFecha().getTime());
			ps.setDate(1, fechaSql);

			ps.setString(2, falta.getSesion());
			ps.setString(3, falta.getMateria());
			ps.setString(4, falta.getTipo());
			ps.setString(5, falta.getJustificado());
			ps.setString(6, falta.getObservaciones());
			ps.setInt(7, falta.getId());
			
			numReg = ps.executeUpdate();


		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.actualizarFalta : " + e.getMessage());
		}

		return numReg;
	}

	// Eliminar una falta
	public int eliminarFalta(int idFalta) {

		int numReg = 0;
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "DELETE FROM faltas WHERE id = ?";

			con = ds.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, idFalta);
			numReg = ps.executeUpdate();

		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.eliminarFalta : " + e.getMessage());
		}

		return numReg;
	}

}
