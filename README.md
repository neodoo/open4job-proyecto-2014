# proyecto-open4Job-2014 - Branch WIldFly

Proyecto clonado para su migración a WildFly



Como configurar el standalone-full.xml para el buzón de JMS.

Añadir donde corresponda las siguientes líneas:

<mail-session name="java:jboss/mail/gmail" jndi-name="java:jboss/mail/gmail">
      <smtp-server outbound-socket-binding-ref="mail-smtp" ssl="true" username="alg.pruebas@gmail.com" password="xxx"/>
</mail-session>


<outbound-socket-binding name="mail-smtp">
            <remote-destination host="smtp.gmail.com" port="465"/>
</outbound-socket-binding>
