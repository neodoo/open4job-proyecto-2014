package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@RequestScoped
public class VerAlumnoFichaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;

	private AlumnoVO alumnoVO= new AlumnoVO();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlumnoVO getAlumnoVO() {
		return alumnoVO;
	}

	public void setAlumnoVO(AlumnoVO alumnoVO) {
		this.alumnoVO = alumnoVO;
	}

	public String getDetalleAlumno() {

		String pagina = "verAlumnoFicha";

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoVO = alumnoDAO.getDetalleAlumno(this.id);

		return pagina;

	}

}
