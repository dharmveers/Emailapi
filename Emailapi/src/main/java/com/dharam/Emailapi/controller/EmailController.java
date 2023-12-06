package com.dharam.Emailapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dharam.Emailapi.model.EmailRequest;
import com.dharam.Emailapi.model.EmailResponse;
import com.dharam.Emailapi.services.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired 
	private EmailService emailService;
	
	@RequestMapping("/email")
	public String display() {
		return "welcome to email api";
	}
	
	//api to send Email
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		System.out.println(request);
		this.emailService.sendEmail(request.getSubject(), request.getmessage(), request.getTo());
		return ResponseEntity.ok(new EmailResponse("Message Sent Successfully..."));
	}
	
}
