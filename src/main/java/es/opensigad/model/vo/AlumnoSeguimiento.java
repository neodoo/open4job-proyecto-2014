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
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private int justificante;

	private String observaciones;

	private String sesion;

	private String tipo;

	//bi-directional many-to-one association to AlumnoMatricula
	@ManyToOne
	@JoinColumn(name="id_matricula")
	private AlumnoMatricula alumnoMatricula;

	//bi-directional many-to-one association to EnsenanzaMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	private EnsenanzaMateria ensenanzaMateria;

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

	public AlumnoMatricula getAlumnoMatricula() {
		return this.alumnoMatricula;
	}

	public void setAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		this.alumnoMatricula = alumnoMatricula;
	}

	public EnsenanzaMateria getEnsenanzaMateria() {
		return this.ensenanzaMateria;
	}

	public void setEnsenanzaMateria(EnsenanzaMateria ensenanzaMateria) {
		this.ensenanzaMateria = ensenanzaMateria;
	}

}