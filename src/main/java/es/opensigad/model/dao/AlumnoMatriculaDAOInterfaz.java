package es.opensigad.model.dao;

import java.util.ArrayList;
import java.util.Date;

import es.opensigad.model.vo.AlumnoMatriculaVO;

public interface AlumnoMatriculaDAOInterfaz {

	public boolean insertarMatricula(int idAlumno, String fecha, String centro,
			String tipoEnsenanza, String ensenanza, String curso);

	public boolean borrarMatricula(int idMatricula);

	public boolean modificarMatricula(int idAlumno, String fecha,
			String centro, String tipoEnsenanza, String ensenanza, String curso, int idMatricula);

	public ArrayList<AlumnoMatriculaVO> getListadoMatricula(int idAlumno);
	
	public AlumnoMatriculaVO getListaFichaMatricula(int idMatricula);

}
