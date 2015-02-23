package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alumno database table.
 * 
 */
@Entity
@Table(name="alumno")
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido1;

	private String apellido2;

	private String documento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String imagen;

	@Column(name="localidad_nacimiento")
	private String localidadNacimiento;

	private String nombre;

	@Column(name="num_expediente")
	private int numExpediente;

	private String sexo;

	@Column(name="tipo_documento")
	private String tipoDocumento;

	//bi-directional many-to-one association to Territorio
	@ManyToOne
	@JoinColumn(name="provincia_nacimiento")
	private Territorio territorio1;

	//bi-directional many-to-one association to Territorio
	@ManyToOne
	@JoinColumn(name="pais_nacimiento")
	private Territorio territorio2;

	//bi-directional many-to-one association to AlumnoContacto
	@OneToMany(mappedBy="alumno")
	private List<AlumnoContacto> alumnoContactos;

	//bi-directional many-to-one association to AlumnoDireccion
	@OneToMany(mappedBy="alumno")
	private List<AlumnoDireccion> alumnoDireccions;

	//bi-directional many-to-one association to AlumnoMatricula
	@OneToMany(mappedBy="alumno")
	private List<AlumnoMatricula> alumnoMatriculas;

	//bi-directional many-to-one association to AlumnoTutor
	@OneToMany(mappedBy="alumno")
	private List<AlumnoTutor> alumnoTutors;

	public Alumno() {
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLocalidadNacimiento() {
		return this.localidadNacimiento;
	}

	public void setLocalidadNacimiento(String localidadNacimiento) {
		this.localidadNacimiento = localidadNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumExpediente() {
		return this.numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public List<AlumnoContacto> getAlumnoContactos() {
		return this.alumnoContactos;
	}

	public void setAlumnoContactos(List<AlumnoContacto> alumnoContactos) {
		this.alumnoContactos = alumnoContactos;
	}

	public AlumnoContacto addAlumnoContacto(AlumnoContacto alumnoContacto) {
		getAlumnoContactos().add(alumnoContacto);
		alumnoContacto.setAlumno(this);

		return alumnoContacto;
	}

	public AlumnoContacto removeAlumnoContacto(AlumnoContacto alumnoContacto) {
		getAlumnoContactos().remove(alumnoContacto);
		alumnoContacto.setAlumno(null);

		return alumnoContacto;
	}

	public List<AlumnoDireccion> getAlumnoDireccions() {
		return this.alumnoDireccions;
	}

	public void setAlumnoDireccions(List<AlumnoDireccion> alumnoDireccions) {
		this.alumnoDireccions = alumnoDireccions;
	}

	public AlumnoDireccion addAlumnoDireccion(AlumnoDireccion alumnoDireccion) {
		getAlumnoDireccions().add(alumnoDireccion);
		alumnoDireccion.setAlumno(this);

		return alumnoDireccion;
	}

	public AlumnoDireccion removeAlumnoDireccion(AlumnoDireccion alumnoDireccion) {
		getAlumnoDireccions().remove(alumnoDireccion);
		alumnoDireccion.setAlumno(null);

		return alumnoDireccion;
	}

	public List<AlumnoMatricula> getAlumnoMatriculas() {
		return this.alumnoMatriculas;
	}

	public void setAlumnoMatriculas(List<AlumnoMatricula> alumnoMatriculas) {
		this.alumnoMatriculas = alumnoMatriculas;
	}

	public AlumnoMatricula addAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		getAlumnoMatriculas().add(alumnoMatricula);
		alumnoMatricula.setAlumno(this);

		return alumnoMatricula;
	}

	public AlumnoMatricula removeAlumnoMatricula(AlumnoMatricula alumnoMatricula) {
		getAlumnoMatriculas().remove(alumnoMatricula);
		alumnoMatricula.setAlumno(null);

		return alumnoMatricula;
	}

	public List<AlumnoTutor> getAlumnoTutors() {
		return this.alumnoTutors;
	}

	public void setAlumnoTutors(List<AlumnoTutor> alumnoTutors) {
		this.alumnoTutors = alumnoTutors;
	}

	public AlumnoTutor addAlumnoTutor(AlumnoTutor alumnoTutor) {
		getAlumnoTutors().add(alumnoTutor);
		alumnoTutor.setAlumno(this);

		return alumnoTutor;
	}

	public AlumnoTutor removeAlumnoTutor(AlumnoTutor alumnoTutor) {
		getAlumnoTutors().remove(alumnoTutor);
		alumnoTutor.setAlumno(null);

		return alumnoTutor;
	}

}