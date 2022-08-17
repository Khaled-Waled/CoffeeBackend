package com.test.CoffeeBackend.service;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService
{
    public List<AuthRequestDTO> getAllUsers();
    public AuthRequestDTO getUserFromToken(String token);
    public AuthRequestDTO getUserFromEmail(String email);
    public ResponseEntity<?> updateUser(String email,AuthRequestDTO authRequestDTO);
    public ResponseEntity<?> deleteUser(String email);
}
