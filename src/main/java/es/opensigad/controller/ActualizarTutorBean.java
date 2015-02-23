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
	
	//private TutorVO tutorVO;
	public String[] seleccionados;
	
	/*
	public ActualizarTutorBean()
	{
		seleccionados = new String[];
	}
	*/
	public String[] getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(String[] seleccionados) {
		this.seleccionados = seleccionados;
	}

	/*
	public TutorVO getTutorVO() {
		return tutorVO;
	}

	public void setTutorVO(TutorVO tutorVO) {
		this.tutorVO = tutorVO;
	}
	*/
	public String actualizarTutor()
	{
		String pagina= "actualizarTutor.xhtml";
		TutorDAO tutorDAO= new TutorDAO();
		/*
		for(int i=0; i<tutorLista.size();i++)
		{
			if(tutorLista.get(i).isSeleccionado())
			{	tutorDAO.getDetalleTutor(tutorLista.get(i).getIdTutor());
				break;
			}
		}
		*/
		return pagina;
	}
	
	public String insertarTutor() {
		
		String pagina;
		
		//TutorDAO tutorDAO = new TutorDAO();
		//if(tutorDAO.insertarTutor(tutorVO.gidAlumno,nombre, apellido1,apellido2, DNI, fechaNac, parentesco, tlf, email))
			pagina= "insertarTutorExito.xhtml";
		//else
		//	pagina= "insertarTutorFallo.xhtml";
		
		return pagina;
		
	}
	

}
