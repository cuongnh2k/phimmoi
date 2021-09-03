package service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

public class Service {

	public String random() {
		String input = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
		return RandomStringUtils.random(6, input);
	}

	public void senPassword(String email, String password) {
		String HOST_NAME = "smtp.gmail.com";

		int SSL_PORT = 465; // Port for SSL

		String APP_EMAIL = "cuongnh2k@gmail.com"; // your email

		String APP_PASSWORD = "jbgprklvaztadmpe"; // your password

		String RECEIVE_EMAIL = email;
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", HOST_NAME);
		props.put("mail.smtp.socketFactory.port", SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", SSL_PORT);

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
			}
		});

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVE_EMAIL));
			message.setSubject("Hi");
			message.setText(password);

			// send message
			Transport.send(message);

			System.out.println("Message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
