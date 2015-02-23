package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumno_matricula database table.
 * 
 */
@Entity
@Table(name="alumno_matricula")
@NamedQuery(name="AlumnoMatricula.findAll", query="SELECT a FROM AlumnoMatricula a")
public class AlumnoMatricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int curso;

	@Column(name="curso_escolar")
	private int cursoEscolar;

	private String modulo;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="id_alumno")
	private Alumno alumno;

	//bi-directional many-to-one association to Centro
	@ManyToOne
	@JoinColumn(name="id_centro")
	private Centro centro;

	//bi-directional many-to-one association to Ensenanza
	@ManyToOne
	@JoinColumn(name="id_ensenanza")
	private Ensenanza ensenanza;

	//bi-directional many-to-one association to AlumnoNota
	@OneToMany(mappedBy="alumnoMatricula")
	private List<AlumnoNota> alumnoNotas;

	//bi-directional many-to-one association to AlumnoSeguimiento
	@OneToMany(mappedBy="alumnoMatricula")
	private List<AlumnoSeguimiento> alumnoSeguimientos;

	public AlumnoMatricula() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurso() {
		return this.curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getCursoEscolar() {
		return this.cursoEscolar;
	}

	public void setCursoEscolar(int cursoEscolar) {
		this.cursoEscolar = cursoEscolar;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Centro getCentro() {
		return this.centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public Ensenanza getEnsenanza() {
		return this.ensenanza;
	}

	public void setEnsenanza(Ensenanza ensenanza) {
		this.ensenanza = ensenanza;
	}

	public List<AlumnoNota> getAlumnoNotas() {
		return this.alumnoNotas;
	}

	public void setAlumnoNotas(List<AlumnoNota> alumnoNotas) {
		this.alumnoNotas = alumnoNotas;
	}

	public AlumnoNota addAlumnoNota(AlumnoNota alumnoNota) {
		getAlumnoNotas().add(alumnoNota);
		alumnoNota.setAlumnoMatricula(this);

		return alumnoNota;
	}

	public AlumnoNota removeAlumnoNota(AlumnoNota alumnoNota) {
		getAlumnoNotas().remove(alumnoNota);
		alumnoNota.setAlumnoMatricula(null);

		return alumnoNota;
	}

	public List<AlumnoSeguimiento> getAlumnoSeguimientos() {
		return this.alumnoSeguimientos;
	}

	public void setAlumnoSeguimientos(List<AlumnoSeguimiento> alumnoSeguimientos) {
		this.alumnoSeguimientos = alumnoSeguimientos;
	}

	public AlumnoSeguimiento addAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {
		getAlumnoSeguimientos().add(alumnoSeguimiento);
		alumnoSeguimiento.setAlumnoMatricula(this);

		return alumnoSeguimiento;
	}

	public AlumnoSeguimiento removeAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {
		getAlumnoSeguimientos().remove(alumnoSeguimiento);
		alumnoSeguimiento.setAlumnoMatricula(null);

		return alumnoSeguimiento;
	}

}