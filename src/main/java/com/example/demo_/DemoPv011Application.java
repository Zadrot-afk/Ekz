package com.example.demo_;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoPv011Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoPv011Application.class, args);
    }


}
