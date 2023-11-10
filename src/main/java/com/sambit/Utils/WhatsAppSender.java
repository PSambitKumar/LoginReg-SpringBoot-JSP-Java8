package com.sambit.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 04/05/2023 - 3:37 PM
 */
public class WhatsAppSender {
    private static final String INSTANCE_ID = "YOUR_INSTANCE_ID_HERE";
    private static final String CLIENT_ID = "YOUR_CLIENT_ID_HERE";
    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET_HERE";
    private static final String WA_GATEWAY_URL = "http://api.whatsmate.net/v3/whatsapp/single/text/message/" + INSTANCE_ID;

    public static void main(String[] args) throws Exception {
        String number = "7008095918";
        String message = "Howdy, Sambit Kumar.";

        WhatsAppSender.sendMessage(number, message);
    }

    public static void sendMessage(String number, String message) throws Exception {
        String jsonPayload = "{" +
                "\"number\":\"" +
                number +
                "\"," +
                "\"message\":\"" +
                message +
                "\"" +
                "}";

        URL url = new URL(WA_GATEWAY_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        conn.setRequestProperty("Content-Type", "application/json");

        OutputStream os = conn.getOutputStream();
        os.write(jsonPayload.getBytes());
        os.flush();
        os.close();

        int statusCode = conn.getResponseCode();
        System.out.println("Response from WA Gateway: \n");
        System.out.println("Status Code: " + statusCode);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
        ));
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }

    public void whatsAppMessaging() {
        try {
//            Method Using Sending Data Using Form-Data. Doc File : static/pdffiles/WhatsAppMessaging.pdf
            String url = "https://msg.odisha.gov.in/api/api.php";
            String action = "send_template_sms";
            String phone = "+917008095918";
            String template_name = "odisha_57";
            String body_text = "This is a test message from BSKY Team";

            Map<String, String> formData = new HashMap<>();
            formData.put("action", action);
            formData.put("phone", phone);
            formData.put("template_name", template_name);
            formData.put("body_text", body_text);

            String response1 = sendPostRequest(url, formData);
            System.out.println("Response: " + response1);
        } catch (Exception e) {
            System.out.println("Exception Found in whatsAppMessaging of WhatsAppMessagingServiceImpl : " + e);
        }
    }

    private static String sendPostRequest(String apiUrl, Map<String, String> formData) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(entry.getKey());
            postData.append('=');
            postData.append(entry.getValue());
        }

        try (OutputStream os = conn.getOutputStream()) {
            byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);
            os.write(postDataBytes);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    public int sendWhatsAppMessage1(String phoneNumber, String body, String templateName) {
        int statusCode = 500;
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("URL")
                    .header("Cookie", "PHPSESSID=grqrqegr47glkn20th2c0llpa8")
                    .field("action", "Action Code")
                    .field("phone", "+91" + phoneNumber)
                    .field("template_name", templateName)
                    .field("body_text", body)
                    .asString();

            if (response.getStatus() == 200) {
                String responseBody = response.getBody();
                Map<?, ?> responseMap = new ObjectMapper().readValue(responseBody, Map.class);
                statusCode = Integer.parseInt(responseMap.get("status").toString()) == 1 ? 200 : 500;
            } else {
                System.out.println("Invalid response");
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return statusCode;
    }
}