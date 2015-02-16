package es.opensigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoNotaVO;

public class AlumnoNotaDAO {

	protected DataSource ds;

	public AlumnoNotaDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AlumnoNotaVO> getAllAlumnoNotas() {
		ArrayList<AlumnoNotaVO> alumnoNotas = new ArrayList<AlumnoNotaVO>();
		try {
			Connection conn = ds.getConnection();
			Statement stm;
			ResultSet rs;
			String consulta = "select * from nota";
			stm = conn.createStatement();
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
				AlumnoNotaVO alumnoNota = new AlumnoNotaVO();
				alumnoNota.setIdEnsenanza(rs.getInt("id_ensenanza"));
				alumnoNota.setIdMatricula(rs.getInt("id_matricula"));
				alumnoNota.setIdMateria(rs.getInt("id_materia"));
				alumnoNota.setIdEvaluacion(rs.getInt("id_evaluacion"));
				alumnoNota.setNota(rs.getInt("nota"));
				alumnoNotas.add(alumnoNota);
			}
			return alumnoNotas;
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoNotaDAO.getAllAlumnoNotas:"
							+ e.getMessage());
		}
		return null;
	}

	public ArrayList<AlumnoNotaVO> getNotasByIdMatricula(int idMatricula) {
		ArrayList<AlumnoNotaVO> notasAlumno = new ArrayList<AlumnoNotaVO>();
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstm;
			ResultSet rs;
			String consulta = "select * from nota where id_matricula =?";
			pstm = conn.prepareStatement(consulta);
			pstm.setInt(1, idMatricula);
			rs = pstm.executeQuery();
			while (rs.next()) {
				AlumnoNotaVO notasAlumnoVO = new AlumnoNotaVO();
				notasAlumnoVO.setIdEnsenanza(rs.getInt("id_ensenanza"));
				notasAlumnoVO.setIdMatricula(rs.getInt("id_matricula"));
				notasAlumnoVO.setIdMateria(rs.getInt("id_materia"));
				notasAlumnoVO.setIdEvaluacion(rs.getInt("id_evaluacion"));
				notasAlumnoVO.setNota(rs.getInt("nota"));
				notasAlumno.add(notasAlumnoVO);
			}
			return notasAlumno;
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoNotaDAO.getNotasBy_idMatricula:"
							+ e.getMessage());
		}
		return null;
	}

	public boolean insertarNotasAlumnoByIdMatricula(int idMatricula,
			int idEnsenanza, int idMateria, int idEvaluacion, int nota) {
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstm;
			String query = "insert into nota (id_matricula,id_ensenanza,id_materia, id_evaluacion,nota) values (?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idMatricula);
			pstm.setInt(2, idEnsenanza);
			pstm.setInt(3, idMateria);
			pstm.setInt(4, idEvaluacion);
			pstm.setInt(5, nota);
			pstm.execute();
			return true;

		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoNotaDAO.insertarNotasAlumnoByIdMatricula:"
							+ e.getMessage());
		}
		return false;
	}

	public boolean actualizarNotaByIdMatricula(int idMatricula,
			int idEnsenanza, int idMateria, int idEvaluacion, int nota) {
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstm;
			String query = "update nota set id_ensenanza=?, id_materia=?, id_evaluacion=?, nota=? where id_matricula =?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idEnsenanza);
			pstm.setInt(2, idMateria);
			pstm.setInt(3, idEvaluacion);
			pstm.setInt(4, nota);
			pstm.setInt(5, idMatricula);
			pstm.executeUpdate();
			return true;

		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoNotaDAO.actualizarNotaByIdMatricula:"
							+ e.getMessage());
		}
		return false;
	}

	public boolean borrarNotaByIdMatricula(int idMatricula) {
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstm;
			String query = "delete from nota where id_matricula = ?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idMatricula);
			if (pstm.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoNotaDAO.	public boolean borrarNotaByIdMatricula:"
							+ e.getMessage());
		}
		return false;
	}
}
