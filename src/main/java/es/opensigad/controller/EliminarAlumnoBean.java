package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idAlumno;
	
	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@ManagedProperty(value="#{verAlumnoFichaBean}")
	private VerAlumnoFichaBean verAlumnoFichaBean;
	
	public VerAlumnoFichaBean getVerAlumnoFichaBean() {
		return verAlumnoFichaBean;
	}

	public void setVerAlumnoFichaBean(VerAlumnoFichaBean verAlumnoFichaBean) {
		this.verAlumnoFichaBean = verAlumnoFichaBean;
	}

	public String deleteAlumno(int idAlumno) {

		String pagina = "indexAlumno";

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
