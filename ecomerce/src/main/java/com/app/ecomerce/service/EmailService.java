package com.app.ecomerce.service;

import com.app.ecomerce.exception.UserEmailException;
import com.app.ecomerce.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${app.mail.sender}")
    private String sender;

    //url to verify Email
    @Value("${app.url}")
    private String url;

    public SimpleMailMessage createMailMessage(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        return mailMessage;
    }

    public  void sendVerificationEmail(VerificationToken verificationToken) throws UserEmailException{
        SimpleMailMessage simpleMailMessage = createMailMessage();
        simpleMailMessage.setTo(verificationToken.getUser().getEmail());
        simpleMailMessage.setSubject("Please verify your Email");
        simpleMailMessage.setText("Click link to verify. \n" +
                url + "auth/verify/token=?" + verificationToken.getToken());
    try{
        javaMailSender.send(simpleMailMessage);
    }catch (MailException e){
        throw new UserEmailException();
    }
    }
}
