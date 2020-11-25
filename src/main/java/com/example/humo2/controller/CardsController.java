package com.example.humo2.controller;

import com.example.humo2.HumoGetApi;
import com.example.humo2.dto.CardsDto;
import com.example.humo2.dto.ClientDto;
import com.example.humo2.service.GetAllBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CardsController {


    @Autowired
    private GetAllBalance getAllBalance;




    @PostMapping(value = "/balance")
    public ResponseEntity<String> getBalance(@RequestBody String request) throws IOException {
        Document document = HumoGetApi.parseXmlFile(request);
        String branchId = document.getElementsByTagName("branchId").item(0).getTextContent();
        String customerId = document.getElementsByTagName("customerId").item(0).getTextContent();
        System.out.println(branchId +" " + customerId);
        return  ResponseEntity.ok(getAllBalance.responseByXml(customerId,branchId));
    }

}
