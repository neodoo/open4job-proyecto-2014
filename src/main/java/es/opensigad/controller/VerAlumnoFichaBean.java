package es.opensigad.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.AlumnoVO;

@ManagedBean
@RequestScoped
public class VerAlumnoFichaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private AlumnoVO alumnoVO = new AlumnoVO();

	private String fecha;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

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
		FacesMessage facesMessage;
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoVO = alumnoDAO.getDetalleAlumno(this.id);

		if (alumnoVO != null) {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			fecha = format.format(alumnoVO.getFechaNacimiento());

			return pagina;
		}

		pagina = "indexAlumno";
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente "
						+ this.id
						+ " no existe", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

	public String modifyAlumno() {

		String pagina = "indexAlumno";
		FacesMessage facesMessage;
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date utilDate = null;

		try {
			utilDate = (Date) format.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		alumnoVO.setFechaNacimiento(utilDate);

		if (alumnoDAO.modifyAlumno(alumnoVO))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumnoVO.getNumExpediente()
							+ " ha sido modificado", null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumnoVO.getNumExpediente()
							+ " no se ha modificado correctamente", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

}
