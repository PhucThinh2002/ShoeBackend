package vn.edu.vlu.khoaluan.service.Impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import vn.edu.vlu.khoaluan.service.ISendMailService;

@Service
public class SendMailServiceImpl implements ISendMailService{

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Override
    public void sendMail(String toEmail, String subject, String body) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(toEmail);
            helper.setText(body, true);
            helper.setSubject(subject);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
    
}
