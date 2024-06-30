package com.example.tipani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TipaniApplication {

    public static void main(String[] args) {

        System.out.println(System.getProperty("java.version"));

        SpringApplication.run(TipaniApplication.class, args);

    }

}
