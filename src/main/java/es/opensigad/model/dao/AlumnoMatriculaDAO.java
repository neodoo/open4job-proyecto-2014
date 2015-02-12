package es.opensigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoMatriculaVO;

public class AlumnoMatriculaDAO implements AlumnoMatriculaDAOInterfaz {

	public static final Logger logger = Logger
			.getLogger(AlumnoMatriculaDAO.class.getName());

	// @Resource(name="jdbc/opensigad")
	private DataSource ds;

	public AlumnoMatriculaDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean insertarMatricula(int idAlumno,String fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso) {
		Connection conn;
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO matriculas (fecha_curso,centro, tipo_ensenanza, ensenanza, curso, id_alumno) VALUES (?,?,?,?,?,?)");
			
			stmt.setString(1, fecha);
			stmt.setString(2, centro);
			stmt.setString(3, tipoEnsenanza);
			stmt.setString(4, ensenanza);
			stmt.setString(5, curso);
			stmt.setInt(6, idAlumno);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
		return false;
	}

	public boolean borrarMatricula(int idMatricula) {

		Connection conn;
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("DELETE * FROM matriculas WHERE id=?");
			stmt.setInt(1, idMatricula);
			stmt.executeUpdate();
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return true;

	}

	public boolean modificarMatricula(int idMatricula, String fecha,
			String centro, String tipoEnsenanza, String ensenanza, String curso) {

		Connection conn;
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("UPDATE FROM matriculas SET fecha_curso=?, centro=?, tipo_ensenanza=?, enseñanza=?, curso=? WHERE id=? )");
			stmt.setString(1, fecha);
			stmt.setString(2, centro);
			stmt.setString(3, tipoEnsenanza);
			stmt.setString(4, ensenanza);
			stmt.setString(5, curso);
			stmt.setInt(6, idMatricula);
			stmt.executeUpdate();
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		} catch (SQLException e1) {
			logger.log(Level.SEVERE, "SQLException : " + e1.getMessage());
		}

		return true;

	}

	public ArrayList<AlumnoMatriculaVO> getListadoMatricula(int idAlumno) {

		Connection conn;
		ArrayList<AlumnoMatriculaVO> lista = new ArrayList<AlumnoMatriculaVO>();
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM matriculas where id_alumno = ?");
			stmt.setInt(1, idAlumno);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(new AlumnoMatriculaVO(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getInt(7)));
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return lista;

	}

}
