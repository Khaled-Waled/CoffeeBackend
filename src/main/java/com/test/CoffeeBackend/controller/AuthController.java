package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.repository.UserRepository;
import com.test.CoffeeBackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthController
{
    @Autowired
    IAuthService authService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody AuthRequestDTO request)
    {
        return authService.createNewUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request)
    {
        return authService.login(request);
    }
}