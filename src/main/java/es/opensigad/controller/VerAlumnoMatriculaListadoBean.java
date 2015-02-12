package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.AlumnoMatriculaVO;

@ManagedBean
@RequestScoped
public class VerAlumnoMatriculaListadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private ArrayList<AlumnoMatriculaVO> listaMatriculaVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<AlumnoMatriculaVO> getListaMatriculaVO() {
		return listaMatriculaVO;
	}

	public void setListaMatriculaVO(ArrayList<AlumnoMatriculaVO> listaMatriculaVO) {
		this.listaMatriculaVO = listaMatriculaVO;
	}

	public String getListaMatricula(int idAlumno) {

		String pagina = "verAlumnoMatriculaListado";
		
		AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		listaMatriculaVO = matriculaDAO.getListadoMatricula(idAlumno);
		
		return pagina;

	}

}
