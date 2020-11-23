package com.example.humo2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping(value = "/api")
public class Cards {
    @PostMapping(value = "/balance")
    public String getBalance() throws IOException {
      /*
        System.out.println("hghgjhj");
        String cardNumber = "9860270101631892";
        String responseString = "";
        String outputString = "";
        String wsURL = "https://192.168.35.22:6677/";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:IIACardServices\">\n" +
                "                   <soapenv:Header/>\n" +
                "                   <soapenv:Body>\n" +
                "                   <urn:getCardAccountsBalance>\n" +
                "                   <primaryAccountNumber>" + cardNumber + "</primaryAccountNumber>\n" +
                "                   </urn:getCardAccountsBalance>\n" +
                "                   </soapenv:Body>\n" +
                "                   </soapenv:Envelope>";
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "";
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Authorization", "Basic d3NvZmI6MUYyZUp4QG0=");
        httpConn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        //Write the content of the request to the outputstream of the HTTP Connection.
        out.write(b);
        out.close();
        //Ready with sending the request.

        //Read the response.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        */

        return  new HumoGetApi().poster();
    }
}
