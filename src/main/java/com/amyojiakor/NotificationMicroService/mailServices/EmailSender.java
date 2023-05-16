package com.amyojiakor.NotificationMicroService.mailServices;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component
public class EmailSender {

    private final String fromEmail;
    private  final JavaMailSender javaMailSender;

    public EmailSender(@Value("spring.mail.username") String fromEmail, JavaMailSender javaMailSender) {
        this.fromEmail = fromEmail;
        this.javaMailSender = javaMailSender;
    }

    //    public static void sendEmail(String recipient, String subject, String text) throws AddressException, MessagingException {
//
//        // Setup mail server properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        // Create a mail session with the properties
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new javax.mail.PasswordAuthentication("prizymira@gmail.com", "08066085859");
//            }
//        });
//
//        // Create a new MimeMessage object
//        Message message = new MimeMessage(session);
//
//        // Set the From and To addresses
//        message.setFrom(new InternetAddress("prizymira@gmail.com"));
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
//
//        // Set the subject and text of the email
//        message.setSubject(subject);
//        message.setText(text);
//
//        // Send the email
//        Transport.send(message);
//    }






    public void sendMail(String toEmail,
                         String subject,
                         String body) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setText(body, true);
            helper.setSubject(subject);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


//    public void sendEmail(String recipient, String subject, String text) throws MessagingException {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipient);
//        message.setSubject(subject);
//        message.setText(text);
//        javaMailSender.send(message);
//    }

    public void sendEmail(String toEmail, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }
}
