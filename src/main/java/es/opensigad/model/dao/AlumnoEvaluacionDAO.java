package es.opensigad.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoVO;
import es.opensigad.model.vo.AlumnoEvaluacionVO;

public class AlumnoEvaluacionDAO implements Serializable,
		AlumnoEvaluacionInterfaz {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger.getLogger(AlumnoVO.class
			.getName());
	private DataSource ds;
	private AlumnoEvaluacionVO evaluacionVO;

	public AlumnoEvaluacionVO getEvaluacionVO() {
		return evaluacionVO;
	}

	public void setEvaluacionVO(AlumnoEvaluacionVO evaluacionVO) {
		this.evaluacionVO = evaluacionVO;
	}

	public AlumnoEvaluacionDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// Listar todas las evaluaciones
	public ArrayList<AlumnoEvaluacionVO> getAlumnoEvaluacionListado() {
		ArrayList<AlumnoEvaluacionVO> listaEvaluaciones = new ArrayList<AlumnoEvaluacionVO>();
		try {
			Connection conexion = ds.getConnection();
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery("select * from evaluacion");
			while (rs.next()) {
				AlumnoEvaluacionVO evaluacion = new AlumnoEvaluacionVO();
				evaluacion.setIdEvaluacion(rs.getInt("id"));
				evaluacion.setIdEnsenanza(rs.getInt("id_ensenanza"));
				evaluacion.setIdCurso(rs.getInt("id_curso"));
				evaluacion.setEvaluacion(rs.getInt("evaluacion"));
				evaluacion.setFechaInicio(rs.getDate("fecha_inicio"));
				evaluacion.setFechaSesion(rs.getDate("fecha_sesion"));
				evaluacion.setFechaFin(rs.getDate("fecha_final"));
				evaluacion.setFechaPublicacion(rs.getDate("fecha_publicacion"));

				listaEvaluaciones.add(evaluacion);
			}
		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en EvaluacionesDAO.getallEvaluaciones:"
							+ e.getMessage());
		}
		return listaEvaluaciones;
	}

	// Crear nueva evaluacion

	public boolean insertarEvaluacionAlumno(int idEnsenanza, int idCurso,
			int evaluacion, Date fechaInicio, Date fechaFin, Date fechaSesion,
			Date fechaPublicacion) {

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());
			java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());
			java.sql.Date fechaS = new java.sql.Date(fechaSesion.getTime());
			java.sql.Date fechaP = new java.sql.Date(fechaPublicacion.getTime());

			conn = ds.getConnection();
			String query = "insert into evaluacion (id_ensenanza,id_curso,evaluacion,fecha_inicio,fecha_final,fecha_sesion,fecha_publicacion) values (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, idEnsenanza);
			pstm.setInt(2, idCurso);
			pstm.setInt(3, evaluacion);
			pstm.setDate(4, fechaI);
			pstm.setDate(5, fechaF);
			pstm.setDate(6, fechaS);
			pstm.setDate(7, fechaP);
			pstm.execute();
			return true;

		} catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AlumnoEvaluacionDAO.insertarEvaluacionAlumno:"
							+ e.getMessage());
		} finally {
			try {
				pstm.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		return false;

	}

	public void EditarEvaluacionesVO() {
		// TODO Auto-generated method stub

	}

	public boolean EliminarEvaluacionAlumno(int idEvaluacion) {

		Connection conexion = null;
		PreparedStatement pstm = null;
		try {
			 conexion = ds.getConnection();
			 pstm = conexion
					.prepareStatement("DELETE FROM evaluacion WHERE id=?");
			pstm.setInt(1, idEvaluacion);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { pstm.close(); } catch (Exception e) {}
			try { conexion.close(); } catch (Exception e) {}
		}
		return false;

	}

	}

	/*
	 * Editar una evaluacion public void EditarEvaluacionesVO() { try
	 * {EvaluacionVO Connection conexion = ds.getConnection(); PreparedStatement
	 * pstm = conexion
	 * .prepareStatement("Update evaluacion set id = ? , id_enseñanza = ? ," +
	 * " id_curso = ?, evaluacion = ?, fecha_inicio = ?, " +
	 * "fecha_sesion = ?, fecha_final = ? , fecha_publicacion = ? Where id= ?");
	 * /*pstm.setInt(1, ); pstm.setInt(1, ); pstm.se// Editar una evaluacion
	 * tInt(1, ); pstm.setInt(2, ); pstm.setDate(1, ); pstm.setDate(1, );
	 * pstm.setDate(1, ); pstm.setDate(1, );
	 * 
	 * pstm.executeUpdate(); } catch (Exception e) {
	 * 
	 * Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage());
	 * } }
	 * 
	 * // Eliminar una evaluacion public void EliminarEvaluacionesVO(){
	 * Connection conexion; try { conexion = ds.getConnection();
	 * PreparedStatement pstm = conexion
	 * .prepareStatement("DELETE FROM evaluacion WHERE id=?");
	 * //pstm.setInt(1,); pstm.executeUpdate(); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

