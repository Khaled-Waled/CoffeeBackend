package com.test.CoffeeBackend.service;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthService
{
    public ResponseEntity<?> createNewUser(AuthRequestDTO request);
    public ResponseEntity<?> login(AuthRequestDTO request);
}
