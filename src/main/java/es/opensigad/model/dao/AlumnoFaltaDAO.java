package es.opensigad.model.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public List<AlumnoFaltaVO> getListaFaltas(long pidAlumno) {

		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		List<AlumnoFaltaVO> listFaltas = new ArrayList<AlumnoFaltaVO>();
		AlumnoFaltaVO faltaVO = null;

		try {
			String sqlSP = "{call GetFaltasAlumno(?)}";
			
			con = ds.getConnection();			
			cs = con.prepareCall(sqlSP);
			cs.setLong(1, pidAlumno);		
			
			rs = cs.executeQuery();			
		
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
			logger.log(
					Level.SEVERE,
					"Error en AlumnoFaltaDAO.getListaFaltas : "
							+ e.getMessage());
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}			
		}
		return listFaltas;
	}

	// Datos de una falta
	public AlumnoFaltaVO getDetalleFalta(long pnumId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		AlumnoFaltaVO faltaVO = null;

		try {
			
			String selectSQL = "SELECT * FROM faltas WHERE id =?";

			con = ds.getConnection();
			ps = con.prepareStatement(selectSQL);
			ps.setLong(1, pnumId);
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
			logger.log(
					Level.SEVERE,
					"Error en AlumnoFaltaDAO.getDetalleFalta : "
							+ e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}			
		}

		return faltaVO;
	}

	// Insertar una falta
	public long insertarFalta(AlumnoFaltaVO falta) {

		long newId = 0;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String insertSQLTabla = "INSERT INTO faltas"
					+ " (id_Alumno, fecha, sesion, materia, tipo, justificado, observaciones)"
					+ " VALUES (?,?,?,?,?,?,?)";

			con = ds.getConnection();
			con.setAutoCommit(false);

			ps = con.prepareStatement(insertSQLTabla,
					Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, falta.getIdAlumno());

			java.sql.Date fechaSql = new java.sql.Date(falta.getFecha()
					.getTime());
			ps.setDate(2, fechaSql);

			ps.setString(3, falta.getSesion());
			ps.setString(4, falta.getMateria());
			ps.setString(5, falta.getTipo());
			ps.setString(6, falta.getJustificado());
			ps.setString(7, falta.getObservaciones());
			ps.executeUpdate();

			try {
				rs = ps.getGeneratedKeys();

				if (rs.next()) {
					newId = rs.getLong(1);
				} else {
					logger.log(Level.SEVERE,
							"Error en AlumnoFaltaDAO.insertarFalta: No se ha obtenido el ID correctamente");
				}

			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
					}
				}
			}

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.insertarFalta: "
					+ e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

		return newId;
	}

	// Actualizar una falta
	public long actualizarFalta(AlumnoFaltaVO falta) {

		long numReg = 0;

		Connection con = null;
		CallableStatement cs = null;

		try {
			String sqlSP = "{call UpdateFaltaAlumno(?,?,?,?,?,?,?,?)}";
			
			con = ds.getConnection();
			con.setAutoCommit(false);
			
			cs = con.prepareCall(sqlSP);

			java.sql.Date fechaSql = new java.sql.Date(falta.getFecha()
					.getTime());
			cs.setDate(1, fechaSql);

			cs.setString(2, falta.getSesion());
			cs.setString(3, falta.getMateria());
			cs.setString(4, falta.getTipo());
			cs.setString(5, falta.getJustificado());
			cs.setString(6, falta.getObservaciones());
			cs.setLong(7, falta.getId());
			cs.registerOutParameter(8, java.sql.Types.INTEGER);
					
			cs.executeUpdate();
			
			numReg = cs.getInt(8);
			
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			logger.log(
					Level.SEVERE,
					"Error en AlumnoFaltaDAO.actualizarFalta: "
							+ e.getMessage());
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

		return numReg;
	}

	// Eliminar una falta
	public long eliminarFalta(long idFalta) {

		long numReg = 0;

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String deleteSQLTabla = "DELETE FROM faltas" + " WHERE id = ?";

			con = ds.getConnection();
			con.setAutoCommit(false);

			ps = con.prepareStatement(deleteSQLTabla);
			ps.setLong(1, idFalta);
			numReg = ps.executeUpdate();

			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			logger.log(Level.SEVERE, "Error en AlumnoFaltaDAO.eliminarFalta: "
					+ e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

		return numReg;
	}

}
