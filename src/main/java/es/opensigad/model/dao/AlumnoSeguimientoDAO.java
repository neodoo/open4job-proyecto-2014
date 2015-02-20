package es.opensigad.model.dao;

import java.io.Serializable;
import java.util.List;

import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import es.opensigad.model.vo.AlumnoSeguimiento;

public class AlumnoSeguimientoDAO implements AlumnoSeguimientoDAOInterfaz, Serializable {

	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger.getLogger(AlumnoSeguimiento.class.getName());

	public DataSource ds = null;



	

	// Listar seguimientos de un alumno
	
	public List<AlumnoSeguimiento> getListaAlumnoSeguimiento(int pidMatricula) {
		
		List<AlumnoSeguimiento> seguimientos = null;
		
		try{
			 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();

		String query = "SELECT alumnoSeguimiento FROM AlumnoSeguimiento alumnoSeguimiento "
				+ " WHERE alumnoSeguimiento.alumnoMatricula.id = :pidMatricula";

		em.getTransaction().begin();

		System.out.println("<h3>Listado de seguimientos (SELECT)</h3><br />");

		seguimientos = em.createQuery(query)
				.setParameter("pidMatricula", pidMatricula).getResultList();
		for (AlumnoSeguimiento seguimientoFila : seguimientos) {

			System.out.println("<h3>AlumnoSeguimiento (id = " + seguimientoFila.getId() 
					+ ", idMatricula = " + seguimientoFila.getAlumnoMatricula().getId()
					+ ", fecha = " + seguimientoFila.getFecha() 
					+ ", sesion = " + seguimientoFila.getSesion() 
					+ ", idMateria = " + seguimientoFila.getEnsenanzaMateria().getMateria()
					+ ", tipo = " + seguimientoFila.getTipo()
					+ ", justificante = " + seguimientoFila.getJustificante()
					+ ")</h3><br />");
		}

		em.getTransaction().commit();
		em.close();
		}catch (Exception e){
		 
		}
		return seguimientos;
	
	}
	
	}
