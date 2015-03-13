package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.dao.AlumnoMatriculaDAOInterfaz;
import es.opensigad.model.vo.AlumnoMatricula;

@ManagedBean
@RequestScoped
public class VerAlumnoMatriculaListadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private AlumnoMatriculaDAOInterfaz matriculaDAO = null;
	private int id;
	private List<AlumnoMatricula> listaMatricula;
	private SesionBean sesionAlumno;

	public SesionBean getSesionAlumno() {
		return sesionAlumno;
	}

	public void setSesionAlumno(SesionBean sesionAlumno) {
		this.sesionAlumno = sesionAlumno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AlumnoMatricula> getListaMatricula() {
		return listaMatricula;
	}

	public void setListaMatricula(List<AlumnoMatricula> listaMatriculaVO) {
		this.listaMatricula = listaMatriculaVO;
	}

	public String getListaMatriculaId() {

		String pagina = "verAlumnoMatriculaListado";

		// AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		listaMatricula = matriculaDAO.getListadoMatricula(sesionAlumno
				.getIdAlumno());

		return pagina;

	}

}
