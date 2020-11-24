package com.example.humo2;

import com.example.humo2.dto.ClientDto;
import com.example.humo2.service.GetAllBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class Cards {


    @Autowired
    private GetAllBalance getAllBalance;




    @PostMapping(value = "/balance")
    public ResponseEntity<String> getBalance(@RequestBody ClientDto clientDto) throws IOException {
        return  ResponseEntity.ok(getAllBalance.response(clientDto.getClient()));
    }

}
