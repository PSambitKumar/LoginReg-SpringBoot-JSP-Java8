package com.sambit.Utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Mail {

        public static final String username = "sambit.csmtechnologies@gmail.com";
        public static final String password = "iyilybecukfvlhoe";
//        public static final String username = "teamodishatourism16@gmail.com";
//        public static final String password = "qjqnhwsrvytkgblr";

        public static void sendEmailGmailTLS(String email) {
                String filePath = "C:/BSKY/Daily Basis CPD Allotment Report.xlsx";

                Properties prop = new Properties();
                prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true"); //TLS

                Session session = Session.getInstance(prop,
                        new Authenticator() {
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
                        message.setText("Delete Pro. Database Please.");

                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setText("Body Part");

                        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                        DataSource source = new FileDataSource(filePath);
                        attachmentBodyPart.setDataHandler(new DataHandler(source));
                        attachmentBodyPart.setFileName(source.getName());

                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(messageBodyPart);
                        multipart.addBodyPart(attachmentBodyPart);

                        message.setContent(multipart);

                        Transport.send(message);
                        System.out.println("Mail Sent Successfully.");

                } catch (MessagingException e) {
                        e.printStackTrace();
                        System.out.println(e);
                }
        }

        public static void sendMailYahooTLS() {
                final String to = "nobody@yahoo.com";
                final String from = "sambitkumar_pradhan@yahoo.in";

                String host = "smtp.mail.yahoo.com";
                Properties properties = System.getProperties();

                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.auth", "true");

                Session session = Session.getInstance(properties, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("sambitkumar_pradhan@yahoo.in", "Password");
                        }
                });
                session.setDebug(true);
                try {
                        MimeMessage message = new MimeMessage(session);

                        message.setFrom(new InternetAddress(from));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                        message.setSubject("This is the Subject Line!");
                        message.setText("This is Actual Message");

                        System.out.println("Sending...");
                        Transport.send(message);
                        System.out.println("Sent Message Successfully....");
                } catch (MessagingException mex) {
                        mex.printStackTrace();
                }
        }

        public static void sendMail(String subject,String body,String recipientMail) {
                try {
                        Properties prop = new Properties();
                        prop.put("mail.smtp.host", "apps.odishaone.gov.in");
                        prop.put("mail.smtp.port", "25");
                        prop.put("mail.smtp.auth", "enable");
                        prop.put("mail.smtp.starttls.enable", "enable");

                        Session session = Session.getInstance(prop,new Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication("bsky@odishaone.gov.in", "m658P6@iQK9l");
                                }
                        });

                        try {
                                Message message = new MimeMessage(session);
                                message.setFrom(new InternetAddress("bsky@odishaone.gov.in"));
                                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipientMail));
                                message.setSubject(subject);
                                message.setText(body);
                                Transport.send(message);
                                System.out.println("Mail Sent Successfully.");
                        } catch (MessagingException e) {
                                System.out.println(e);
                        }
                }catch (Exception e) {
                        e.printStackTrace();
                }
        }


}
