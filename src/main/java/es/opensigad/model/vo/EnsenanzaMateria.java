package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ensenanza_materia database table.
 * 
 */
@Entity
@Table(name="ensenanza_materia")
@NamedQuery(name="EnsenanzaMateria.findAll", query="SELECT e FROM EnsenanzaMateria e")
public class EnsenanzaMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="horas_semanal")
	private int horasSemanal;

	@Column(name="horas_total")
	private int horasTotal;

	private String materia;

	//bi-directional many-to-one association to AlumnoNota
	@OneToMany(mappedBy="ensenanzaMateria")
	private List<AlumnoNota> alumnoNotas;

	//bi-directional many-to-one association to AlumnoSeguimiento
	@OneToMany(mappedBy="ensenanzaMateria")
	private List<AlumnoSeguimiento> alumnoSeguimientos;

	//bi-directional many-to-one association to EnsenanzaCurso
	@ManyToOne
	@JoinColumn(name="id_ensenanza_curso")
	private EnsenanzaCurso ensenanzaCurso;

	public EnsenanzaMateria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorasSemanal() {
		return this.horasSemanal;
	}

	public void setHorasSemanal(int horasSemanal) {
		this.horasSemanal = horasSemanal;
	}

	public int getHorasTotal() {
		return this.horasTotal;
	}

	public void setHorasTotal(int horasTotal) {
		this.horasTotal = horasTotal;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public List<AlumnoNota> getAlumnoNotas() {
		return this.alumnoNotas;
	}

	public void setAlumnoNotas(List<AlumnoNota> alumnoNotas) {
		this.alumnoNotas = alumnoNotas;
	}

	public AlumnoNota addAlumnoNota(AlumnoNota alumnoNota) {
		getAlumnoNotas().add(alumnoNota);
		alumnoNota.setEnsenanzaMateria(this);

		return alumnoNota;
	}

	public AlumnoNota removeAlumnoNota(AlumnoNota alumnoNota) {
		getAlumnoNotas().remove(alumnoNota);
		alumnoNota.setEnsenanzaMateria(null);

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
		alumnoSeguimiento.setEnsenanzaMateria(this);

		return alumnoSeguimiento;
	}

	public AlumnoSeguimiento removeAlumnoSeguimiento(AlumnoSeguimiento alumnoSeguimiento) {
		getAlumnoSeguimientos().remove(alumnoSeguimiento);
		alumnoSeguimiento.setEnsenanzaMateria(null);

		return alumnoSeguimiento;
	}

	public EnsenanzaCurso getEnsenanzaCurso() {
		return this.ensenanzaCurso;
	}

	public void setEnsenanzaCurso(EnsenanzaCurso ensenanzaCurso) {
		this.ensenanzaCurso = ensenanzaCurso;
	}

}