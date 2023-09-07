package com.sambit.Controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 07-Sep-2023 : 2:59 PM
 */

public class HttpController {

    public void sendPostRequestUsingBodyFormData() throws IOException {
        URL url = new URL("https://msg.odisha.gov.in/api/api.php");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String formData = "action=send_template_sms&phone=+917008095918&template_name=bsky_005&body_text=11";

        OutputStream os = connection.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(formData);
        writer.flush();
        writer.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = bufferedReader.readLine();
    }

    public void sendPostRequestUsingBodyFormData1() {
        try {
            Map<String, String> formData = new LinkedHashMap<>();
            formData.put("action", "send_template_sms");
            formData.put("phone", "+917008095918");
            formData.put("template_name", "bsky_005");
            formData.put("body_text", "11");

            String response1 = sendPostRequest("https://msg.odisha.gov.in/api/api.php", formData);
        } catch (Exception e) {
            e.printStackTrace();
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
            if (!postData.isEmpty())
                postData.append('&');

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
}
