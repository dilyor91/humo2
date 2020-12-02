package com.example.humo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Humo2Application {

    public static void main(String[] args) {
        System.setProperty("server.port","9090");
        System.setProperty("server.tomcat.max-threads","200");
        System.setProperty("server.connection-timeout","60000");
        SpringApplication.run(Humo2Application.class, args);
    }

}
