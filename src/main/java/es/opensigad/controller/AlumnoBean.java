package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAOInterfaz;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.AlumnoDireccion;
import es.opensigad.model.vo.Territorio;

@ManagedBean
@RequestScoped
public class AlumnoBean implements Serializable {

	@EJB
	private AlumnoDAOInterfaz alumnoDAO = null;

	private static final long serialVersionUID = 1L;

	private FacesMessage facesMessage;

	private Alumno alumno = new Alumno();

	private Alumno alumnoSeleccionado = new Alumno();

	private Territorio territorioProvincia = new Territorio();

	private Territorio territorioPais = new Territorio();

	private AlumnoContacto alumnoContacto = new AlumnoContacto();

	private AlumnoDireccion alumnoDireccion = new AlumnoDireccion();

	private List<Alumno> alumnoLista;

	private List<Alumno> alumnoFiltro;

	private List<AlumnoDireccion> direccionLista;

	private List<AlumnoDireccion> direccionFiltro;

	@PostConstruct
	public void init() {
		getListAlumno();
	}

	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;

	public AlumnoBean() {
	}

	// MÉTODOS

	public String getDetalleAlumno(int numExpediente) {

		String pagina = "verAlumnoFicha";
		sesionBean.setNumExpediente(numExpediente);
		alumno = alumnoDAO.getDetalleAlumno(sesionBean.getNumExpediente());

		if (alumno != null) {
			setTerritorioPais(alumno.getTerritorio2());
			setTerritorioProvincia(alumno.getTerritorio1());
			sesionBean.setIdAlumno(alumno.getId());
			getListDirecciones();
			return pagina;
		}

		pagina = "indexAlumno";
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente "
						+ sesionBean.getNumExpediente() + " no existe", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

	public void getListAlumno() {

		alumnoLista = alumnoDAO.getListAlumno();
	}

	public void getListDirecciones() {

		direccionLista = alumnoDAO.getListAlumnoDireccion(sesionBean
				.getIdAlumno());
	}

	public String modifyAlumno() {

		String pagina = "indexAlumno";
		alumno.setTerritorio1(territorioProvincia);
		alumno.setTerritorio2(territorioPais);
		alumno.setId(sesionBean.getIdAlumno());

		if (alumnoDAO.modifyAlumno(alumno))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " ha sido modificado", null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " no se ha modificado correctamente", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

	public String deleteAlumno() {

		String pagina = "verAlumnoLista";
		if (alumnoDAO.deleteAlumno(sesionBean.getIdAlumno()))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " ha sido eliminado", null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ sesionBean.getNumExpediente() + " no existe",
					null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

	public String insertAlumno() {
		String pagina = "indexAlumno";
		alumno.setTerritorio1(territorioProvincia);
		alumno.setTerritorio2(territorioPais);
		if (alumnoDAO.insertAlumno(alumno)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: El alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " no se ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;

	}

	public String insertAlumnoContacto() {
		String pagina = "indexAlumno";
		alumnoContacto.setAlumno(alumno);
		if (alumnoDAO.insertAlumnoContacto(alumnoContacto)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El contacto del alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: El contacto del alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " no se ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;
	}

	public String modifyAlumnoContacto() {
		String pagina = "indexAlumno";
		alumnoContacto.setAlumno(alumno);
		if (alumnoDAO.modifyAlumnoContacto(alumnoContacto)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El contacto del alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: El contacto del alumno con numero de expediente "
							+ sesionBean.getNumExpediente()
							+ " no se ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;
	}

	public String insertAlumnoDireccion() {
		String pagina = "indexAlumno";
		alumnoDireccion.setAlumno(alumno);
		alumnoDireccion.getAlumno().setId(sesionBean.getIdAlumno());
		alumnoDireccion.getAlumno().setNumExpediente(sesionBean.getNumExpediente());
		alumnoDireccion.setTerritorio1(territorioProvincia);
		alumnoDireccion.setTerritorio2(territorioPais);
		if (alumnoDAO.insertAlumnoDireccion(alumnoDireccion)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La direccion para el alumno con numero de expediente "
							+ alumno.getNumExpediente() + " ha sido insertada",
					null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: La direccion para el alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " no se ha sido insertada", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;

	}

	// GETTERS Y SETTERS

	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}

	public List<Alumno> getAlumnoFiltro() {
		return alumnoFiltro;
	}

	public void setAlumnoFiltro(List<Alumno> alumnoFiltro) {
		this.alumnoFiltro = alumnoFiltro;
	}

	public List<Alumno> getAlumnoLista() {
		return alumnoLista;
	}

	public void setAlumnoLista(List<Alumno> alumnoLista) {
		this.alumnoLista = alumnoLista;
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

	public AlumnoContacto getAlumnoContacto() {
		return alumnoContacto;
	}

	public void setAlumnoContacto(AlumnoContacto alumnoContacto) {
		this.alumnoContacto = alumnoContacto;
	}

	public Alumno getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}

	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
		this.alumnoSeleccionado = alumnoSeleccionado;
	}

	public List<AlumnoDireccion> getDireccionLista() {
		return direccionLista;
	}

	public void setDireccionLista(List<AlumnoDireccion> direccionLista) {
		this.direccionLista = direccionLista;
	}

	public List<AlumnoDireccion> getDireccionFiltro() {
		return direccionFiltro;
	}

	public void setDireccionFiltro(List<AlumnoDireccion> direccionFiltro) {
		this.direccionFiltro = direccionFiltro;
	}

	public AlumnoDireccion getAlumnoDireccion() {
		return alumnoDireccion;
	}

	public void setAlumnoDireccion(AlumnoDireccion alumnoDireccion) {
		this.alumnoDireccion = alumnoDireccion;
	}

}
