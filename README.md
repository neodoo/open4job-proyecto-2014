# proyecto-open4Job-2014 - Branch WIldFly

Proyecto clonado para su migración a WildFly



 ** Cambios en WEB-INF/faces-config.xml **

// Para usar JSF v2.2.:

	<?xml version='1.0' encoding='UTF-8'?>
	<faces-config xmlns="http://xmlns.jcp.org/xml/ns/javaee"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-facesconfig_2_2.xsd"
              version="2.2">



 ** Cambios en WEB-INF/web.xml **

// Para usar Servlets v3.1.:

	<?xml version="1.0" encoding="UTF-8"?>
	<web-app version="3.1" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 			xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd">


// Securización:

	<security-constraint>
		<web-resource-collection>
			<web-resource-name>administrator</web-resource-name>
			<url-pattern>/*</url-pattern>
			<http-method>POST</http-method>
			<http-method>GET</http-method>
			<http-method>PUT</http-method>
			<http-method>DELETE</http-method>
		</web-resource-collection>
		<auth-constraint>
			<role-name>ADMINISTRATOR</role-name>
		</auth-constraint>
	</security-constraint>

	<security-constraint>
		<web-resource-collection>
			<web-resource-name>user</web-resource-name>
			<url-pattern>/*</url-pattern>
			<http-method>POST</http-method>
			<http-method>GET</http-method>
			<http-method>PUT</http-method>
			<http-method>DELETE</http-method>
		</web-resource-collection>
		<auth-constraint>
			<role-name>USER</role-name>
		</auth-constraint>
	</security-constraint>


// Incorporar JavaMelody (monitorización app):

	<filter>
                <filter-name>javamelody</filter-name>
                <filter-class>net.bull.javamelody.MonitoringFilter</filter-class>
        </filter>
        <filter-mapping>
                <filter-name>javamelody</filter-name>
                <url-pattern>/*</url-pattern>
        </filter-mapping>
        <listener>
                <listener-class>net.bull.javamelody.SessionListener</listener-class>
        </listener>



 ** Crear WEB-INF/beans.xml **

// Para usar inyecciones, permite @Named que sustituye a @ManagedBean:

	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://xmlns.jcp.org/xml/ns/javaee"
       		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd"
       		version="1.1" bean-discovery-mode="all">



 ** Cambios en pom.xml **

// Poner la JEE 7:

        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>7.0<</version>
            <scope>provided</scope>
        </dependency>        

     

// Incorporar JavaMelody (monitorización app):

        <dependency>
                <groupId>net.bull.javamelody</groupId>
                <artifactId>javamelody-core</artifactId>
                <version>1.55.0</version>
        </dependency>


// Extender primefaces:

        <dependency>  
            <groupId>org.primefaces</groupId>  
            <artifactId>primefaces</artifactId>  
            <version>${primefaces-version}</version>         
        </dependency>         

        <dependency>
            <groupId>org.primefaces.extensions</groupId>
            <artifactId>primefaces-extensions</artifactId>
            <version>${primefaces-extensions-version}</version>
        </dependency>

        <dependency>
            <groupId>org.primefaces.themes</groupId>
            <artifactId>bluesky</artifactId>
            <version>${primefaces-theme-blueSky}</version>
        </dependency>


// Primefaces local:

	<dependency>
    	    <groupId>sample</groupId>
    	    <artifactId>com.sample</artifactId>
            <version>1.0</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/src/main/resources/yourJar.jar</systemPath>
	</dependency>



 ** Cambiar en WEB-INF/jboss-web.xml **

// Incorporar JavaMelody (monitorización de consultas SQL):

	<?xml version="1.0" encoding="UTF-8"?>
	<jboss-web xmlns="http://www.jboss.com/xml/ns/javaee">
  		<resource-ref>
    		<res-ref-name>jdbc/openSigadDS</res-ref-name>
    		<jndi-name>java:jboss/datasources/openSigadDS</jndi-name>
  		</resource-ref>
	</jboss-web>



 ** Como configurar el standalone-full.xml para el buzón de JMS **

// Añadir donde corresponda (buscando por "mail-session" y "outbound-socket-binding") las siguientes líneas:

	<mail-session name="java:jboss/mail/gmail" jndi-name="java:jboss/mail/gmail">
      		<smtp-server outbound-socket-binding-ref="mail-smtp" ssl="true" username="alg.pruebas@gmail.com" password="xxx"/>
	</mail-session>


	<outbound-socket-binding name="mail-smtp">
        	<remote-destination host="smtp.gmail.com" port="465"/>
	</outbound-socket-binding>



 ** Como configurar standalone.xml o standalone-full.xml para utilizar la securización por base de datos **

// Introducir en standalone.xml o standalone-full.xml en jboss:domain:security lo siguiente:
                
	<security-domain name="school" cache-type="default">
  		<authentication>
      		<login-module code="Database" flag="required">
          		<module-option name="dsJndiName" value="java:jboss/datasources/openSigadDS"/>
          		<module-option name="rolesQuery" value="SELECT role, 'Roles' FROM users WHERE username=?"/>
          		<module-option name="principalsQuery" value="SELECT password from users WHERE username=?"/>
      		</login-module>
 		</authentication>
  		<authorization>
      		<policy-module code="Database" flag="required">
         		<module-option name="dsJndiName" value="java:jboss/datasources/openSigadDS"/>
          		<module-option name="rolesQuery" value="SELECT role, 'Roles' FROM users WHERE username=?"/>
          		<module-option name="principalsQuery" value="SELECT password from users WHERE username=?"/>
      		</policy-module>
  		</authorization>
	</security-domain>


	
 ** Valores del datasource para añadir al servidor **

// Añadir esta configuración desde la consola de administración del Wildfly o en el standalone.xml o standalone-full.xml:

	<datasource jta="false" jndi-name="java:jboss/datasources/openSigadDS" pool-name="openSigadDS" enabled="true" use-ccm="false">
        	<connection-url>jdbc:mysql://54.154.192.80:3306/opensigad</connection-url>
                <driver-class>com.mysql.jdbc.Driver</driver-class>
                <driver>mysql-connector-java-5.1.34-bin.jar_com.mysql.jdbc.Driver_5_1</driver>
                <security>
                       	<user-name>opensigad</user-name>
                       	<password>.opensigad8$</password>
                </security>
                <validation>
                        <validate-on-match>false</validate-on-match>
                        <background-validation>false</background-validation>
                </validation>
                <timeout>
                       	<set-tx-query-timeout>false</set-tx-query-timeout>
                       	<blocking-timeout-millis>0</blocking-timeout-millis>
                       	<idle-timeout-minutes>0</idle-timeout-minutes>
                       	<query-timeout>0</query-timeout>
                       	<use-try-lock>0</use-try-lock>
                       	<allocation-retry>0</allocation-retry>
                       	<allocation-retry-wait-millis>0</allocation-retry-wait-millis>
                </timeout>
                <statement>
                       	<share-prepared-statements>false</share-prepared-statements>
                </statement>
        </datasource>



 ** Ejemplo de RESTEASY **
    
// En el pom.xml:
    
    	<dependency>
			<groupId>javax.ws.rs</groupId>
			<artifactId>jsr311-api</artifactId>
			<version>1.1.1</version>
			<scope>provided</scope>
	</dependency>
		
		
// En el web.xml:
		
	<servlet>
        	<servlet-name>javax.ws.rs.core.Application</servlet-name>
        	<load-on-startup>1</load-on-startup>
    	</servlet>
    
    	<servlet-mapping>
        	<servlet-name>javax.ws.rs.core.Application</servlet-name>
        	<url-pattern>/rest/*</url-pattern>
    	</servlet-mapping>



 ** Diferencias entre versiones de JSF: **

// JSF v2.0 (preRenderView):

    <f:metadata>
        <f:viewParam name="idActuacion" value="#{detalleActuacionBean.idActuacion}"  required="true"/>
        <f:event type="preRenderView" listener="#{detalleActuacionBean.initialize}" />
    </f:metadata>

        // Esta linea hace que no se ejecute en cada request
        if (!FacesContext.getCurrentInstance().isPostback() && !FacesContext.getCurrentInstance().isValidationFailed()) {


// JSF v2.2 (viewAction):

    <f:metadata>
        <f:viewParam name="q8jttcod" value="#{jttGestForm.q8jttcod}" />

        <f:viewParam name="from" value="#{jttGestForm.from}" />
        <f:viewAction action="#{jttGestAction.execQuery}" />
    </f:metadata>
