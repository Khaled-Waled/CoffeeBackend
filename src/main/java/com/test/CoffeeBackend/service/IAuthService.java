package com.test.CoffeeBackend.service;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * An interface of
 *
 * @author khaled-waled
 */
public interface IAuthService
{
    public ResponseEntity<?> createNewUser(AuthRequestDTO request);
    public ResponseEntity<?> login(AuthRequestDTO request);

    UserDetails loadUserByUsername(String email);
}
