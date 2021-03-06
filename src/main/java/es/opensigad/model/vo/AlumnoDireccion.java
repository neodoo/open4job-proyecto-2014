package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alumno_direccion database table.
 * 
 */
@Entity
@Table(name="alumno_direccion")
@NamedQuery(name="AlumnoDireccion.findAll", query="SELECT a FROM AlumnoDireccion a")
public class AlumnoDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="codigo_postal")
	private int codigoPostal;

	private String domicilio;

	private String localidad;

	private int principal;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="id_alumno")
	private Alumno alumno;

	//bi-directional many-to-one association to Territorio
	@ManyToOne
	@JoinColumn(name="provincia")
	private Territorio territorio1;

	//bi-directional many-to-one association to Territorio
	@ManyToOne
	@JoinColumn(name="pais")
	private Territorio territorio2;

	public AlumnoDireccion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(int principal) {
		this.principal = principal;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Territorio getTerritorio1() {
		return this.territorio1;
	}

	public void setTerritorio1(Territorio territorio1) {
		this.territorio1 = territorio1;
	}

	public Territorio getTerritorio2() {
		return this.territorio2;
	}

	public void setTerritorio2(Territorio territorio2) {
		this.territorio2 = territorio2;
	}

}