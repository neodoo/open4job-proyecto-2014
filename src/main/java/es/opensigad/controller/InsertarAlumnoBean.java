package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@RequestScoped
public class InsertarAlumnoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private AlumnoVO alumnoVO = new AlumnoVO();

	public AlumnoVO getAlumnoVO() {
		return alumnoVO;
	}

	public void setAlumnoVO(AlumnoVO alumnoVO) {
		this.alumnoVO = alumnoVO;
	}

	public String insertAlumno() {

		String pagina = "indexAlumno";

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoDAO.insertAlumno(alumnoVO);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente "
						+ alumnoVO.getNumExpediente() + " ha sido insertado",
				null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

}
