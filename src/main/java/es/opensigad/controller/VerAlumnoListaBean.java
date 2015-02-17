package es.opensigad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@SessionScoped
public class VerAlumnoListaBean {

	
	private List<AlumnoVO> alumnoLista;
	private List<AlumnoVO> alumnoFiltro;
	

	


	public List<AlumnoVO> getAlumnoFiltro() {
		return alumnoFiltro;
	}



	public void setAlumnoFiltro(List<AlumnoVO> alumnoFiltro) {
		this.alumnoFiltro = alumnoFiltro;
	}



	public List<AlumnoVO> getAlumnoLista() {
		return alumnoLista;
	}



	public void setAlumnoLista(List<AlumnoVO> alumnoLista) {
		this.alumnoLista = alumnoLista;
	}

	public  String getListAlumno() {

		String pagina = "verAlumnoLista";
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoLista = new ArrayList<AlumnoVO>();
		alumnoLista = alumnoDAO.getListAlumno();

		return pagina;

	}


}
