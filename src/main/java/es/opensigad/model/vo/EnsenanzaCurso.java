package es.opensigad.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ensenanza_curso database table.
 * 
 */
@Entity
@Table(name="ensenanza_curso")
@NamedQuery(name="EnsenanzaCurso.findAll", query="SELECT e FROM EnsenanzaCurso e")
public class EnsenanzaCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int curso;

	//bi-directional many-to-one association to EnsenanzaCiclo
	@ManyToOne
	@JoinColumn(name="id_ensenanza_ciclo")
	private EnsenanzaCiclo ensenanzaCiclo;

	//bi-directional many-to-one association to EnsenanzaMateria
	@OneToMany(mappedBy="ensenanzaCurso")
	private List<EnsenanzaMateria> ensenanzaMaterias;

	public EnsenanzaCurso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurso() {
		return this.curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public EnsenanzaCiclo getEnsenanzaCiclo() {
		return this.ensenanzaCiclo;
	}

	public void setEnsenanzaCiclo(EnsenanzaCiclo ensenanzaCiclo) {
		this.ensenanzaCiclo = ensenanzaCiclo;
	}

	public List<EnsenanzaMateria> getEnsenanzaMaterias() {
		return this.ensenanzaMaterias;
	}

	public void setEnsenanzaMaterias(List<EnsenanzaMateria> ensenanzaMaterias) {
		this.ensenanzaMaterias = ensenanzaMaterias;
	}

	public EnsenanzaMateria addEnsenanzaMateria(EnsenanzaMateria ensenanzaMateria) {
		getEnsenanzaMaterias().add(ensenanzaMateria);
		ensenanzaMateria.setEnsenanzaCurso(this);

		return ensenanzaMateria;
	}

	public EnsenanzaMateria removeEnsenanzaMateria(EnsenanzaMateria ensenanzaMateria) {
		getEnsenanzaMaterias().remove(ensenanzaMateria);
		ensenanzaMateria.setEnsenanzaCurso(null);

		return ensenanzaMateria;
	}

}