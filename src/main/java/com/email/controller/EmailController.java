package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.services.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/home")
	public String home() {
		return "Welcome to My Email API - Swapnil ";
	}
	
	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Authorization", "Content-Type"})
	public ResponseEntity<?> sendMail(@RequestBody EmailRequest request) {
		
		 boolean sendEmailResult = this.emailService.sendEmail(request.getTo(),request.getSubject(),request.getMessage());
		 System.out.println(request);
		 
		 if (sendEmailResult) {
			return ResponseEntity.ok("Email Sent succesfully !!");
		}
		 else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not sent... something went Wrong");
		}
		
	}
}
