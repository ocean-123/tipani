package com.example.tipani.tipani.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApplication {
    @GetMapping
    public String test(){
        return "hello world";
    }
}
