package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alumno_seguimiento database table.
 * 
 */
@Entity
@Table(name="alumno_seguimiento")
@NamedQuery(name="AlumnoSeguimiento.findAll", query="SELECT a FROM AlumnoSeguimiento a")
public class AlumnoSeguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	private int justificante;

	@Column(length=255)
	private String observaciones;

	@Column(length=45)
	private String sesion;

	@Column(nullable=false, length=1)
	private String tipo;

	//bi-directional many-to-one association to EnsenanzaMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	private EnsenanzaMateria ensenanzaMateria;

	//bi-directional many-to-one association to AlumnoMatricula
	@ManyToOne
	@JoinColumn(name="id_matricula", nullable=false)
	private AlumnoMatricula alumnoMatricula;

	public AlumnoSeguimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getJustificante() {
		return this.justificante;
	}

	public void setJustificante(int justificante) {
		this.justificante = justificante;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getSesion() {
		return this.sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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