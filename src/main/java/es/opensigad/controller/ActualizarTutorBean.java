package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class ActualizarTutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Alumno alumno = new Alumno();
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

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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

	public String actualizarTutor(int idAlumno, int idTutor, String nombre,
			String apellido1, String apellido2, String tipoDocumento,
			String documento, Date fechaNac, String parentesco, String sexo,
			String tlf, String email) {
		String pagina = null;
		TutorDAO tutorDAO = new TutorDAO();

		if (tutorDAO.updateTutor(idAlumno, idTutor, nombre, apellido1,
				apellido2, tipoDocumento, documento, fechaNac, parentesco,
				sexo, tlf, email))
			pagina = "actualizarTutorExito.xhtml";
		else
			pagina = "actualizarTutorFallo.xhtml";

		return pagina;
	}
}
