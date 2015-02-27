package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoMatriculaDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoMatriculaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idMatricula;
	
	private FacesMessage facesMessage;

	public EliminarAlumnoMatriculaBean() {

	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String borrarMatricula(int idMatricula) {
		String pagina = "indexAlumnoMatricula";
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		if (alumnoMatriculaDAO.borrarMatricula(idMatricula)) {
			
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula se ha eliminado correctamente ", null);
		} else {
			pagina = "borrarAlumnoMatriculaFallo";
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La matricula no se ha eliminado correctamente ", null);
		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		
		return pagina;
	}

}
