package es.opensigad.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import es.opensigad.model.dao.AlumnoSeguimientoDAOInterfaz;

@Singleton
@LocalBean
//@Startup
public class ScheduleTimerBeanSeguimiento {

	@Resource
	private TimerService timerService;

	@EJB
	AlumnoSeguimientoDAOInterfaz alumnoSeguimientoDAOInterfaz;
	
	//@Schedule(second = "*/10", minute = "*", hour = "*")
	public void execute(Timer timer) {
		
		//System.out.println("Executing ...");
		//System.out.println("Execution Time : " + new Date());
		//System.out.println("____________________________________________");
		
		alumnoSeguimientoDAOInterfaz.getListaAlumnoSeguimiento(6);
		//System.out.println(alumnoSeguimientoDAOInterfaz.getListaAlumnoSeguimiento(1).size());
		
	}
	
}