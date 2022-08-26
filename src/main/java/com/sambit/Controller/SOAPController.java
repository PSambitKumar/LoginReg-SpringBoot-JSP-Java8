package com.sambit.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//@Sambit Kumar Pradhan
@RestController
public class SOAPController {

    @GetMapping(value = "/checkGepNIC/{gepNIC}")
    public String checkGepNIC(@PathVariable("gepNIC")String gepNIC) throws MalformedURLException, IOException, JAXBException {
        System.out.println(gepNIC);
        String copyGepNIC = gepNIC;
        if (copyGepNIC.length() != 15)
            System.out.println("GepNIC ID Must be 15 Characters!");
        else if (copyGepNIC.substring(0, 7).matches("^[a-zA-Z]*$") && copyGepNIC.substring(7, 14).matches("^[0-9]*$") && copyGepNIC.substring(14, 15).matches("^[a-zA-Z0-9]*$"))
            System.out.println("Validated GepNIC");
        else
            System.out.println("GepNIC ID Must First 7 Must be Alphabetic, Next 7 Must be Numbers, and Next 1 Must Be AlphaNumeric!");


//        SOAP API Calling
        String responseString = "";
        String outputString = "";
        OutputStream outputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        String wsURL = "https://demoeproc.nic.in/nicgep_general_webservice/services/TechnicalService.TechnicalServiceHttpsSoap11Endpoint";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection)connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tec=\"http://technicalservices.webservice.nic.gov\">\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <tec:VerifyGePID>\n" +
                "            <!--Optional:-->\n" +
                "            <tec:GepID>" + copyGepNIC + "</tec:GepID>\n" +
                "        </tec:VerifyGePID>\n" +
                "    </soapenv:Body>\n" +
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


        outputStream.write(b);
        outputStream.close();

        inputStreamReader = new InputStreamReader(httpConn.getInputStream());
        bufferedReader = new BufferedReader( inputStreamReader);

        while ((responseString = bufferedReader.readLine()) != null) {
            outputString = outputString + responseString ;
        }


        System.out.println("String : " + outputString.toString());
        if (outputString.contains("GePID Verified Successfully")){
            System.out.println("Success");
        }
        else
            System.out.println("Fail");


        return outputString.toString();
    }
}


//        Sample GePIDs in GePNIC
//        UCAADPR3318542O
//        PCAADPR24185417
//        MCAADPR2718540H
//        TCAADPR3318539E
//        TCAADPR3318538N
//        ACAADPR27185370
//        ACAADPR2318536A
//        MCAADPR33185357
//        XCAADPR22185345
//        ACAADPR2218533B
