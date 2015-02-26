package es.opensigad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.vo.EnsenanzaMateria;
import es.opensigad.model.vo.Territorio;

@ManagedBean
@ApplicationScoped
public class CombosAlumnoBean {

	private List<EnsenanzaMateria> listEnsenanzaMateria = null;

	private ArrayList<SelectItem> paisItem = null;

	private ArrayList<SelectItem> provinciaItem = null;

	public List<EnsenanzaMateria> getDataListEnsenanzaMateria() {

		AlumnoNotaDAO alumnoNotaDAO = new AlumnoNotaDAO();
		listEnsenanzaMateria = alumnoNotaDAO.listMateriaCombo();

		return listEnsenanzaMateria;

	}

	public List<EnsenanzaMateria> getListEnsenanzaMateria() {

		if (listEnsenanzaMateria == null)
			listEnsenanzaMateria = this.getDataListEnsenanzaMateria();

		return listEnsenanzaMateria;

	}

	public ArrayList<SelectItem> getDataComboPais() {

		this.paisItem = new ArrayList();

		AlumnoDAO alumno = new AlumnoDAO();
		ArrayList<Territorio> paisList = (ArrayList<Territorio>) alumno
				.getListPais();

		for (Territorio t : paisList) {
			paisItem.add(new SelectItem(t.getCodigo(), t.getDescripcion()));
		}

		return paisItem;
	}

	public ArrayList<SelectItem> getDataComboProvincia() {

		this.provinciaItem = new ArrayList();

		AlumnoDAO alumno = new AlumnoDAO();
		ArrayList<Territorio> provinciaList = (ArrayList<Territorio>) alumno
				.getListProvincia();

		for (Territorio t : provinciaList) {
			provinciaItem
					.add(new SelectItem(t.getCodigo(), t.getDescripcion()));
		}

		return provinciaItem;
	}

	public ArrayList<SelectItem> getPaisItem() {

		if (paisItem == null)
			paisItem = this.getDataComboPais();

		return paisItem;
	}

	public void setPaisItem(ArrayList<SelectItem> territorioItem) {
		this.paisItem = territorioItem;
	}

	public ArrayList<SelectItem> getProvinciaItem() {

		if (provinciaItem == null)
			provinciaItem = this.getDataComboProvincia();

		return provinciaItem;
	}

	public void setProvinciaItem(ArrayList<SelectItem> provinciaItem) {
		this.provinciaItem = provinciaItem;
	}

}
