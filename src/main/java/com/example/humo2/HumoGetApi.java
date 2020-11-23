package com.example.humo2;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class HumoGetApi {
    private final String proxyPort = "3128"; //your proxy port
    private final String proxyHost = "172.16.10.3";
    private final String cardNumber = "9860270101631892";

    public String poster( ) {

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {

            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

            public X509Certificate[] getAcceptedIssuers() {
                // or you can return null too
                return new X509Certificate[0];
            }
        }};
        String response = "";
        //System.getProperties().setProperty("https.proxyHost",proxyHost);
        //System.getProperties().setProperty("https.proxyPort",proxyPort);
        //System.getProperties().setProperty("http.proxyHost",proxyHost);
        //System.getProperties().setProperty("http.proxyPort",proxyPort);
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            System.out.println("Passed 1");
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String string, SSLSession sslSession) {
                return true;
            }
        });
        URL url = null;
        HttpsURLConnection conn = null;
        try {
            url = new URL("https://192.168.35.22:6677/");
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            System.out.println("Connection passed with server");
        } catch (IOException e) {
            System.out.println("connection Failed" + e.getMessage());
           // e.printStackTrace();
        }

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:IIACardServices\">\n" +
                "                   <soapenv:Header/>\n" +
                "                   <soapenv:Body>\n" +
                "                   <urn:getCardAccountsBalance>\n" +
                "                   <primaryAccountNumber>" + cardNumber + "</primaryAccountNumber>\n" +
                "                   </urn:getCardAccountsBalance>\n" +
                "                   </soapenv:Body>\n" +
                "                   </soapenv:Envelope>";
        conn.setRequestProperty("Content-Length", String.valueOf(xmlInput.length()));
        conn.setRequestProperty("Authorization", "Basic d3NvZmI6MUYyZUp4QG0=");
        conn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
        conn.setRequestProperty("SOAPAction", "");
        conn.setDoOutput(true);
        conn.setDoInput(true);
      /*String json ="{" +
              "\"id\": 123," +
              "\"jsonrpc\": \"2.0\"," +
              "\"method\": \"cards.new\"," +
              "\"params\": {" +
              "\"card\": {" +
              "\"expiry\": \"2411\"," +
              "\"pan\": \"8600572908232023\"" +
              "}" +
              "}" +
              "}";*/

        InputStream in=null;
        try {
            conn.connect();
            OutputStream os =conn.getOutputStream();
            os.write(xmlInput.getBytes());
            os.flush();
            os.close();
            in=new BufferedInputStream(conn.getInputStream());
            System.out.println("success sended");
        } catch (IOException e) {
            System.out.println("connection Failed in sending" + e.getMessage());
        }

        System.out.println(System.getProperties().toString());

        response = convertStreamToString(in);
        conn.disconnect();
        return response;

    }

    private String convertStreamToString(InputStream in) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        StringBuilder stringBuilder=new StringBuilder();
        String line;
        try{
            while ((line=reader.readLine())!=null)
                stringBuilder.append(line).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

}
