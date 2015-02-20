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
public class InsertarAlumnoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Alumno alumno = new Alumno();

	private String fecha;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String insertAlumno() {
		// ERROR: No entra al metodo 
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

		alumno.setFechaNacimiento(utilDate);

		if (alumnoDAO.insertAlumno(alumno)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: El alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " no se ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;

	}

}
