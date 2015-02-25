package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.Centro;
import es.opensigad.model.vo.Ensenanza;

@ManagedBean
@ApplicationScoped
public class ComboMatriculaBean implements Serializable{

	private static final long serialVersionUID = -2851132432891443585L;
	
	private ArrayList<SelectItem> centroItem = null;
	private ArrayList<SelectItem> ensenanzaItem = null;
	
	public ArrayList<SelectItem> getDataCentroItem() {

		this.centroItem = new ArrayList();
		
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		ArrayList<Centro> centroList = (ArrayList<Centro>) alumnoMatriculaDAO.getCentroList();
		
		for(Centro c:centroList){
			centroItem.add(new SelectItem(c.getId(),c.getTitulo()));
		}
		
		return centroItem;
	}

	public ArrayList<SelectItem> getCentroItem() {
	
		if (centroItem == null)
			centroItem = this.getDataCentroItem(); // Lo calculamos
		
		return centroItem;
	}

	public void setCentroItem(ArrayList<SelectItem> centroItem) {
		this.centroItem = centroItem;
	}
	
	public ArrayList<SelectItem> getDataEnsenanzaItem(){
	
		this.ensenanzaItem = new ArrayList();
		AlumnoMatriculaDAO alumnoMatriculaDAO = new AlumnoMatriculaDAO();
		ArrayList<Ensenanza> ensenanzaList = (ArrayList<Ensenanza>) alumnoMatriculaDAO.getEnsenanzaList();
		
		for(Ensenanza e:ensenanzaList){
			ensenanzaItem.add(new SelectItem(e.getId(),e.getNombre()));
		}
		
		return ensenanzaItem;
		
	} 
	
	public ArrayList<SelectItem> getEnsenanzaItem() {
		
		if (ensenanzaItem == null)
			ensenanzaItem = this.getDataEnsenanzaItem(); 
		
		return ensenanzaItem;
	}

	public void setEnsenanzaItem(ArrayList<SelectItem> ensenanzaItem) {
		this.ensenanzaItem = ensenanzaItem;
	}
	
}
