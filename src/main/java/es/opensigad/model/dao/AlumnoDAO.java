package es.opensigad.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@SessionScoped
public class AlumnoDAO implements AlumnoDAOInterfaz, Serializable {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger.getLogger(AlumnoVO.class
			.getName());

	private DataSource ds;

	private AlumnoVO alumnoVO;

	public AlumnoVO getAlumnoVO() {
		return alumnoVO;
	}

	public void setAlumnoVO(AlumnoVO alumnoVO) {
		this.alumnoVO = alumnoVO;
	}

	public AlumnoDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<AlumnoVO> getListAlumno() {

		List<AlumnoVO> listAlumno = null;
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

	public AlumnoVO getDetalleAlumno(int num_expediente) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			new ArrayList<AlumnoVO>();
			con = ds.getConnection();

			this.alumnoVO = null;
			ps = con.prepareStatement("SELECT * FROM alumno where id =?");
			ps.setInt(1, num_expediente);

			result = ps.executeQuery();

			while (result.next()) {
				this.alumnoVO = new AlumnoVO(result.getInt("id"),
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
