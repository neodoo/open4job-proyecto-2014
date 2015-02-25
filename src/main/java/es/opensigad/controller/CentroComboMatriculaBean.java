package es.opensigad.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import es.opensigad.model.dao.AlumnoMatriculaDAO;
import es.opensigad.model.vo.Centro;

@ManagedBean
@ApplicationScoped
public class CentroComboMatriculaBean implements Serializable{

	private static final long serialVersionUID = -2851132432891443585L;
	
	private ArrayList<SelectItem> centroItem = null;

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
	
}
