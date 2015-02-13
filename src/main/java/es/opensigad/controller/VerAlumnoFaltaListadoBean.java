package es.opensigad.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoFaltaDAO;
import es.opensigad.model.vo.AlumnoFaltaVO;

@ManagedBean
@RequestScoped
public class VerAlumnoFaltaListadoBean {

	private int idAlumno;
	private List<AlumnoFaltaVO> faltasVO;

	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public List<AlumnoFaltaVO> getFaltasVO() {
		return faltasVO;
	}
	public void setFaltasVO(List<AlumnoFaltaVO> faltasVO) {
		this.faltasVO = faltasVO;
	}
	
	public String getAlumnoFaltaListado() {

		String pagina = "verAlumnoFaltaListado";

		AlumnoFaltaDAO faltaDAO = new AlumnoFaltaDAO();
		faltasVO = faltaDAO.getListaFaltas(idAlumno);

		return pagina;

	}

}
