package com.example.humo2;

import com.example.humo2.dto.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<ClientDto> getBalance(@RequestBody ClientDto clientDto) throws IOException {
        return  ResponseEntity.ok(clientDto);
    }
}
