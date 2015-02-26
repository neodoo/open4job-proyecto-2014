package es.opensigad.controller;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import es.opensigad.model.dao.AlumnoDAO;
import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.Alumno;
import es.opensigad.model.vo.AlumnoTutor;
import es.opensigad.model.vo.EnsenanzaMateria;

@ManagedBean
@ApplicationScoped
public class CombosAlumnoBean {

	public List<EnsenanzaMateria> listEnsenanzaMateria = null;
	public List<Alumno> listAlumnos = null;
	public List<AlumnoTutor> listAlumnoTutor = null;

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

	public List<Alumno> getDataListAlumnos() {
		AlumnoDAO alumnoDAO = new AlumnoDAO();
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
		listAlumnoTutor = tutorDAO.getListaAlumnoTutor();
		return listAlumnoTutor;
	}

	public List<AlumnoTutor> getListAlumnoTutor(){
		if (listAlumnoTutor == null){
			listAlumnoTutor = this.getDataListAlumnoTutor();
		}
		return listAlumnoTutor;
	}
}
