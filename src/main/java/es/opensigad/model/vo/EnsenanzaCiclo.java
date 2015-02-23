package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ensenanza_ciclo database table.
 * 
 */
@Entity
@Table(name="ensenanza_ciclo")
@NamedQuery(name="EnsenanzaCiclo.findAll", query="SELECT e FROM EnsenanzaCiclo e")
public class EnsenanzaCiclo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int ciclo;

	//bi-directional many-to-one association to EnsenanzaCiclo
	@ManyToOne
	@JoinColumn(name="id_ensenanza")
	private EnsenanzaCiclo ensenanzaCiclo;

	//bi-directional many-to-one association to EnsenanzaCiclo
	@OneToMany(mappedBy="ensenanzaCiclo")
	private List<EnsenanzaCiclo> ensenanzaCiclos;

	//bi-directional many-to-one association to EnsenanzaCurso
	@OneToMany(mappedBy="ensenanzaCiclo")
	private List<EnsenanzaCurso> ensenanzaCursos;

	public EnsenanzaCiclo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public EnsenanzaCiclo getEnsenanzaCiclo() {
		return this.ensenanzaCiclo;
	}

	public void setEnsenanzaCiclo(EnsenanzaCiclo ensenanzaCiclo) {
		this.ensenanzaCiclo = ensenanzaCiclo;
	}

	public List<EnsenanzaCiclo> getEnsenanzaCiclos() {
		return this.ensenanzaCiclos;
	}

	public void setEnsenanzaCiclos(List<EnsenanzaCiclo> ensenanzaCiclos) {
		this.ensenanzaCiclos = ensenanzaCiclos;
	}

	public EnsenanzaCiclo addEnsenanzaCiclo(EnsenanzaCiclo ensenanzaCiclo) {
		getEnsenanzaCiclos().add(ensenanzaCiclo);
		ensenanzaCiclo.setEnsenanzaCiclo(this);

		return ensenanzaCiclo;
	}

	public EnsenanzaCiclo removeEnsenanzaCiclo(EnsenanzaCiclo ensenanzaCiclo) {
		getEnsenanzaCiclos().remove(ensenanzaCiclo);
		ensenanzaCiclo.setEnsenanzaCiclo(null);

		return ensenanzaCiclo;
	}

	public List<EnsenanzaCurso> getEnsenanzaCursos() {
		return this.ensenanzaCursos;
	}

	public void setEnsenanzaCursos(List<EnsenanzaCurso> ensenanzaCursos) {
		this.ensenanzaCursos = ensenanzaCursos;
	}

	public EnsenanzaCurso addEnsenanzaCurso(EnsenanzaCurso ensenanzaCurso) {
		getEnsenanzaCursos().add(ensenanzaCurso);
		ensenanzaCurso.setEnsenanzaCiclo(this);

		return ensenanzaCurso;
	}

	public EnsenanzaCurso removeEnsenanzaCurso(EnsenanzaCurso ensenanzaCurso) {
		getEnsenanzaCursos().remove(ensenanzaCurso);
		ensenanzaCurso.setEnsenanzaCiclo(null);

		return ensenanzaCurso;
	}

}