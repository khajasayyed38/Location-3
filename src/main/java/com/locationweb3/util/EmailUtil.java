package com.locationweb3.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class EmailUtil implements Email {
	
	@Autowired
    private JavaMailSender javaMailSender;
		
	@Override
	public void sendEmail(String toAddress, String sub, String body) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(toAddress);

	        msg.setSubject(sub);
	        msg.setText(body);

	        javaMailSender.send(msg);

	}

}
