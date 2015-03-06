package es.opensigad.model.client;

import javax.naming.Context;
import javax.naming.NamingException;

import es.opensigad.model.dao.AlumnoNotaDAO;
import es.opensigad.model.vo.AlumnoNota;
import es.opensigad.model.dao.AlumnoNotaDAOInterfaz;
 
public class AlumnoNotaClient {

	   public static void main(String[] args) {
		   
	        AlumnoNotaDAOInterfaz bean = doLookup();
	         
	        AlumnoNota p1 = new AlumnoNota();
	        
	         
	        AlumnoNota p2 = new AlumnoNota();
	       
	 
	       System.out.println("List of Projects:");
	        /*List<AlumnoNota> projects = bean.retrieveAllProjects();
	        for(AlumnoNota project : projects)
	            System.out.println(project);
	            */
	         
	    }
	 
	    private static AlumnoNotaDAOInterfaz doLookup() {
	       
	    	Context context = null;
	    	AlumnoNotaDAOInterfaz bean = null;
	        
	        try {
	 
	            context = JNDILookupClass.getInitialContext();

	            String lookupName = getLookupName();
	    
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
	        
	        return name;
	    }
	    
}
