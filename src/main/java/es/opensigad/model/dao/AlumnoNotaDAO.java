package es.opensigad.model.dao;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoNota;


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

	public ArrayList<AlumnoNota> getAllAlumnoNotas() {
		return null;
		
	}

	public ArrayList<AlumnoNota> getNotasByIdMatricula(int idMatricula) {
		return null;
		
	}

	public boolean insertarNotasAlumnoByIdMatricula(int idMatricula,int idEnsenanza, int idMateria, int idEvalucion,int nota){
		return false;
			
	}

	public boolean actualizarNotaByIdMatricula(int idMatricula,int idEnsenanza, int idMateria, int idEvalucion,int nota){
		return false;
			
	}

	public boolean borrarNotaByIdMatricula(int idMatricula) {
		return false;
		
	}
}
