package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alumno_nota database table.
 * 
 */
@Entity
@Table(name="alumno_nota")
@NamedQuery(name="AlumnoNota.findAll", query="SELECT a FROM AlumnoNota a")
public class AlumnoNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=1)
	private String evaluacion;

	private int nota;

	@Column(length=255)
	private String observacion;

	//bi-directional many-to-one association to EnsenanzaMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	private EnsenanzaMateria ensenanzaMateria;

	//bi-directional many-to-one association to AlumnoMatricula
	@ManyToOne
	@JoinColumn(name="id_alumno_matricula")
	private AlumnoMatricula alumnoMatricula;

	public AlumnoNota() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public int getNota() {
		return this.nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public EnsenanzaMateria getEnsenanzaMateria() {
		return this.ensenanzaMateria;
	}

	public void setEnsenanzaMateria(EnsenanzaMateria ensenanzaMateria) {
		this.ensenanzaMateria = ensenanzaMateria;
	}

	public AlumnoMatricula getAlumnoMatricula() {
		return this.alumnoMatricula;
	}

	public void setAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		this.alumnoMatricula = alumnoMatricula;
	}

}