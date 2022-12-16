package com.sambit.Utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/12/2022 - 11:20 PM
 */
public class VerifyGepNIC {

    public static String verifyGepNIC(String gepNIC) throws IOException, JSONException {
        gepNIC = "DCAADPR2318544S";
        String panNumber = "CASPR2625C";
//        SOAP API Calling
        String responseString;
        String outputString = "";
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        String wsURL = "https://demoeproc.nic.in/nicgep_general_webservice/services/TechnicalService.TechnicalServiceHttpsSoap11Endpoint";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection)connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tec=\"http://technicalservices.webservice.nic.gov\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tec:VerifyGePID>\n" +
                "         <!--Optional:-->\n" +
                "         <tec:GepID>"+ gepNIC +"</tec:GepID>\n" +
                "         <!--Optional:-->\n" +
                "         <tec:PANNo>"+ panNumber +"</tec:PANNo>\n" +
                "      </tec:VerifyGePID>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        byte[] buffer;
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "VerifyGePID";

        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");

        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        outputStream = httpConn.getOutputStream();
        System.out.println("OUT  :" + outputStream );

        outputStream.write(b);
        outputStream.close();

        inputStreamReader = new InputStreamReader(httpConn.getInputStream());
        System.out.println("input Stream Reader : " + inputStreamReader);
        bufferedReader = new BufferedReader( inputStreamReader);
        System.out.println("Buffered Reader : " + bufferedReader);

        while ((responseString = bufferedReader.readLine()) != null) {
            outputString = outputString + responseString ;
            System.out.println(outputString);
        }

//        Convert XML to JSON
        JSONObject xmlJSONObj = XML.toJSONObject(outputString);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        System.out.println("JSON : " + jsonPrettyPrintString);
        System.out.println("Sta");

        if (outputString.contains("GePID Verified Successfully")){
            return "Success";
        }
        else
            return "Fail";
    }

    public static String GepNIC(String gepNIC) throws IOException, JSONException {
        gepNIC = "DCAADPR2318544S";
        String panNumber = "CASPR2625C";
//        SOAP API Calling
        String responseString;
        String outputString = "";
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        String wsURL = "https://demoeproc.nic.in/nicgep_general_webservice/services/TechnicalService.TechnicalServiceHttpsSoap11Endpoint";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection)connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tec=\"http://technicalservices.webservice.nic.gov\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tec:VerifyGePID>\n" +
                "         <!--Optional:-->\n" +
                "         <tec:GepID>"+ gepNIC +"</tec:GepID>\n" +
                "         <!--Optional:-->\n" +
                "         <tec:PANNo>"+ panNumber +"</tec:PANNo>\n" +
                "      </tec:VerifyGePID>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        byte[] buffer;
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "VerifyGePID";

        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");

        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        outputStream = httpConn.getOutputStream();
        System.out.println("OUT  :" + outputStream );

        outputStream.write(b);
        outputStream.close();

        inputStreamReader = new InputStreamReader(httpConn.getInputStream());
        System.out.println("input Stream Reader : " + inputStreamReader);
        bufferedReader = new BufferedReader( inputStreamReader);
        System.out.println("Buffered Reader : " + bufferedReader);

        while ((responseString = bufferedReader.readLine()) != null) {
            outputString = outputString + responseString ;
            System.out.println(outputString);
        }

//        Convert XML to JSON
        JSONObject xmlJSONObj = XML.toJSONObject(outputString);
        String jsonPrettyPrintString = xmlJSONObj.toString(4);
        System.out.println("JSON : " + jsonPrettyPrintString);

        return xmlJSONObj.toString();
    }
}
