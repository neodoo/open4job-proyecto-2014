package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ensenanza_tipo database table.
 * 
 */
@Entity
@Table(name="ensenanza_tipo")
@NamedQuery(name="EnsenanzaTipo.findAll", query="SELECT e FROM EnsenanzaTipo e")
public class EnsenanzaTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="codigo_registro")
	private String codigoRegistro;

	@Column(name="curso_escolar")
	private String cursoEscolar;

	private String nombre;

	//bi-directional many-to-one association to Ensenanza
	@OneToMany(mappedBy="ensenanzaTipo")
	private List<Ensenanza> ensenanzas;

	public EnsenanzaTipo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoRegistro() {
		return this.codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getCursoEscolar() {
		return this.cursoEscolar;
	}

	public void setCursoEscolar(String cursoEscolar) {
		this.cursoEscolar = cursoEscolar;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ensenanza> getEnsenanzas() {
		return this.ensenanzas;
	}

	public void setEnsenanzas(List<Ensenanza> ensenanzas) {
		this.ensenanzas = ensenanzas;
	}

	public Ensenanza addEnsenanza(Ensenanza ensenanza) {
		getEnsenanzas().add(ensenanza);
		ensenanza.setEnsenanzaTipo(this);

		return ensenanza;
	}

	public Ensenanza removeEnsenanza(Ensenanza ensenanza) {
		getEnsenanzas().remove(ensenanza);
		ensenanza.setEnsenanzaTipo(null);

		return ensenanza;
	}

}