package spring.springhello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.springhello.domain.SendEmailRequest;
import spring.springhello.service.EmailServiceClient;

@Controller
@RequestMapping("/email")
public class EmailController {

    private final EmailServiceClient emailServiceClient;

    public EmailController(EmailServiceClient emailServiceClient) {
        this.emailServiceClient = emailServiceClient;
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail() {
        SendEmailRequest sendEmailRequest = generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);
        return "success";
    }

    private SendEmailRequest generateEmailRequest() {
        SendEmailRequest request = new SendEmailRequest();
        request.setToAddress("<EMAIL>");
        request.setSubject("Test Email");
        request.setBody("Test Email Body");
        return request;
    }
}
