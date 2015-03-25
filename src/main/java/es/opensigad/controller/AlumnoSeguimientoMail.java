package es.opensigad.controller;

/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//@Stateless
public class AlumnoSeguimientoMail {
	
	/*
	public static final Logger logger = Logger.getLogger(AlumnoSeguimientoMail.class.getName());
	
	@Resource(name = "java:jboss/mail/gmail")
	private Session session;

	public void enviarCorreo(String addresses, String topic, String textMessage) {

		try {

			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
			message.setSubject(topic);
			message.setText(textMessage);

			Transport.send(message);

		} catch (MessagingException e) {
			logger.log(Level.SEVERE,"AlumnoSeguimientoMail.enviarCorreo: ERROR. " + e.getMessage());						
		}
	}
	*/
	
}
