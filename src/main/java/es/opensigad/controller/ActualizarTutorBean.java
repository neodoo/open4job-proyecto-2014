package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@SessionScoped
public class ActualizarTutorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String[] seleccionados;
	
	
	public String[] getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(String[] seleccionados) {
		this.seleccionados = seleccionados;
	}

	
	public String actualizarTutor()
	{
		String pagina= "actualizarTutor.xhtml";
		TutorDAO tutorDAO= new TutorDAO();
		
		return pagina;
	}
}
