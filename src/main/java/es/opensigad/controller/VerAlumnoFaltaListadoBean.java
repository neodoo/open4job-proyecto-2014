package es.opensigad.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class VerAlumnoFaltaListadoBean {

	private long idAlumno;
	private List<AlumnoFaltaVO> alumnoFaltasVO;

	public long getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public List<AlumnoFaltaVO> getFaltasVO() {
		return alumnoFaltasVO;
	}
	public void setFaltasVO(List<AlumnoFaltaVO> faltasVO) {
		this.alumnoFaltasVO = faltasVO;
	}
	
	public String getAlumnoFaltaListado() {

		String pagina = "verAlumnoFaltaListado";

		AlumnoFaltaDAO faltaDAO = new AlumnoFaltaDAO();
		alumnoFaltasVO = faltaDAO.getListaFaltas(idAlumno);

		return pagina;

	}

}
