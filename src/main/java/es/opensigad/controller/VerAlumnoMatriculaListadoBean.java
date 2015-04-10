package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.opensigad.model.dao.AlumnoMatriculaDAOInterfaz;
import es.opensigad.model.vo.AlumnoMatricula;

@Named
@ViewScoped
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
	
	public void init(){
		getListaMatriculaId();
	}

	@Inject
	private SesionBean sesionBean;

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
		
		if (id == 0){
			id = sesionBean.getIdAlumno();
		}
		
		// AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		listaMatricula = matriculaDAO.getListadoMatricula(id);

		return pagina;

	}

	
	public String navegaListadoMatricula() {
		return "verAlumnoMatriculaListado?faces-redirect=true&id=" + sesionBean.getIdAlumno();
	}
}
