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

	private DataSource ds = null;

	public AlumnoFaltaDAO() {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// Faltas de un alumno
	public List<AlumnoFaltaVO> getListFaltasAlumno(int pidAlumno) {

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

				faltaVO = new AlumnoFaltaVO(id, idAlumno, fecha, sesion, materia,
						tipo, justificado, observaciones);
				listFaltas.add(faltaVO);
			}

		} catch (SQLException e) {
			listFaltas = null;
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
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

				faltaVO = new AlumnoFaltaVO(id, id_alumno, fecha, sesion, materia,
						tipo, justificado, observaciones);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return faltaVO;
	}

	public void actualizarFalta(AlumnoFaltaVO falta) {
		// TODO Auto-generated method stub

	}

	public void borrarFalta(int id) {
		// TODO Auto-generated method stub

	}

}
