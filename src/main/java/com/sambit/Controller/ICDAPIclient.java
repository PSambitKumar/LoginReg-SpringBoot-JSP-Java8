package com.sambit.Controller;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 13-Sep-2023 : 4:31 PM
 */

public class ICDAPIclient {

    private final String TOKEN_ENPOINT = "https://icdaccessmanagement.who.int/connect/token";
    private final String CLIENT_ID = "5e21d5c7-6c25-4140-8608-78e60c063460_4c9564d0-a469-488e-a083-9e840d1a540f";
    private final String CLIENT_SECRET = "JwRksCpPOuXdEiks0t66rDhEdFHE2jm5OOaaX65NCbw=";
    private final String SCOPE = "icdapi_access";
    private final String GRANT_TYPE = "client_credentials";


    public static void main(String[] args) throws Exception {

        String uri = "https://id.who.int/icd/entity";

        ICDAPIclient api = new ICDAPIclient();
        String token = api.getToken();
        System.out.println("URI Response JSON : \n" + api.getURI(token, uri));
    }


    // get the OAUTH2 token
    private String getToken() throws Exception {

        System.out.println("Getting token...");

        URL url = new URL(TOKEN_ENPOINT);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        // set parameters to post
        String urlParameters =
                "client_id=" + URLEncoder.encode(CLIENT_ID, "UTF-8") +
                        "&client_secret=" + URLEncoder.encode(CLIENT_SECRET, "UTF-8") +
                        "&scope=" + URLEncoder.encode(SCOPE, "UTF-8") +
                        "&grant_type=" + URLEncoder.encode(GRANT_TYPE, "UTF-8");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        // response
        int responseCode = con.getResponseCode();
        System.out.println("Token Response Code : " + responseCode + "\n");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // parse JSON response
        JSONObject jsonObj = new JSONObject(response.toString());
        return jsonObj.getString("access_token");
    }


    // access ICD API
    private String getURI(String token, String uri) throws Exception {

        System.out.println("Getting URI...");

        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // HTTP header fields to set
        con.setRequestProperty("Authorization", "Bearer "+token);
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Accept-Language", "en");
        con.setRequestProperty("API-Version", "v2");

        // response
        int responseCode = con.getResponseCode();
        System.out.println("URI Response Code : " + responseCode + "\n");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

}
