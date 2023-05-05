package com.sambit.Utils;

import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.messaging.Body;
import com.twilio.type.PhoneNumber;
import okhttp3.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/05/2023 - 11:46 AM
 */
public class WhatsAppMessageSender {

    private static final String ACCOUNT_SID = "your_account_sid";
    private static final String AUTH_TOKEN = "your_auth_token";

//    public static void sendWhatsAppMessage() {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        PhoneNumber from = new PhoneNumber("14155238886");
//        PhoneNumber to = new PhoneNumber("12345678901");
//         Message message = Message.creator(to, from, "Hello from Sambit!").create();
//        System.out.println("Message SID: " + message.getSid());
//    }

//    public static void sendWhatsAppMessage1() {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        PhoneNumber from = new PhoneNumber("14155238886");
//        PhoneNumber to = new PhoneNumber("12345678901");
//        Body body = new Body.Builder("Hello from Twilio!").build();
//
//        // Create the message
//        Message message = new Message.Builder()
//                .body(body)
//                .from(from)
//                .to(to)
//                .build();
//
//        // Create the messaging response
//        MessagingResponse response = new MessagingResponse.Builder()
//                .message(message)
//                .build();
//
//        // Print the TwiML XML
//        System.out.println(response.toXml());
//    }

    public static void main( String[] args ) {
        for (int i = 1; i < 2; i++) {
            sendWhatsAppMessage();
        }
    }

    public static void sendWhatsAppMessage1() {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"messaging_product\": \"whatsapp\", \"to\": \"917008095918\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }");

            Request request = new Request.Builder()
                    .url("https://graph.facebook.com/v16.0/111606275260189/messages")
                    .post(body)
                    .addHeader("Authorization", "Bearer EAAILZB4d5eysBADZCWVDXSJNWAubpkpNGqcZCMiTKJQKbaUOjDWN3w1NATLNuPdoBBNCd9UBCM1ziHkEQp9sB7ZCwjAERL57KWj1x10pL3SmE5MBKKWRZBkcnGei5Rjv6zYjD2bPjsFPZBIpdriTCc8rdaxHnieLw4XsshxtqTMPYZAd4PNsCtSXnlegSu3fdQPE8liPFBNDAZDZD")
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendWhatsAppMessage() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://graph.facebook.com/v16.0/111606275260189/messages"))
                    .header("Authorization", "Bearer EAAILZB4d5eysBANDilQw6TnTEG9p5zHSstGj6eGDiZCMwsZAGWZAYnVdOi5v9plH1jXXJjqpheb8D5Tb8knIDBags4eHNYZCGn9yaCFVEvMngQOLSMVvoIuVFyBxBGhH2x4Ei7VMam7JmrRW6maVa6BorhAPJTQJ2osnoTZCg7Q1XtXhT69zrZCcyapRGr6ou8aoeFPclsHgQZDZD")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \"916370928692\", \"type\": \"text\", \"text\": { \"preview_url\": false, \"body\": \"(◑‿◐).\" } }"))
//                    .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"to\": \"917605933282\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" }, \"namespace\": \"2F861A_Hello_World\", \"elements\": [ { \"default_action\": { \"type\": \"web_url\", \"url\": \"https://example.com\", \"messenger_extensions\": true, \"webview_height_ratio\": \"tall\" }, \"buttons\": [ { \"type\": \"web_url\", \"url\": \"https://example.com\", \"title\": \"View Website\" } ], \"title\": \"Happy Birthday\" } ] } }"))
                    .build();

            HttpClient http = HttpClient.newHttpClient();
            HttpResponse<String> response = http.send(request, BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
