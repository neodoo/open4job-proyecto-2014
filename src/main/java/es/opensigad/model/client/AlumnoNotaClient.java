package es.opensigad.model.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;
 
public class AlumnoNotaClient {

	   public static void main(String[] args) {
		   
	        AlumnoNotaDAOInterfaz bean = doLookup();


	        List<AlumnoNota> AlNota2 = bean.getNotasByIdMatricula(2);
	        System.out.println(AlNota2);
	         
	    }
	 
	    private static AlumnoNotaDAOInterfaz doLookup() {
	       
	    	Context context = null;
	    	AlumnoNotaDAOInterfaz bean = null;
	        
	        try {
	 
	            context = JNDILookupClass.getInitialContext();

	            String lookupName = getLookupName();
	    	            
	            /*
	        	java:global/proyecto_open4job_2014_wildfly/AlumnoNotaDAO!es.opensigad.model.dao.AlumnoNotaDAOInterfaz
	        	java:app/proyecto_open4job_2014_wildfly/AlumnoNotaDAO!es.opensigad.model.dao.AlumnoNotaDAOInterfaz
	        	java:module/AlumnoNotaDAO!es.opensigad.model.dao.AlumnoNotaDAOInterfaz
	        	java:jboss/exported/proyecto_open4job_2014_wildfly/AlumnoNotaDAO!es.opensigad.model.dao.AlumnoNotaDAOInterfaz
	        	java:global/proyecto_open4job_2014_wildfly/AlumnoNotaDAO
	        	java:app/proyecto_open4job_2014_wildfly/AlumnoNotaDAO
	        	java:module/AlumnoNotaDAO
	        	*/
	        	
	            bean = (AlumnoNotaDAOInterfaz) context.lookup(lookupName);
	 
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	         

	        
	        return bean;
	    
	    }
	 
	    private static String getLookupName() {
	   
	        String appName = "";
	
	        String moduleName = "proyecto_open4job_2014_wildfly";
	 
	        String distinctName = "";
	 
	        String beanName = AlumnoNotaDAO.class.getSimpleName();
	 
	        final String interfaceName = AlumnoNotaDAOInterfaz.class.getName();

	        String name = "ejb:" + appName + "/" + moduleName + "/" +
	                distinctName    + "/" + beanName + "!" + interfaceName;

	        name = "ejb://proyecto_open4job_2014_wildfly/AlumnoNotaDAO!es.opensigad.model.dao.AlumnoNotaDAOInterfaz";
	        
	        return name;
	    }
	    
}
