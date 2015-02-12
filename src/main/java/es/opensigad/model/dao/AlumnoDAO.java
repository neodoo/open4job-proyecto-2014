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
		} catch (SQLException e) {
			listAlumno = null;
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return listAlumno;
	}

	public AlumnoVO getDetalleAlumno(int idAlumno) {

		AlumnoVO alumnoVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			new ArrayList<AlumnoVO>();
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM alumno where id =?");
			ps.setInt(1, idAlumno);

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
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return alumnoVO;

	}

}
