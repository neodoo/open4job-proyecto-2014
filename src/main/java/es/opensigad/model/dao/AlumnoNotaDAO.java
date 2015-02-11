package es.opensigad.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import es.opensigad.model.vo.AlumnoNotaVO;

public class AlumnoNotaDAO {

	private DataSource ds;

	public AlumnoNotaDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/opensigad");
		} catch (NamingException e) {
			e.printStackTrace();
		}
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
					"Error en NotasAlumnosBean.getNotasBy_idMatricula:"
							+ e.getMessage());
		}
		return null;
	}
}
