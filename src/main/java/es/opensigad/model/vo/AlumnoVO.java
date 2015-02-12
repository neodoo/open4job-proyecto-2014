package es.opensigad.model.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AlumnoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idAlumno;
	private int numExpediente;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private String dni;
	private String telefono;
	private Date fechaNacimiento;
	private String pais;
	private String provincia;
	private String localidad;
	private String domicilio;
	private String email;

	public AlumnoVO() {
		super();
	}

	public AlumnoVO(int idAlumno, int numExpediente, String nombre, String apellido1,
			String apellido2, String sexo, String dni, String telefono,
			Date fechaNacimiento, String pais, String provincia,
			String localidad, String domicilio, String email) {

		this.idAlumno = idAlumno;
		this.numExpediente = numExpediente;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.domicilio = domicilio;
		this.email = email;
	}

	/**
	 * Imprime el detalle del alumno
	 */
	public String toString() {
		return ("AlumnoDAO[ id = " + idAlumno + " num_expediente = " + numExpediente
				+ " nombre = " + nombre + " apellido1 = " + apellido1
				+ " apellido2 = " + apellido2 + " sexo= " + sexo + " dni = "
				+ dni + " telefono = " + telefono + " fecha_nacimiento = "
				+ fechaNacimiento + " pais = " + pais + " provincia = "
				+ provincia + " localidad = " + localidad)
				+ " domicilio = " + domicilio + " email = " + email + " ]";
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
