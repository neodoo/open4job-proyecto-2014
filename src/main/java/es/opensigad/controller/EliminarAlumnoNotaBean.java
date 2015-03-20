package es.opensigad.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import es.opensigad.model.dao.AlumnoNotaDAO;
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

	public String borrarNotaById(int id) {
		String pagina = null;
		if (alumnoNotaDAO.borrarNotaById(id)) {
			pagina = "borrarAlumnoNotaExito";
		} else {
			pagina = "borrarAlumnoNotaFallo";
		}
		return pagina;
	}

}
