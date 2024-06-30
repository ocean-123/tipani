package com.example.tipani.tipani.login.controller;

import com.example.tipani.tipani.login.AuthenticationRequest;
import com.example.tipani.tipani.login.AuthenticationResponse;
import com.example.tipani.tipani.login.RegisterRequest;
import com.example.tipani.tipani.login.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/check/auth")
public class AuthController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return   ResponseEntity.ok(service.register(request)) ;


    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return   ResponseEntity.ok(service.authenticate(request)) ;


    }
}
