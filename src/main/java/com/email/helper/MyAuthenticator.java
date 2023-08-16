package com.email.helper;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

	/// Add your login details of your mail account 
	 protected PasswordAuthentication getPasswordAuthentication() {
		 
		                                     // Email and password 
	        return new PasswordAuthentication("abhijit85bendre@gmail.com", "Abhijit@17");
	    }
}
