# proyecto-open4Job-2014 - Branch WIldFly

Proyecto clonado para su migración a WildFly



** Como configurar el standalone-full.xml para el buzón de JMS **

Añadir donde corresponda (buscando por "mail-session" y "outbound-socket-binding") las siguientes líneas:

<mail-session name="java:jboss/mail/gmail" jndi-name="java:jboss/mail/gmail">
      <smtp-server outbound-socket-binding-ref="mail-smtp" ssl="true" username="alg.pruebas@gmail.com" password="xxx"/>
</mail-session>


<outbound-socket-binding name="mail-smtp">
            <remote-destination host="smtp.gmail.com" port="465"/>
</outbound-socket-binding>


** Como configurar standalone.xml o standalone-full.xml para utilizar la securización por base de datos **

Introducir en standalone.xml o standalone-full.xml en jboss:domain:security lo siguiente:
                
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

   <datasource jta="false" jndi-name="java:jboss/datasources/openSigadDS" pool-name="opensigadDS" enabled="true" use-ccm="false">
         <connection-url>jdbc:mysql://54.154.192.80:3306/opensigad</connection-url>
              <driver-class>com.mysql.jdbc.Driver</driver-class>
              <driver>mysql-connector-java-5.1.32-bin.jar_com.mysql</driver>
                    <security>
                        <user-name>opensigad</user-name>
                        <password>.opensigad8$</password>
                    </security>
                    <validation>
                        <validate-on-match>false</validate-on-match>
                        <background-validation>false</background-validation>
                    </validation>
                    <statement>
                        <share-prepared-statements>false</share-prepared-statements>
                    </statement>
    </datasource>
    
    
    
 ** Ejemplo de RESTEASY **
    
En el POM
    
    	<dependency>
			<groupId>javax.ws.rs</groupId>
			<artifactId>jsr311-api</artifactId>
			<version>1.1.1</version>
			<scope>provided</scope>
		</dependency>
		
		
En el web.xml
		
		 <servlet>
        <servlet-name>javax.ws.rs.core.Application</servlet-name>
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>javax.ws.rs.core.Application</servlet-name>
        <url-pattern>/rest/*</url-pattern>
    </servlet-mapping>
