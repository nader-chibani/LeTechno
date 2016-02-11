package edu.letechno.entity;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	
	
	

	  public String generetaCode() {
		SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	  }
	  
	public void sendMail(String dest, String msg, String subject) {
		System.out.println("je suis lacc");
		final String username = "info@letechno.net";
		final String password = "N@der1990";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "naderchib.ipage.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});

		try {
			System.out.println("je suis la 2");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(dest));
			message.setSubject(subject);
			message.setText(msg);
			
			Transport.send(message);
			

		} catch (MessagingException e) {
			System.out.println("je suis la 3");
			throw new RuntimeException(e);
		}
	}
}
