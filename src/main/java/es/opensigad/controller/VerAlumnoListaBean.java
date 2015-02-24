package es.opensigad.controller;
/*
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.Alumno;


@ManagedBean
@SessionScoped
public class VerAlumnoListaBean {

	private List<Alumno> alumnoLista;
	private List<Alumno> alumnoFiltro;

	public List<Alumno> getAlumnoFiltro() {
		return alumnoFiltro;
	}

	public void setAlumnoFiltro(List<Alumno> alumnoFiltro) {
		this.alumnoFiltro = alumnoFiltro;
	}

	public List<Alumno> getAlumnoLista() {
		return alumnoLista;
	}

	public void setAlumnoLista(List<Alumno> alumnoLista) {
		this.alumnoLista = alumnoLista;
	}

	public String getListAlumno() {

		String pagina = "verAlumnoLista";
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoLista = new ArrayList<Alumno>();
		alumnoLista = alumnoDAO.getListAlumno();

		if (alumnoLista == null) {
			pagina = "indexAlumno";
			FacesMessage facesMessage;

			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"No hay campos para listar", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return pagina;
		}
		return pagina;

	}

}
*/