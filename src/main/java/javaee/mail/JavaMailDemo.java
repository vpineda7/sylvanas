package org.summer.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
//@Configuration
public class JavaMailDemo {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
    private SimpleMailMessage templateMessage;
	
	@Scheduled(fixedRate = 1000)
    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        
        msg.setSubject("Hello");
        
        msg.setTo("");
        
        msg.setText("Hello Java Mail");
        
        try{
        	
            this.mailSender.send(msg);
            
            System.out.println(new Date() +" : Send Mail Success");
            
        } catch (MailException ex) {
        	
            System.err.println(ex.getMessage());
        }
    }
}
