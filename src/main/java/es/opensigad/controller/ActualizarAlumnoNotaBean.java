package es.opensigad.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;
import es.opensigad.model.vo.AlumnoMatricula;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.vo.EnsenanzaMateria;

@ManagedBean
@RequestScoped
public class ActualizarAlumnoNotaBean implements Serializable {
	
	@EJB
	private AlumnoNotaDAOInterfaz alumnoNotaDAO=null;
	
	private static final long serialVersionUID = 1L;
	private int id;
	private AlumnoMatricula alumnoMatricula = new AlumnoMatricula();
	private EnsenanzaMateria ensenanzaMateria = new EnsenanzaMateria();
	private String evaluacion;
	private String nota;
	private String observacion;
	
	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}
	
	public ActualizarAlumnoNotaBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlumnoMatricula getAlumnoMatricula() {
		return alumnoMatricula;
	}

	public void setAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		this.alumnoMatricula = alumnoMatricula;
	}

	public EnsenanzaMateria getEnsenanzaMateria() {
		return ensenanzaMateria;
	}

	public void setEnsenanzaMateria(EnsenanzaMateria ensenanzaMateria) {
		this.ensenanzaMateria = ensenanzaMateria;
	}


	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
/*
	public String actualizarNotaByIdMatricula(int id,int idAlumnoMatricula,int idMateria, String evaluacion,String nota, String observacion) {
		String pagina=null;
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		if (alumnoNotaDAO.actualizarNotaByIdMatricula(id,idAlumnoMatricula, idMateria, evaluacion, nota,observacion)){
			pagina = "actualizarAlumnoNotaExito";
		}else{
			pagina = "actualizarAlumnoNotaFallo";
		}
		return pagina;
	}*/
	 public String onRowEdit(RowEditEvent event) {
	
		 	AlumnoNota alumnoNota = (AlumnoNota) event.getObject();
		 	
			 	String pagina=null;
	
				if (alumnoNotaDAO.actualizarNotaByIdMatricula(alumnoNota.getId(), alumnoNota.getAlumnoMatricula().getId(),alumnoNota.getEnsenanzaMateria().getId(),alumnoNota.getEvaluacion(),alumnoNota.getNota(),alumnoNota.getObservacion())){
					 FacesMessage msg = new FacesMessage("Car Edited");
				     FacesContext.getCurrentInstance().addMessage(null, msg);
				}
				
				pagina = "verDetalleAlumnoNotaListado";
				return pagina;
	
	
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
}
