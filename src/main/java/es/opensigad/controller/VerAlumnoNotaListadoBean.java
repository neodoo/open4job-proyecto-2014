package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;

import es.opensigad.model.vo.*;

@ManagedBean
@RequestScoped
public class VerAlumnoNotaListadoBean implements Serializable {

	@EJB
	private AlumnoNotaDAOInterfaz alumnoNotaDAO = null;

	public AlumnoNotaDAOInterfaz getAlumnoNotaDAO() {
		return alumnoNotaDAO;
	}

	public void setAlumnoNotaDAO(AlumnoNotaDAOInterfaz alumnoNotaDAO) {
		this.alumnoNotaDAO = alumnoNotaDAO;
	}

	private static final long serialVersionUID = 1L;

	private List<AlumnoNota> alumnoNotas;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AlumnoNota> getAlumnoNotas() {
		return alumnoNotas;
	}

	public void setAlumnoNotas(List<AlumnoNota> alumnNotas) {
		this.alumnoNotas = alumnNotas;
	}

	public String getDetalleNotasAlumno(int id) {

		// recoger el id del alumno en este metodo
		String pagina = "verAlumnoNotaListado";
		// AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		alumnoNotas = alumnoNotaDAO.getNotasByIdMatricula(id);

		return pagina;

	}
	
}
