package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tutor database table.
 * 
 */
@Entity
@Table(name="tutor")
@NamedQuery(name="Tutor.findAll", query="SELECT t FROM Tutor t")
public class Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String apellido1;

	@Column(length=45)
	private String apellido2;

	@Column(length=9)
	private String documento;

	@Column(length=45)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(length=45)
	private String nombre;

	@Column(length=1)
	private String sexo;

	@Column(length=15)
	private String telefono;

	@Column(name="tipo_documento", length=1)
	private String tipoDocumento;

	//bi-directional many-to-one association to AlumnoTutor
	@OneToMany(mappedBy="tutor")
	private List<AlumnoTutor> alumnoTutors;

	public Tutor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<AlumnoTutor> getAlumnoTutors() {
		return this.alumnoTutors;
	}

	public void setAlumnoTutors(List<AlumnoTutor> alumnoTutors) {
		this.alumnoTutors = alumnoTutors;
	}

	public AlumnoTutor addAlumnoTutor(AlumnoTutor alumnoTutor) {
		getAlumnoTutors().add(alumnoTutor);
		alumnoTutor.setTutor(this);

		return alumnoTutor;
	}

	public AlumnoTutor removeAlumnoTutor(AlumnoTutor alumnoTutor) {
		getAlumnoTutors().remove(alumnoTutor);
		alumnoTutor.setTutor(null);

		return alumnoTutor;
	}

}