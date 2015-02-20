package es.opensigad.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.vo.AlumnoNota;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@RequestScoped
public class VerAlumnoNotaListadoBean implements Serializable {
	
	private ArrayList<AlumnoNota> alumnoNotas;
	private int idMatricula;

	public VerAlumnoNotaListadoBean() {
		getAllAlumnoNotas();
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public ArrayList<AlumnoNota> getAlumnoNotas() {
		return alumnoNotas;
	}

	public void setAlumnoNotas(ArrayList<AlumnoNota> alumnNOtas) {
		this.alumnoNotas = alumnNOtas;
	}

	public String getDetalleNotasAlumno(int idMatricula) {
		String pagina= "verAlumnoNotaListado";
		AlumnoNotaDAO notasAlumnoDAO = new AlumnoNotaDAO();
		alumnoNotas = notasAlumnoDAO.getNotasByIdMatricula(idMatricula);
		return pagina;
	}
	public void getAllAlumnoNotas() {
        AlumnoNotaDAO alumnoNotaDao = new AlumnoNotaDAO();
        alumnoNotas = alumnoNotaDao.getAllAlumnoNotas();
    }

}
