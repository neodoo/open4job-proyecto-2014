package es.opensigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	DataSource ds;

	public AlumnoMatriculaDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean insertarMatricula(int idAlumno,int cursoEscolar, String centro,
			String ensenanza, String modulo, int curso) {
		Connection conn;
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO alumno_matricula (curso_escolar,centro, ensenanza, modulo, curso, id_alumno) VALUES (?,?,?,?,?,?)");
			
			stmt.setInt(1, cursoEscolar);
			stmt.setString(2, centro);
			stmt.setString(3, ensenanza);
			stmt.setString(4, modulo);
			stmt.setInt(5, curso);
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
					.prepareStatement("DELETE FROM alumno_matricula WHERE id=?");
			stmt.setInt(1, idMatricula);
			if(stmt.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return false;

	}

	public boolean modificarMatricula(int idAlumno, int cursoEscolar,
			String centro, String ensenanza, String modulo,
			int curso, int idMatricula) {

		Connection conn;
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("UPDATE alumno_matricula SET curso_escolar=?, centro=?, ensenanza=?, modulo=?, "
							+ "curso=?, id_alumno=? WHERE id=?");
			stmt.setInt(1, cursoEscolar);
			stmt.setString(2, centro);
			stmt.setString(3, ensenanza);
			stmt.setString(4, modulo);
			stmt.setInt(5, curso);
			stmt.setInt(6, idAlumno);
			stmt.setInt(7, idMatricula);
			int count = stmt.executeUpdate();
			if( count == 1)
				return true;
			
		} catch (SQLException e1) {
			logger.log(Level.SEVERE, "SQLException : " + e1.getMessage());
		}

		return false;

	}

	public ArrayList<AlumnoMatriculaVO> getListadoMatricula(int idAlumno) {

		Connection conn;
		ArrayList<AlumnoMatriculaVO> lista = new ArrayList<AlumnoMatriculaVO>();
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM alumno_matricula where id_alumno = ?");
			stmt.setInt(1, idAlumno);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lista.add(new AlumnoMatriculaVO(rs.getInt(1), rs.getInt(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getInt(6), rs.getInt(7)));
			}
			
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return lista;

	}
	
	public AlumnoMatriculaVO getListaFichaMatricula(int idMatricula) {

		Connection conn;
		AlumnoMatriculaVO fichamatricula = null;
		try {
			conn = ds.getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM alumno_matricula where id= ?");
			stmt.setInt(1, idMatricula);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				fichamatricula = (new AlumnoMatriculaVO(rs.getInt(1), rs.getInt(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getInt(6), rs.getInt(7)));
			}
		
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return fichamatricula;

	}



}
