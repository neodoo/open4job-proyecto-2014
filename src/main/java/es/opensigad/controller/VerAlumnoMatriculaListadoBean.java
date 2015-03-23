package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoMatriculaDAOInterfaz;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoMatricula;

@ManagedBean
@RequestScoped
public class VerAlumnoMatriculaListadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private AlumnoMatriculaDAOInterfaz matriculaDAO = null;
	private int id;
	private List<AlumnoMatricula> listaMatricula;

	private List<AlumnoMatricula> listaMatriculaFiltro;
	public List<AlumnoMatricula> getListaMatriculaFiltro() {
		return listaMatriculaFiltro;
	}

	public void setListaMatriculaFiltro(List<AlumnoMatricula> listaMatriculaFiltro) {
		this.listaMatriculaFiltro = listaMatriculaFiltro;
	}

	private AlumnoMatricula alumnoMatriculaSeleccionado = new AlumnoMatricula();
	
	@PostConstruct
	public void init(){
		getListaMatriculaId();
	}

	@ManagedProperty(value="#{sesionBean}")
	private SesionBean sesionBean;

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public AlumnoMatricula getAlumnoMatriculaSeleccionado() {
		return alumnoMatriculaSeleccionado;
	}

	public void setAlumnoMatriculaSeleccionado(
			AlumnoMatricula alumnoMatriculaSeleccionado) {
		
		this.alumnoMatriculaSeleccionado = alumnoMatriculaSeleccionado;
		sesionBean.setIdMatricula(this.alumnoMatriculaSeleccionado.getId());
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
		listaMatricula = matriculaDAO.getListadoMatricula(sesionBean
				.getIdAlumno());

		return pagina;

	}

}
