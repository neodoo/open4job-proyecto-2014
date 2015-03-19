package es.opensigad.model.dao;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.opensigad.model.vo.AlumnoNota;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

@Singleton
@LocalBean
@Startup
public class AlumnoNotaSchelude {
	@Resource
	private TimerService timerService;
	@EJB
	AlumnoNotaDAOInterfaz AlumnoNotaDAOInterfaz;
	@Schedule(second = "59", minute = "*", hour = "*")
	public void execute(Timer timer) {
		/*List<AlumnoNota> alumnos = null;
		alumnos = AlumnoNotaDAOInterfaz.getNotasByIdMatricula(3);*/
		

		//System.out.println(alumnos); //Prueba de visualizar datos. No es necesario mostrar las variables.
		System.out.println("Executing ...");
		System.out.println("Execution Time : " + new Date());
		System.out.println("____________________________________________");

	}
}
