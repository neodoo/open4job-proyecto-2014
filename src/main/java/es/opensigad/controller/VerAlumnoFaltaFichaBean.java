package es.opensigad.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class VerAlumnoFaltaFichaBean {
	private long id;

	private AlumnoFaltaVO alumnoFaltaVO = new AlumnoFaltaVO();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AlumnoFaltaVO getAlumnoFaltaVO() {
		return alumnoFaltaVO;
	}

	public void setAlumnoFaltaVO(AlumnoFaltaVO alumnoFaltaVO) {
		this.alumnoFaltaVO = alumnoFaltaVO;
	}

	public String getDetalleFalta() {

		String pagina = "verAlumnoFaltaFicha";

		AlumnoFaltaDAO alumnoFaltaDAO = new AlumnoFaltaDAO();
		alumnoFaltaVO = alumnoFaltaDAO.getDetalleFalta(id);

		return pagina;

	}

}
