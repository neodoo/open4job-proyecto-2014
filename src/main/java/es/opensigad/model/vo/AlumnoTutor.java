package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alumno_tutor database table.
 * 
 */
@Entity
@Table(name="alumno_tutor")
@NamedQuery(name="AlumnoTutor.findAll", query="SELECT a FROM AlumnoTutor a")
public class AlumnoTutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String parentesco;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="id_alumno", nullable=false)
	private Alumno alumno;

	//bi-directional many-to-one association to Tutor
	@ManyToOne
	@JoinColumn(name="id_tutor", nullable=false)
	private Tutor tutor;

	public AlumnoTutor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

}