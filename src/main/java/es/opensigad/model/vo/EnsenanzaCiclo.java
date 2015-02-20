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
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int ciclo;

	//bi-directional many-to-one association to Ensenanza
	@ManyToOne
	@JoinColumn(name="id_ensenanza", nullable=false)
	private Ensenanza ensenanza;

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

	public Ensenanza getEnsenanza() {
		return this.ensenanza;
	}

	public void setEnsenanza(Ensenanza ensenanza) {
		this.ensenanza = ensenanza;
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