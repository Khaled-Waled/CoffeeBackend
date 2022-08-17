package com.test.CoffeeBackend.service;

import com.test.CoffeeBackend.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthService
{
    public ResponseEntity<?> createNewUser(UserDTO request);
    public ResponseEntity<?> login(UserDTO request);

    UserDetails loadUserByUsername(String email);
}
