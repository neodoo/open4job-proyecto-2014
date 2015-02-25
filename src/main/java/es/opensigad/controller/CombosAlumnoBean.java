package es.opensigad.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.vo.EnsenanzaMateria;

@ManagedBean
@ApplicationScoped
public class CombosAlumnoBean {
	
	public List<EnsenanzaMateria> listEnsenanzaMateria = null;
	
	public List<EnsenanzaMateria> getDataListEnsenanzaMateria(){
		
		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		listEnsenanzaMateria = alumnoNotaDAO.listMateriaCombo();
	
		return listEnsenanzaMateria;
		
	}
	
	public List<EnsenanzaMateria> getListEnsenanzaMateria() {

		if (listEnsenanzaMateria == null)
			listEnsenanzaMateria = this.getDataListEnsenanzaMateria();
		
		return listEnsenanzaMateria;
		
	}
	
}
