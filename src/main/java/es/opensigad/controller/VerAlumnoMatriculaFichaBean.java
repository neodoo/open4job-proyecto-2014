package es.opensigad.controller;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.opensigad.model.dao.AlumnoMatriculaDAOInterfaz;
import es.opensigad.model.vo.AlumnoMatricula;

@Named
@SessionScoped
public class VerAlumnoMatriculaFichaBean {

	@EJB
	private AlumnoMatriculaDAOInterfaz matriculaDAO = null;

	private AlumnoMatricula matricula = new AlumnoMatricula();
	
	@Inject
	private SesionBean sesionBean;

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public AlumnoMatricula getMatricula() {
		return matricula;
	}

	public void setMatricula(AlumnoMatricula matricula) {
		this.matricula = matricula;
	}

	public String getDetalleMatricula() {

		String pagina = "verAlumnoMatriculaFicha.xhtml?redirect-faces=true";

		// AlumnoMatriculaDAO matriculaDAO = new AlumnoMatriculaDAO();
		matricula = matriculaDAO.getListaFichaMatricula(sesionBean.getIdMatricula());

		return pagina;

	}
}
