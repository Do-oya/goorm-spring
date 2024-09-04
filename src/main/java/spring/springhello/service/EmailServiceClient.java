package spring.springhello.service;

import org.springframework.stereotype.Service;
import spring.springhello.domain.SendEmailRequest;

@Service
public class EmailServiceClient {
    public void sendEmail(SendEmailRequest request) {
        System.out.println("Sending email to : " + request.getToAddress());
        System.out.println("Subject : " + request.getSubject());
        System.out.println("Body : " + request.getBody());
    }
}
