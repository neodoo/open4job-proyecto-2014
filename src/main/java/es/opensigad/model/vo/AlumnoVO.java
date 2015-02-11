package es.opensigad.model.vo;

import java.sql.Date;

public class AlumnoVO {

	private int id;
	private int num_expediente;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private String dni;
	private String telefono;
	private Date fecha_acimiento;
	private String pais;
	private String provincia;
	private String localidad;
	private String domicilio;
	private String email;

	public AlumnoVO() {
		super();
	}

	public AlumnoVO(int id, int num_expediente, String nombre,
			String apellido1, String apellido2, String sexo, String dni,
			String telefono, Date fecha_nacimiento, String pais,
			String provincia, String localidad, String domicilio, String email) {

		this.id = id;
		this.num_expediente = num_expediente;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.dni = dni;
		this.telefono = telefono;
		this.fecha_acimiento = fecha_nacimiento;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.domicilio = domicilio;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum_expediente() {
		return num_expediente;
	}

	public void setNum_expediente(int num_expediente) {
		this.num_expediente = num_expediente;
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

	public Date getFecha_acimiento() {
		return fecha_acimiento;
	}

	public void setFecha_acimiento(Date fecha_acimiento) {
		this.fecha_acimiento = fecha_acimiento;
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

	public String toString() {
		return ("AlumnoDAO[ id = " + id + " num_expediente = " + num_expediente);
	}
}
