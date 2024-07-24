package com.eduardocaio.user_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username")
    private String system;
    
    public String sendEmailText(String user, String subject, String msg){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(system);
            simpleMailMessage.setTo(user);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(msg);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado";
        }catch(Exception e){
            return "Erro ao tentar enviar email " + e.getLocalizedMessage();
        }
    }

}
