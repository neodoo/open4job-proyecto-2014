package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the territorio database table.
 * 
 */
@Entity
@Table(name="territorio")
@NamedQuery(name="Territorio.findAll", query="SELECT t FROM Territorio t")
public class Territorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String codigo;

	private String descripcion;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="territorio1")
	private List<Alumno> alumnos1;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="territorio2")
	private List<Alumno> alumnos2;

	//bi-directional many-to-one association to AlumnoDireccion
	@OneToMany(mappedBy="territorio1")
	private List<AlumnoDireccion> alumnoDireccions1;

	//bi-directional many-to-one association to AlumnoDireccion
	@OneToMany(mappedBy="territorio2")
	private List<AlumnoDireccion> alumnoDireccions2;

	public Territorio() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Alumno> getAlumnos1() {
		return this.alumnos1;
	}

	public void setAlumnos1(List<Alumno> alumnos1) {
		this.alumnos1 = alumnos1;
	}

	public Alumno addAlumnos1(Alumno alumnos1) {
		getAlumnos1().add(alumnos1);
		alumnos1.setTerritorio1(this);

		return alumnos1;
	}

	public Alumno removeAlumnos1(Alumno alumnos1) {
		getAlumnos1().remove(alumnos1);
		alumnos1.setTerritorio1(null);

		return alumnos1;
	}

	public List<Alumno> getAlumnos2() {
		return this.alumnos2;
	}

	public void setAlumnos2(List<Alumno> alumnos2) {
		this.alumnos2 = alumnos2;
	}

	public Alumno addAlumnos2(Alumno alumnos2) {
		getAlumnos2().add(alumnos2);
		alumnos2.setTerritorio2(this);

		return alumnos2;
	}

	public Alumno removeAlumnos2(Alumno alumnos2) {
		getAlumnos2().remove(alumnos2);
		alumnos2.setTerritorio2(null);

		return alumnos2;
	}

	public List<AlumnoDireccion> getAlumnoDireccions1() {
		return this.alumnoDireccions1;
	}

	public void setAlumnoDireccions1(List<AlumnoDireccion> alumnoDireccions1) {
		this.alumnoDireccions1 = alumnoDireccions1;
	}

	public AlumnoDireccion addAlumnoDireccions1(AlumnoDireccion alumnoDireccions1) {
		getAlumnoDireccions1().add(alumnoDireccions1);
		alumnoDireccions1.setTerritorio1(this);

		return alumnoDireccions1;
	}

	public AlumnoDireccion removeAlumnoDireccions1(AlumnoDireccion alumnoDireccions1) {
		getAlumnoDireccions1().remove(alumnoDireccions1);
		alumnoDireccions1.setTerritorio1(null);

		return alumnoDireccions1;
	}

	public List<AlumnoDireccion> getAlumnoDireccions2() {
		return this.alumnoDireccions2;
	}

	public void setAlumnoDireccions2(List<AlumnoDireccion> alumnoDireccions2) {
		this.alumnoDireccions2 = alumnoDireccions2;
	}

	public AlumnoDireccion addAlumnoDireccions2(AlumnoDireccion alumnoDireccions2) {
		getAlumnoDireccions2().add(alumnoDireccions2);
		alumnoDireccions2.setTerritorio2(this);

		return alumnoDireccions2;
	}

	public AlumnoDireccion removeAlumnoDireccions2(AlumnoDireccion alumnoDireccions2) {
		getAlumnoDireccions2().remove(alumnoDireccions2);
		alumnoDireccions2.setTerritorio2(null);

		return alumnoDireccions2;
	}

}