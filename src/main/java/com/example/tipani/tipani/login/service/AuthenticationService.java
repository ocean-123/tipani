package com.example.tipani.tipani.login.service;

import com.example.tipani.tipani.login.AuthenticationRequest;
import com.example.tipani.tipani.login.AuthenticationResponse;
import com.example.tipani.tipani.login.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
