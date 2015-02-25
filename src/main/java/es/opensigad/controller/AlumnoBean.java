package es.opensigad.controller;
<<<<<<< HEAD

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> 55b29601e27598ae7520bcc3cf4f89125ff90650

import java.io.Serializable;
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
	
	private FacesMessage facesMessage;

	private Alumno alumno = new Alumno();
	
	private Territorio territorioProvincia = new Territorio();
	
	private Territorio territorioPais = new Territorio();
	

	// MÉTODOS

	public String getDetalleAlumno() {

		String pagina = "verAlumnoFicha";
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumno = alumnoDAO.getDetalleAlumno(this.idAlumno);

		if (alumno != null) {
			setTerritorioPais(alumno.getTerritorio2());
			setTerritorioProvincia(alumno.getTerritorio1());
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
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumno.setTerritorio1(territorioProvincia);
		alumno.setTerritorio2(territorioPais);


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
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		if (alumnoDAO.deleteAlumno(alumno.getId()))
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
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumno.setTerritorio1(territorioProvincia);
		alumno.setTerritorio2(territorioPais);
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
