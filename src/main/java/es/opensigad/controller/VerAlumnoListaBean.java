package es.opensigad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@RequestScoped
public class VerAlumnoListaBean {

	
	private List<AlumnoVO> alumnoLista;

	

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
