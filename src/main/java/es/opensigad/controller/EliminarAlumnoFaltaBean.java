package es.opensigad.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoSeguimientoDAO;

@ManagedBean
@RequestScoped
public class EliminarAlumnoFaltaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;

	public EliminarAlumnoFaltaBean() {

	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String eliminarFalta(int id) {
		String pagina = null;
		AlumnoSeguimientoDAO alumnoFaltaDAO = new AlumnoSeguimientoDAO();
		//if (alumnoFaltaDAO.eliminarFalta(id) > 0) {
		//	pagina = "eliminarAlumnoFaltaExito";
		//} else {
		//	pagina = "eliminarAlumnoFaltaFallo";
		//}
		return pagina;
	}

}
