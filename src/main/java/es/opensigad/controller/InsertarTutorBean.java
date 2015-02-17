package es.opensigad.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.TutorVO;

@ManagedBean
@SessionScoped
public class InsertarTutorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TutorVO tutorVO;
	
	private int idTutor;
	private int idAlumno;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String DNI;
	private Date fechaNac;
	private String parentesco;
	private String tlf;
	private String email;

	
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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
		
		String pagina;
		
		TutorDAO tutorDAO = new TutorDAO();
		if(tutorDAO.insertarTutor(idAlumno,nombre, apellido1,apellido2, DNI, fechaNac, parentesco, tlf, email))
			pagina= "insertarTutorExito.xhtml";
		else
			pagina= "insertarTutorFallo.xhtml";
		
		return pagina;
		
	}
	
	/*
	
	public String getlistaTutor()
	{
		TutorDAO tutorDAO = new TutorDAO();
		String pagina= "tutoresPorAlumno.xhtml";
		
		List<TutorVO> lista= tutorDAO.getlistaTutor();
		
		return pagina;
		
	}
	
	*/
}
