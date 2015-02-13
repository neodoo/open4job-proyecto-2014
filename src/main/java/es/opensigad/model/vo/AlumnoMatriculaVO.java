package es.opensigad.model.vo;

import java.sql.Date;

public class AlumnoMatriculaVO {
	
	private int id;
	private String fechaCurso;
	private String centro;
	private String tipoEnsenanza;
	private String ensenanza;
	private String curso;
	private int idAlumno;
	
	public AlumnoMatriculaVO(int id,String fechaCurso,String centro,String tipoEnsenanza, String ensenanza,
			String curso,int idAlumno){
		
		this.id=id;
		this.fechaCurso=fechaCurso;
		this.centro=centro;
		this.tipoEnsenanza=tipoEnsenanza;
		this.ensenanza=ensenanza;
		this.curso=curso;
		this.idAlumno=idAlumno;
		
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaCurso() {
		return fechaCurso;
	}

	public void setFechaCurso(String fechaCurso) {
		this.fechaCurso = fechaCurso;
	}

	public String getTipoEnsenanza() {
		return tipoEnsenanza;
	}

	public void setTipoEnsenanza(String tipoEnsenanza) {
		this.tipoEnsenanza = tipoEnsenanza;
	}

	public String getEnsenanza() {
		return ensenanza;
	}

	public void setEnsenanza(String ensenanza) {
		this.ensenanza = ensenanza;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Override
	public String toString() {
		return "MatriculaVO [id=" + id + ", fechaCurso=" + fechaCurso
				+ ", centro=" + centro + ", tipoEnsenanza=" + tipoEnsenanza
				+ ", ensenanza=" + ensenanza + ", curso=" + curso
				+ ", idAlumno=" + idAlumno + "]";
	}

}
