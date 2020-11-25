package com.example.humo2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RunWith(SpringRunner.class)
class Humo2ApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    private final String uri = "http://10.10.120.123:8080/api/balance";
    private final String request = "<PaymentCardRequest5 xmlns=\"http://bssys.com/sbns/integration\">\n" +
            " <head>\n" +
            "  <Head>\n" +
            "   <branchId>01071</branchId>\n" +
            "   <customerId>591840</customerId>\n" +
            "  </Head>\n" +
            " </head>\n" +
            "</PaymentCardRequest5>";

    @Test
    void contextLoads() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        httpHeaders.set("Content-Type","application/xml");

        HttpEntity<String> entity = new HttpEntity<String>(request,httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST,entity,String.class);

        if(response.getStatusCode().is2xxSuccessful()){
            System.out.println(response);
        }


    }

}
