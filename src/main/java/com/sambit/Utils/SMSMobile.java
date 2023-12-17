package com.sambit.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SMSMobile {

    public static void smsMobileReq(){
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    @Override
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier allHostsValid = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        } catch (GeneralSecurityException e) {
            System.out.println(e.getMessage());
        }

        try {
            StringBuilder sendString = new StringBuilder();
            String username = "admin";
            String password = "sambit16";
            String messagetype = "SMS:TEXT";
            String httpUrl = "https://127.0.0.1:9400/";
            String recipient = URLEncoder.encode("+917008095918", StandardCharsets.UTF_8);
            String messagedata = URLEncoder.encode("Sambit", StandardCharsets.UTF_8);

            sendString.append(httpUrl).append("api?action=sendmessage").
                    append("&username=").append(username).append("&password=").
                    append(password).append("&recipient=").append(recipient).
                    append("&messagetype=").append(messagetype).append("&messagedata=").
                    append(messagedata);

            System.out.println("Sending request: " + sendString.toString());

            URL url = new URL(sendString.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = null;
            System.out.println("Http response received: ");
            if (con.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    System.out.println(strCurrentLine);
                }
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String strCurrentLine;
                while ((strCurrentLine = br.readLine()) != null) {
                    System.out.println(strCurrentLine);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String sendOTP(String mobileNo, String otp, String refNo) throws IOException {
        String responseString = null;

        String message = "Dear User, Your One Time Password (OTP) for patient verification is" + otp +
                ". Reference Number " + refNo +
                ". Dont share it with anyone. BSKY, Govt. of Odisha.";

        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://govtsms.odisha.gov.in/api/api.php");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("action", "singleSMS"));
            nameValuePairs.add(new BasicNameValuePair("department_id", "D006001"));
            nameValuePairs.add(new BasicNameValuePair("template_id", "1007480143063815155"));
            nameValuePairs.add(new BasicNameValuePair("sms_content", message));
            nameValuePairs.add(new BasicNameValuePair("phonenumber", mobileNo));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = client.execute(post);
            BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = bf.readLine()) != null) {
                responseString = line;
            }

            return responseString;
        } catch (Exception e) {
            throw e;
        }
    }
}
