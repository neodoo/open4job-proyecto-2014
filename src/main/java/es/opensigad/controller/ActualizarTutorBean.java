package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.dao.TutorDAOInterface;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class ActualizarTutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private TutorDAOInterface tutorDAOInterface = null;
	
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

	@ManagedProperty(value = "#{sesionBean}")
	private SesionBean sesionBean;
	

	public TutorDAOInterface getTutorDAOInterface() {
		return tutorDAOInterface;
	}

	public void setTutorDAOInterface(TutorDAOInterface tutorDAOInterface) {
		this.tutorDAOInterface = tutorDAOInterface;
	}
	
	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public SesionBean getSesionBean() {
		return sesionBean;
	}

	public void setSesionBean(SesionBean sesionBean) {
		this.sesionBean = sesionBean;
	}
	
	public String actualizarTutor(int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, Date fechaNac, String parentesco, String sexo,
			String tlf, String email) {
		String pagina = null;
		
		if (tutorDAOInterface.updateTutor(sesionBean.getIdAlumno(), idTutor, nombre, apellido1,
				apellido2, tipoDocumento, documento, fechaNac, parentesco,
				sexo, tlf, email))
			pagina = "actualizarTutorExito.xhtml";
		else
			pagina = "actualizarTutorFallo.xhtml";

		return pagina;
	}
}
