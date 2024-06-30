package com.example.tipani.tipani.login.service.impl;

import com.example.tipani.config.jwt.JwtService;
import com.example.tipani.tipani.entity.Employee;
import com.example.tipani.tipani.entity.Roles;
import com.example.tipani.tipani.login.AuthenticationRequest;
import com.example.tipani.tipani.login.AuthenticationResponse;
import com.example.tipani.tipani.login.RegisterRequest;
import com.example.tipani.tipani.login.service.AuthenticationService;
import com.example.tipani.tipani.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {


        var user = Employee.builder()
                .code(request.getCode())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.ADMIN)
                .build();
        employeeRepo.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getCode(),

                request.getPassword()
        ));

        var user = employeeRepo.findByCode(request.getCode())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        var role = user.getRole();

        return AuthenticationResponse.builder().token(jwtToken).role(role).build();
    }

}
