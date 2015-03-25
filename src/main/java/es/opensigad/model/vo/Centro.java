package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the centro database table.
 * 
 */
@Entity
@Table(name="centro")
@NamedQuery(name="Centro.findAll", query="SELECT c FROM Centro c")
public class Centro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="cod_postal")
	private String codPostal;

	private String descripcion;

	private String direccion;

	private String email;

	private String localidad;

	private String pais;

	private String provincia;

	private String telefono;

	private String titulo;

	private String website;

	//bi-directional many-to-one association to AlumnoMatricula
	@OneToMany(mappedBy="centro")
	private List<AlumnoMatricula> alumnoMatriculas;

	public Centro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<AlumnoMatricula> getAlumnoMatriculas() {
		return this.alumnoMatriculas;
	}

	public void setAlumnoMatriculas(List<AlumnoMatricula> alumnoMatriculas) {
		this.alumnoMatriculas = alumnoMatriculas;
	}

	public AlumnoMatricula addAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		getAlumnoMatriculas().add(alumnoMatricula);
		alumnoMatricula.setCentro(this);

		return alumnoMatricula;
	}

	public AlumnoMatricula removeAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		getAlumnoMatriculas().remove(alumnoMatricula);
		alumnoMatricula.setCentro(null);
//sdfsfd
		return alumnoMatricula;
	}

}