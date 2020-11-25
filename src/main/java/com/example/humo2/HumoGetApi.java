package com.example.humo2;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.net.ssl.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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


    public static String poster(String cardNumber) {

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
           // System.out.println("Passed 1");
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
            // System.out.println("Connection passed with server");
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


        InputStream in=null;
        try {
            conn.connect();
            OutputStream os =conn.getOutputStream();
            os.write(xmlInput.getBytes());
            os.flush();
            os.close();
            in=new BufferedInputStream(conn.getInputStream());
            //System.out.println("success sended");
        } catch (IOException e) {
            System.out.println("connection Failed in sending" + e.getMessage());
        }

    //    System.out.println(System.getProperties().toString());

        response = convertStreamToString(in);
        conn.disconnect();

        Document document = parseXmlFile(response);
        NodeList nodeList = document.getElementsByTagName("availableAmount");
        Double balanceResult = Double.parseDouble(nodeList.item(1).getTextContent());

        return   Double.toString(balanceResult/100);

    }

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String convertStreamToString(InputStream in) {
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
