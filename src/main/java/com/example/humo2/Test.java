package com.example.humo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

public class Test {
    private static RestTemplate restTemplate = new RestTemplate();

    private static final String uri = "http://10.10.120.123:8080/api/balance";
    private static final String request = "<PaymentCardRequest5 xmlns=\"http://bssys.com/sbns/integration\">\n" +
            " <head>\n" +
            "  <Head>\n" +
            "   <branchId>01071</branchId>\n" +
            "   <customerId>591840</customerId>\n" +
            "  </Head>\n" +
            " </head>\n" +
            "</PaymentCardRequest5>";

    public static void main(String[] args) {
        String phoneNumber = "998907121542";
        if(phoneNumber.contains("998907121542")){
            System.out.println("yes");
        }
    }

    private static void Test() {
        HttpHeaders httpHeaders = new HttpHeaders();
        //  httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        httpHeaders.set("Content-Type","application/xml");
        for(int i = 1 ; i <= 1 ;i ++)
        {

            long startTime = System.nanoTime();
            HttpEntity<String> entity = new HttpEntity<String>(request,httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST,entity,String.class);

            if(response.getStatusCode().is2xxSuccessful()){
                System.out.println(response);
                System.out.println("success " + i);
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            long convert = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);
            System.out.println(totalTime + " Second: " + convert + " Request " + i);



        }
    }
}
