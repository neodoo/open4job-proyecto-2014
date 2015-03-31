package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;
import es.opensigad.model.vo.AlumnoNota;

@ManagedBean
@SessionScoped
public class VerAlumnoNotaListadoBean implements Serializable {

	@EJB
	private AlumnoNotaDAOInterfaz alumnoNotaDAO = null;

	private AlumnoNota selectedAlumnoNota;
	
	
	public void init(){
		getDetalleNotasAlumno();
	}
	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public AlumnoNota getSelectedAlumnoNota() {
		return selectedAlumnoNota;
	}

	public void setSelectedAlumnoNota(AlumnoNota selectedAlumnoNota) {
		this.selectedAlumnoNota = selectedAlumnoNota;
	}

	public AlumnoNotaDAOInterfaz getAlumnoNotaDAO() {
		return alumnoNotaDAO;
	}

	public void setAlumnoNotaDAO(AlumnoNotaDAOInterfaz alumnoNotaDAO) {
		this.alumnoNotaDAO = alumnoNotaDAO;
	}

	private static final long serialVersionUID = 1L;

	private List<AlumnoNota> alumnoNotas;
	private int id;
	private int idFila;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdFila() {
		return idFila;
	}
	
	public void setIdFila(int idFila) {
		this.idFila = idFila;
	}
	
	public List<AlumnoNota> getAlumnoNotas() {
		return alumnoNotas;
	}

	public void setAlumnoNotas(List<AlumnoNota> alumnNotas) {
		this.alumnoNotas = alumnNotas;
	}

	public String getDetalleNotasAlumno() {
		String pagina = "verAlumnoNotaListado";
		alumnoNotas = alumnoNotaDAO.getNotasByIdMatricula(sesionBean.getIdMatricula());

		return pagina;

	}
	
	public String getDetalleFilaNotasAlumno(int idFila) {
		sesionBean.setIdFilaNota(idFila);
		String pagina = "verDetalleAlumnoNotaListado";
		alumnoNotas = alumnoNotaDAO.getDetalleNotasByIdMatricula(sesionBean.getIdMatricula(), idFila);
		return pagina;

	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Select",
				((AlumnoNota) event.getObject()).getObservacion());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected",
				((AlumnoNota) event.getObject()).getObservacion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
