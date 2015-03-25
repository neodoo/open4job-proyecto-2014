package es.opensigad.model.vo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the alumno_contacto database table.
 * 
 */
@Entity
@Table(name="alumno_contacto")
@NamedQuery(name="AlumnoContacto.findAll", query="SELECT a FROM AlumnoContacto a")
public class AlumnoContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String contacto;

	private int principal;

	@Column(name="tipo", columnDefinition="enum('telefono','email')")
	private String tipo;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="id_alumno")
	private Alumno alumno;

	public AlumnoContacto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public int getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(int principal) {
		this.principal = principal;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}