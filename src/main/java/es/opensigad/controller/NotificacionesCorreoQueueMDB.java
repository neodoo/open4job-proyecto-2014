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
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import es.opensigad.model.vo.AlumnoSeguimientoDatosCorreo;

/**
 * <p>
 * A simple Message Driven Bean that asynchronously receives and processes the
 * messages that are sent to the queue.
 * </p>
 */
@MessageDriven(name = "AlumnoSeguimientoQueueMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/NOTIFICACIONESCORREOMDBQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class NotificacionesCorreoQueueMDB implements MessageListener {

	// @EJB
	// private AlumnoSeguimientoMail alumnoSeguimientoMail;

	private final static Logger LOGGER = Logger
			.getLogger(NotificacionesCorreoQueueMDB.class.toString());

	@Resource(name = "java:jboss/mail/gmail")
	private Session session;

	private void enviarCorreo(String email, String asunto, String mensaje) {

		try {

			javax.mail.Message message = new MimeMessage(session);
			
			InternetAddress addressFrom = new InternetAddress("alg.pruebas@gmail.com");
			message.setFrom(addressFrom);
			//message.setFrom();
			
			InternetAddress addressRecipient = new InternetAddress(email);
			message.addRecipient(javax.mail.Message.RecipientType.TO, addressRecipient);
			
			message.setSubject(asunto);
			message.setText(mensaje);

			Transport.send(message);

		} catch (MessagingException e) {
			LOGGER.log(
					Level.SEVERE,
					"AlumnoSeguimientoMail.enviarCorreo: ERROR. "
							+ e.getMessage());
		}
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message rcvMessage) {

		ObjectMessage msg = null;

		try {

			if (rcvMessage instanceof ObjectMessage) {

				msg = (ObjectMessage) rcvMessage;
				AlumnoSeguimientoDatosCorreo correo = (AlumnoSeguimientoDatosCorreo) msg.getObject();
				enviarCorreo(correo.getEmail(), correo.getAsunto(),	correo.getMensaje());

				LOGGER.info("Received Message from queue: "
						+ msg.getObject().toString());

			} else {

				LOGGER.warning("Message of wrong type: "
						+ rcvMessage.getClass().getName());
			}

		} catch (JMSException e) {
			throw new RuntimeException(e);
		}

	}

}
