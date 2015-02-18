package es.opensigad.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.opensigad.model.vo.AlumnoVO;
import es.opensigad.model.vo.TutorVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




@ManagedBean
@SessionScoped
public class TutorDAO implements TutorDAOInterface {

	public static final Logger logger = Logger.getLogger(AlumnoVO.class
			.getName());
	
	// @Resource(name="jdbc/myoracle")
	private DataSource ds;

	public TutorDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// Devuelve una lista con todos los tutores
	public ArrayList<TutorVO> getlistaTutor() {

		ArrayList<TutorVO> listaTutores = new ArrayList<TutorVO>();

		try {
			if (ds == null)
				throw new SQLException("Can't get data source");
			// get database connection
			Connection con = ds.getConnection();

			if (con == null)
				throw new SQLException("Can't get database connection");

			PreparedStatement st = con
					.prepareStatement("SELECT * FROM tutor");
			// PreparedStatement st =
			// conexion.prepareStatement("SELECT * FROM EQ4_BICI");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
					String aux = new String();
					PreparedStatement st1 = con.prepareStatement("SELECT parentesco FROM alumno_tutor WHERE idTutor = ?");
					st1.setInt(1, rs.getInt(1));
					ResultSet rs1 = st1.executeQuery();
					while (rs1.next()){
						aux = rs1.getString("parentesco");
						
						listaTutores.add(new TutorVO(rs.getInt(1), rs.getString(2),
								rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6),
								rs.getDate(7), rs.getString(8), aux,
								rs.getString(9), rs.getString(10)));
					}
			}
			

		} catch (Exception e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
	
		return listaTutores;

	}


	public ArrayList<TutorVO> getlistaTutor(int idAlumno) {

		ArrayList<TutorVO> listaTutores = new ArrayList<TutorVO>();

		try {
				if (ds == null)
					throw new SQLException("Can't get data source");
				// get database connection
				Connection con = ds.getConnection();

				if (con == null)
					throw new SQLException("Can't get database connection");

				PreparedStatement st = con.prepareStatement("SELECT * FROM alumno_tutor WHERE idAlumno= ?");
				st.setInt(1, idAlumno);
				ResultSet rs = st.executeQuery();
				
				PreparedStatement stTutor= null;
				while (rs.next()) {
					
					stTutor = con.prepareStatement("SELECT * FROM tutor WHERE id= ?");
					stTutor.setInt(1, rs.getInt(2));
					
					String aux = rs.getString("parentesco");
					ResultSet rsTutor= stTutor.executeQuery();
					
					while(rsTutor.next())
					{
						listaTutores.add(new TutorVO(rsTutor.getInt(1), rsTutor.getString(2),
								rsTutor.getString(3), rsTutor.getString(4),
								rsTutor.getString(5), rsTutor.getString(6),
								rsTutor.getDate(7), rsTutor.getString(8), aux,
								rsTutor.getString(9), rsTutor.getString(10)));
						
					}
			}

		} catch (Exception e) {
			
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error en TutorDAO.listaTutor:"+ e.getMessage());

		}
		return listaTutores;

	}
	// borra 1 tutor con el idTutor recibido
	public void deleteTutor(int id) {

		try{
			if (ds == null)
				throw new SQLException("Can't get data source");
			// get database connection
			Connection con = ds.getConnection();
	
			if (con == null)
				throw new SQLException("Can't get database connection");
	
			PreparedStatement st = con
					.prepareStatement("DELETE FROM tutor WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
			
			/*Validamos si el tutor a borrar ya existe*/		
			PreparedStatement val = con.prepareStatement("SELECT idTutor FROM alumno_tutor WHERE idTutor = ?");
			val.setInt(1, id);		
			ResultSet rs = val.executeQuery();
			
			/*Si no existe en la base de datos lo borramos de la tabla intermedia(alumno_tutor)*/
			if (!rs.next()){
				PreparedStatement st2 = con
						.prepareStatement("DELETE FROM alumno_tutor WHERE idTutor = ?");
				st2.setInt(1, id);
				st2.executeUpdate();
			}
			
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}
	}

	// modifica un tutor con el id recibido
	public boolean updateTutor(int idTutor, String nombre, String apellido1, String apellido2,
			String tipoDocumento, String documento, java.sql.Date fechaNac, String parentesco,
			String telefono, String email) {
		
		try{
			if (ds == null)
				throw new SQLException("Can't get data source");
			// get database connection
			Connection con = ds.getConnection();
	
			if (con == null)
				throw new SQLException("Can't get database connection");
	
			PreparedStatement st = con
					.prepareStatement("UPDATE tutor SET nombre = ? , apellido1 = ? , apellido2 = ?, tipoDocumento = ?, documento = ?, fechaNac = ?, tel = ?,email = ? WHERE id = ?");
			st.setString(1, nombre);
			st.setString(2, apellido1);
			st.setString(3, apellido2);
			st.setString(4, tipoDocumento);
			st.setString(5, documento);
			java.sql.Date fecha = new java.sql.Date (fechaNac.getTime());
			st.setDate(6, fecha);
			st.setString(7, telefono);
			st.setString(8, email);
			st.setInt(9, idTutor);
			st.executeUpdate();	
			
			PreparedStatement st1 = con.
								prepareStatement("UPDATE alumno_tutor SET parentesco = ? WHERE idAlumno = ?");
		
			st1.setString(1, parentesco);
			st1.setInt(2, idTutor);
			st1.executeUpdate();
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}		
		return false;
	}

	public boolean insertarTutor(int idAlumno, String nombre, String apellido1,
			String apellido2, String tipoDocumento, String documento, Date fechaNac,
			String sexo, String parentesco, 
			String telefono, String email) {
		
		
		try{
			if (ds == null)
				throw new SQLException("Can't get data source");
			// get database connection
			Connection con = ds.getConnection();
	
			if (con == null)
				throw new SQLException("Can't get database connection");
			
			/*Validamos si el tutor a insertar ya existe*/		
			PreparedStatement val = con.prepareStatement("SELECT idTutor FROM alumno_tutor WHERE idAlumno = ?");
			val.setInt(1, idAlumno);		
			ResultSet rs = val.executeQuery();
			
			/*Si no existe en la base de datos lo insertamos en la tabla*/
			if (!rs.next()){
				PreparedStatement st = con
						.prepareStatement("INSERT INTO tutor (nombre,apellido1,apellido2,tipo_documento,documento,fecha_nacimiento,sexo,telefono,email) values (?,?,?,?,?,?,?,?,?)");			
				st.setString(1, nombre);
				st.setString(2, apellido1);
				st.setString(3, apellido2);
				st.setString(4, tipoDocumento);
				st.setString(5, documento);
				java.sql.Date fecha = new java.sql.Date (fechaNac.getTime());
				st.setDate(6,fecha);
				st.setString(7, sexo);
				st.setString(8, telefono);
				st.setString(9, email);
				st.executeUpdate();
				
				/*Recupero el idTutor que acabamos de crear*/
				ResultSet rsH= st.getGeneratedKeys();
				int clave=0;
				while(rsH.next())
				{
					clave = rsH.getInt(1);
					System.out.println(clave);
				
				}
				//inserto el tutor en la tabla de relaciones
				PreparedStatement st3 = con.prepareStatement("INSERT INTO alumno_tutor(idAlumno, idTutor) values ('1',?) ");
				
				if(clave!=0)
					st3.setInt(1, clave);		
				st3.executeUpdate();
				
			}else{
				/*Si existe solo insertamos la relacion*/
				PreparedStatement st = con.prepareStatement("INSERT INTO alumno_tutor(idAlumno, idTutor) values ('1',?) ");
				st.setInt(1, rs.getInt("idTutor"));	
				st.executeUpdate();
			}
			
			return true;
		}
		catch (Exception e) 
		{
				Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					"Error en TutorDAO.insertarTutor:"
							+ e.getMessage());
			
		}
		return false;
	}

	
	public TutorVO getDetalleTutor(int idTutor) {
		
		TutorVO tutorVO = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			new ArrayList<TutorVO>();
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM tutor where id = ?");
			ps.setInt(1, idTutor);

			rs = ps.executeQuery();
			
			String aux = new String();
			PreparedStatement pt1 = con.prepareStatement("SELECT * FROM alumno_tutor WHERE idTutor = ?");
			pt1.setInt(1, idTutor);
			while (rs.next()){
				aux = rs.getString("parentesco");
			}
			
			while (rs.next()) {
				tutorVO = new TutorVO(
						rs.getInt("idTutor"),
						rs.getString("nombre"), 
						rs.getString("apellido1"), 
						rs.getString("apellido2"),
						rs.getString("tipo_documento"),
						rs.getString("documento"), 
						rs.getDate("fecha_nacimiento"),
						rs.getString("sexo"),
						aux,
						rs.getString("tlf"), 
						rs.getString("email"));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		return tutorVO;

	}




}
