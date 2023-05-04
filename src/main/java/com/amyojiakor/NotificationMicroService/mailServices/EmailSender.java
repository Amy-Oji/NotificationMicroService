package com.amyojiakor.NotificationMicroService.mailServices;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    
    public static void sendEmail(String recipient, String subject, String text) throws AddressException, MessagingException {
        
        // Setup mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a mail session with the properties
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(null, null);
            }
        });

        // Create a new MimeMessage object
        Message message = new MimeMessage(session);

        // Set the From and To addresses
        message.setFrom(new InternetAddress(null));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

        // Set the subject and text of the email
        message.setSubject(subject);
        message.setText(text);

        // Send the email
        Transport.send(message);
    }
}
