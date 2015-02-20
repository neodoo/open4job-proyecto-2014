package es.opensigad.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.vo.Alumno;

@ManagedBean
@RequestScoped
public class VerAlumnoFichaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private Alumno alumno = new Alumno();

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

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getDetalleAlumno() {

		String pagina = "verAlumnoFicha";
		FacesMessage facesMessage;
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumno = alumnoDAO.getDetalleAlumno(this.id);

		if (alumno != null) {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			fecha = format.format(alumno.getFechaNacimiento());

			return pagina;
		}

		pagina = "indexAlumno";
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente " + this.id + " no existe",
				null);
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

			facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"La fecha insertada no tiene el formato correcto 'dd/MM/yyyy'",
					null);

			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			pagina = "verAlumnoFicha";
			return pagina;
		}

		alumno.setFechaNacimiento(utilDate);

		if (alumnoDAO.modifyAlumno(alumno))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " ha sido modificado", null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " no se ha modificado correctamente", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

}
