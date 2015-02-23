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
import es.opensigad.model.vo.Territorio;

@ManagedBean
@RequestScoped
public class AlumnoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idAlumno;

	private Alumno alumno = new Alumno();

	private String fecha;
	
	private Territorio territorioProvincia = new Territorio();
	
	private Territorio territorioPais = new Territorio();

	public String getDetalleAlumno() {
		
		
		// MÉTODOS

		String pagina = "verAlumnoFicha";
		FacesMessage facesMessage;
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumno = alumnoDAO.getDetalleAlumno(this.idAlumno);

		if (alumno != null) {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			fecha = format.format(alumno.getFechaNacimiento());

			return pagina;
		}

		pagina = "indexAlumno";
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente " + this.idAlumno + " no existe",
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


	public String deleteAlumno() {

		String pagina = "indexAlumno";
		FacesMessage facesMessage;
		AlumnoDAO alumnoDAO = new AlumnoDAO();

		if (alumnoDAO.deleteAlumno(idAlumno))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " ha sido eliminado", null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " no existe", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}
	
	public String insertAlumno() {
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
							+ alumno.getNumExpediente() + " ha sido insertado",
					null);
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

	//GETTERS Y SETTERS
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Territorio getTerritorioPais() {
		return territorioPais;
	}

	public void setTerritorioPais(Territorio territorioPais) {
		this.territorioPais = territorioPais;
	}

	public Territorio getTerritorioProvincia() {
		return territorioProvincia;
	}

	public void setTerritorioProvincia(Territorio territorioProvincia) {
		this.territorioProvincia = territorioProvincia;
	}

}
