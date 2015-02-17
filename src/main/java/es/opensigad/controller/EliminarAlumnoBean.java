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
public class EliminarAlumnoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idAlumno;

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@ManagedProperty(value = "#{verAlumnoFichaBean}")
	private VerAlumnoFichaBean verAlumnoFichaBean;

	public VerAlumnoFichaBean getVerAlumnoFichaBean() {
		return verAlumnoFichaBean;
	}

	public void setVerAlumnoFichaBean(VerAlumnoFichaBean verAlumnoFichaBean) {
		this.verAlumnoFichaBean = verAlumnoFichaBean;
	}

	public String deleteAlumno() {

		String pagina = "indexAlumno";
		FacesMessage facesMessage;
		AlumnoDAO alumnoDAO = new AlumnoDAO();

		if (alumnoDAO.deleteAlumno(verAlumnoFichaBean.getAlumnoVO()
				.getIdAlumno()))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ verAlumnoFichaBean.getAlumnoVO().getNumExpediente()
							+ " ha sido eliminado", null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ verAlumnoFichaBean.getAlumnoVO().getNumExpediente()
							+ " no existe", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

}
