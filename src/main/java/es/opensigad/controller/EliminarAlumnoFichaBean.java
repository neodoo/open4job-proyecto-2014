package es.opensigad.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoFichaBean {

	public String deleteAlumno(int idAlumno) {

		String pagina = "index";

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoDAO.deleteAlumno(idAlumno);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente " + idAlumno
						+ " ha sido eliminado", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

}
