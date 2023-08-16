package com.email.services;

import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;

import org.springframework.stereotype.Service;

import com.email.helper.MyAuthenticator;


@Service
public class EmailService {

	
	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f = false;
		
		String from="swapniltake9@gmail.com";
		
		// Variable for gamil
		
		String host="smtp.gmail.com";
		
		// Get system properties
		
		Properties properties = System.getProperties();
		System.out.println("Properties "+properties);
		
		// Setting importent information to properties object
		
		// Host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//STep 1: TO Get Session object
		Session session = Session.getInstance(properties, new MyAuthenticator());
		
			/*protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("swapniltake9@gmail.com", "Swapnil" );
			}
			
		});
		*/
			
		session.setDebug(true);
		
		// step 2 : compose the message [text and multimeadia]
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			// From EMail
			m.setFrom(from);
			
			// additing recipient to message
			
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// adding subject to message 
			m.setSubject(subject);
			
			// send
			
			// STep 3 : Send to traceport class
			Transport.send(m);
			
			System.out.println("Sent Successfully !!!");
			
			f=true;
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
}
