package es.opensigad.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;

@ManagedBean
@RequestScoped
public class EliminarAlumnoNotaBean implements Serializable {
	@EJB
	private AlumnoNotaDAOInterfaz alumnoNotaDAO = null;
	private static final long serialVersionUID = 1L;
	private int id;

	public EliminarAlumnoNotaBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlumnoNotaDAOInterfaz getAlumnoNotaDAO() {
		return alumnoNotaDAO;
	}

	public void setAlumnoNotaDAO(AlumnoNotaDAOInterfaz alumnoNotaDAO) {
		this.alumnoNotaDAO = alumnoNotaDAO;
	}

	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	private FacesMessage facesMessage;

	public String borrarNotaById(int id) {
		String pagina = null;
		if (alumnoNotaDAO.borrarNotaById(id)) {
			pagina = "verAlumnoNotaListado";
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La nota del alumno con matricula "
							+ sesionBean.getIdMatricula()
							+ " ha sido eliminada.", null);

		} else {
			pagina = "verAlumnoNotaListado";
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La nota del alumno con matricula "
							+ sesionBean.getIdMatricula()
							+ " NO ha sido eliminada.", null);

		}
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;
	}

}
