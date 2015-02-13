package es.opensigad.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class VerAlumnoFaltaFichaBean {

	private int id;

	private AlumnoFaltaVO faltaVO = new AlumnoFaltaVO ();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlumnoFaltaVO getFaltaVO() {
		return faltaVO;
	}

	public void setFaltaVO(AlumnoFaltaVO faltaVO) {
		this.faltaVO = faltaVO;
	}

	public String getDetalleFalta(int id) {

		String pagina = "verAlumnoFaltaFicha";

		AlumnoFaltaDAO faltaDAO = new AlumnoFaltaDAO();
		faltaVO = faltaDAO.getDetalleFalta(id);

		return pagina;

	}

}
