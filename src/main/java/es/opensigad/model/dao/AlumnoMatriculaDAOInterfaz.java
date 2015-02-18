package es.opensigad.model.dao;

import java.util.ArrayList;

import es.opensigad.model.vo.AlumnoMatriculaVO;

public interface AlumnoMatriculaDAOInterfaz {

	public boolean insertarMatricula(int idAlumno,int cursoEscolar, String centro,
			String ensenanza, String modulo, int curso);

	public boolean borrarMatricula(int idMatricula);

	public boolean modificarMatricula(int idAlumno, int cursoEscolar,
			String centro, String ensenanza, String modulo,
			int curso, int idMatricula);

	public ArrayList<AlumnoMatriculaVO> getListadoMatricula(int idAlumno);
	
	public AlumnoMatriculaVO getListaFichaMatricula(int idMatricula);

}
