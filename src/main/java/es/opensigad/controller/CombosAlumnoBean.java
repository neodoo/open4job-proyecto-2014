package es.opensigad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import es.opensigad.model.dao.AlumnoDAOInterfaz;
import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;
import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.EnsenanzaMateria;
import es.opensigad.model.vo.Territorio;
import es.opensigad.model.vo.Tutor;

@ManagedBean
@ApplicationScoped
public class CombosAlumnoBean {
	
	@EJB
	private AlumnoDAOInterfaz alumnoDAO = null;

	@EJB
	private AlumnoNotaDAOInterfaz alumnoNotaDAO=null;
	
	public List<EnsenanzaMateria> listEnsenanzaMateria = null;
	public List<Alumno> listAlumnos = null;
	public List<Tutor> listTutor = null;
	public List<AlumnoTutor> listAlumnoTutor = null;

	private ArrayList<SelectItem> paisItem = null;

	private ArrayList<SelectItem> provinciaItem = null;


	public List<EnsenanzaMateria> getDataListEnsenanzaMateria() {

		listEnsenanzaMateria = alumnoNotaDAO.listMateriaCombo();

		return listEnsenanzaMateria;

	}

	public List<EnsenanzaMateria> getListEnsenanzaMateria() {

		if (listEnsenanzaMateria == null)
			listEnsenanzaMateria = this.getDataListEnsenanzaMateria();

		return listEnsenanzaMateria;

	}

	public List<Alumno> getDataListAlumnos() {
		listAlumnos = alumnoDAO.getListAlumno();
		return listAlumnos;
	}

	public List<Alumno> getListAlumnos() {
		if (listAlumnos == null) {
			listAlumnos = this.getDataListAlumnos();
		}
		return listAlumnos;
	}
	
	public List<AlumnoTutor> getDataListAlumnoTutor(){
		TutorDAO tutorDAO = new TutorDAO();
		listAlumnoTutor = null; //TODO tutorDAO.getListaAlumnoTutor();
		return listAlumnoTutor;
	}

	public List<AlumnoTutor> getListAlumnoTutor(){
		if (listAlumnoTutor == null){
			listAlumnoTutor = this.getDataListAlumnoTutor();
		}
		return listAlumnoTutor;
	}
	

	public ArrayList<SelectItem> getDataComboPais() {

		this.paisItem = new ArrayList();

		ArrayList<Territorio> paisList = (ArrayList<Territorio>) alumnoDAO
				.getListPais();

		for (Territorio t : paisList) {
			paisItem.add(new SelectItem(t.getCodigo(), t.getDescripcion()));
		}

		return paisItem;
	}

	public ArrayList<SelectItem> getDataComboProvincia() {

		this.provinciaItem = new ArrayList();

		ArrayList<Territorio> provinciaList = (ArrayList<Territorio>) alumnoDAO
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
	
	public List<Tutor> getDataListTutores() {
		TutorDAO tutorDAO = new TutorDAO();
		listTutor = null; //TODO tutorDAO.getListaTutor();
		return listTutor;
	}

	public List<Tutor> getListTutores() {
		if (listTutor == null) {
			listTutor = this.getDataListTutores();
		}
		return listTutor;
	}
	
}
