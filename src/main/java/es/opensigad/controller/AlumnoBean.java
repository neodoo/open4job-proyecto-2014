package es.opensigad.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.dao.AlumnoDAOInterfaz;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoContacto;
import es.opensigad.model.vo.Territorio;

@ManagedBean
@RequestScoped
public class AlumnoBean implements Serializable {
	
	@EJB
	private AlumnoDAOInterfaz alumnoDAO = null;
	

	public AlumnoDAOInterfaz getAlumnoDAO() {
		return alumnoDAO;
	}

	public void setAlumnoDAO(AlumnoDAOInterfaz alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
	}

	private static final long serialVersionUID = 1L;

	private int idAlumno;

	private FacesMessage facesMessage;

	private Alumno alumno = new Alumno();

	private Territorio territorioProvincia = new Territorio();

	private Territorio territorioPais = new Territorio();
	
	private AlumnoContacto alumnoContacto = new AlumnoContacto();
	

	private List<Alumno> alumnoLista;

	private List<Alumno> alumnoFiltro;

	public AlumnoBean() {
		getListAlumno();
	}

	// MÉTODOS

	public String getDetalleAlumno() {

		String pagina = "verAlumnoFicha";
		alumno = alumnoDAO.getDetalleAlumno(this.idAlumno);

		if (alumno != null) {
			setTerritorioPais(alumno.getTerritorio2());
			setTerritorioProvincia(alumno.getTerritorio1());
			return pagina;
		}

		pagina = "indexAlumno";
		facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"El alumno con numero de expediente " + this.idAlumno
						+ " no existe", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		return pagina;

	}

	public String modifyAlumno() {

		String pagina = "indexAlumno";
		alumno.setTerritorio1(territorioProvincia);
		alumno.setTerritorio2(territorioPais);

		if (alumnoDAO.modifyAlumno(alumno))
			facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente() + " ha sido modificado",
					null);
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
		if (alumnoDAO.deleteAlumno(alumno.getId()))
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente() + " ha sido eliminado",
					null);
		else
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El alumno con numero de expediente "
							+ alumno.getNumExpediente() + " no existe", null);
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

	public String insertAlumnoContacto(){
		String pagina = "indexAlumno";
		alumnoContacto.setAlumno(alumno);
		if (alumnoDAO.insertAlumnoContacto(alumnoContacto)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El contacto del alumno con numero de expediente "
							+ alumno.getNumExpediente() + " ha sido insertado",
					null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: El contacto del alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " no se ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;
	}
	
	
	public String modifyAlumnoContacto(){
		String pagina = "indexAlumno";
		alumnoContacto.setAlumno(alumno);
		if (alumnoDAO.modifyAlumnoContacto(alumnoContacto)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El contacto del alumno con numero de expediente "
							+ alumno.getNumExpediente() + " ha sido insertado",
					null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		} else {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"ERROR: El contacto del alumno con numero de expediente "
							+ alumno.getNumExpediente()
							+ " no se ha sido insertado", null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		return pagina;
	}
	
	// GETTERS Y SETTERS

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

	public void getListAlumno() {

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		alumnoLista = alumnoDAO.getListAlumno();
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

	public AlumnoContacto getAlumnoContacto() {
		return alumnoContacto;
	}

	public void setAlumnoContacto(AlumnoContacto alumnoContacto) {
		this.alumnoContacto = alumnoContacto;
	}

	
	
}
