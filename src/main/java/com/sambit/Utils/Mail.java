package com.sambit.Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

        public static final String username = "sambit.csmtechnologies@gmail.com";
        public static final String password = "lcjdjtnkobvtcecv";

	public static void sendEmailTLS(String email) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sambit.csmtechnologies@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email)
                );
                message.setSubject("Greeting From Sambit");
                message.setText("Hyper Ledger Padha be, Sabuebele Mobile Dekhila Basi.");

                Transport.send(message);

                System.out.println("Mail Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        	System.out.println(e);
        }
	}
}
