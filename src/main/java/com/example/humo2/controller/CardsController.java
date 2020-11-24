package com.example.humo2.controller;

import com.example.humo2.dto.ClientDto;
import com.example.humo2.service.GetAllBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api")
public class CardsController {


    @Autowired
    private GetAllBalance getAllBalance;




    @PostMapping(value = "/balance")
    public ResponseEntity<String> getBalance(@RequestBody ClientDto clientDto) throws IOException {
        return  ResponseEntity.ok(getAllBalance.response(clientDto));
    }

}
