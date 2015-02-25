package es.opensigad.controller;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.AlumnoTutor;


@ManagedBean
@SessionScoped
public class InsertarTutorBean implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	
	private int idAlumno;
	private int idTutor;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String tipoDocumento;
	private String documento;
	private Date fechaNac;
	private String parentesco;
	private String sexo;
	private String tlf;
	private String email;
	
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public Date getFechaNac() {
		
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		
		this.fechaNac = fechaNac;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String insertarTutor() {
		
		String pagina = null;
		
		TutorDAO tutorDAO = new TutorDAO();
		
		if(tutorDAO.insertarTutor(1, nombre, apellido1, apellido2, tipoDocumento, documento, fechaNac, parentesco, sexo, tlf, email))
			pagina = "insertarTutorExito.xhtml";
		else
			pagina = "insertarTutorFallo.xhtml";
		
		
		return pagina;
		
	}
	
	public String getListaAlumnoTutor() {
		
		TutorDAO tutorDAO = new TutorDAO();
		String pagina= "tutoresPorAlumno.xhtml";
		
		List<AlumnoTutor> lista= tutorDAO.getListaAlumnoTutor(idAlumno);
		
		return pagina;
		
	}
		 
}
