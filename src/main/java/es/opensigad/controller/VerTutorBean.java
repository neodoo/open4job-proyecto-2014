package es.opensigad.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import es.opensigad.model.dao.TutorDAO;
import es.opensigad.model.vo.TutorVO;

@ManagedBean
@RequestScoped
public class VerTutorBean {
	
	private int id;

	private TutorVO tutorVO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TutorVO getTutorVO() {
		return tutorVO;
	}

	public void setTutorVO(TutorVO tutorVO) {
		this.tutorVO = tutorVO;
	}

	public String getDetalleTutor(int idTutor) {

		String pagina = "verTutorFicha";

		TutorDAO tutorDAO = new TutorDAO();
		tutorVO = tutorDAO.getDetalleTutor(idTutor);

		return pagina;

	}
}
