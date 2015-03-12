package es.opensigad.model.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import es.opensigad.model.dao.AlumnoSeguimientoDAOInterfaz;
import es.opensigad.model.dao.AlumnoSeguimientoDAO;
import es.opensigad.model.vo.AlumnoSeguimiento;

 
public class AlumnoSeguimientoClient {

	   public static void main(String[] args) {
/*		   
	        AlumnoSeguimientoDAOInterfaz bean = doLookup();
	         
	        AlumnoSeguimiento seg1 = new AlumnoSeguimiento();
	        //seg1.setId(33);
	        seg1.setAlumnoMatricula(3);
	        seg1.setFecha(2015-01-01);
	        seg1.setEnsenanzaMateria(1);
	        seg1.setSesion("1");
	        seg1.setTipo("falta");
	        seg1.setJustificante(0);
	        seg1.setObservaciones("observaciones_testCli1");
	        
	        AlumnoSeguimiento seg2 = new AlumnoSeguimiento();
	        //seg1.setId(34);
	        seg2.setAlumnoMatricula(1);
	        seg2.setFecha(2015-02-02);
	        seg2.setEnsenanzaMateria(1);
	        seg2.setSesion("1");
	        seg2.setTipo("incidencia");
	        seg2.setJustificante(0);
	        seg2.setObservaciones("observaciones_testCli2");
	       
	       
	        //Insertar nuevo AlumnoSeguimiento
	        bean.insertarAlumnoSeguimiento(seg1);
	        bean.insertarAlumnoSeguimiento(seg2);
	         
	        //Mostrar un seguimiento de un alumno
	        seg1.setId(1);
	        AlumnoSeguimiento seg3 = bean.getDetalleAlumnoSeguimiento(seg1.setId(id));
	        System.out.println(seg3);
	        
	        //Actualizar un seguimiento de un alumno
	        bean.actualizarAlumnoSeguimiento(seg2);
	        
	        //Eliminar un seguimiento de un alumno
	        bean.eliminarAlumnoSeguimiento(seg1);
	         
	        //Mostrar seguimientos de un alumno
	        System.out.println("Listar Seguimientos de un alumno:");
	        List<AlumnoSeguimiento> seguimientos = bean.getListaAlumnoSeguimiento(idMatricula);
	        for(AlumnoSeguimiento seguimiento : seguimientos)
	            System.out.println(seguimientos);
	    */     
	    }
	
	    private static AlumnoSeguimientoDAOInterfaz doLookup() {
	       
	    	Context context = null;
	    	AlumnoSeguimientoDAOInterfaz bean = null;
	        
	        try {
	        
	        	// 1. Obtaining Context
	            context = JNDILookupClass.getInitialContext();
	            
	            // 2. Generate JNDI Lookup name
	            String lookupName = getLookupName();
	            
	            // 3. Lookup and cast
	            bean = (AlumnoSeguimientoDAOInterfaz) context.lookup(lookupName);
	 
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	        
	        return bean;
	    
	    }
	 
	    private static String getLookupName() {
	    
	    	/*The app name is the EAR name of the deployed EJB without .ear
	        suffix. Since we haven't deployed the application as a .ear, the app
	        name for us will be an empty string */
	        String appName = "";
	 
	        /* The module name is the JAR name of the deployed EJB without the
	        .jar suffix.*/
	        String moduleName = "proyecto_open4job_2014_wildfly";
	 
	        /* AS7 allows each deployment to have an (optional) distinct name.
	        This can be an empty string if distinct name is not specified.*/
	        String distinctName = "";
	 
	        // The EJB bean implementation class name
	        String beanName = AlumnoSeguimientoDAO.class.getSimpleName();
	 
	        // Fully qualified remote interface name
	        final String interfaceName = AlumnoSeguimientoDAOInterfaz.class.getName();
	 
	        // Create a look up string name
	        String name = "ejb:" + appName + "/" + moduleName + "/" +
	        		distinctName + "/" + beanName + "!" + interfaceName;
	        
	       name = "ejb://proyecto_open4job_2014_wildfly/AlumnoSeguimiento!es.opensigad.model.dao.AlumnoSeguimientoDAOInterfaz";
	        
	        return name;
	    }
	    
}
