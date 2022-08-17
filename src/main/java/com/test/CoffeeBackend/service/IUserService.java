package com.test.CoffeeBackend.service;

import com.test.CoffeeBackend.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService
{
    public List<UserDTO> getAllUsers();
    public UserDTO getUserFromToken(String token);
    public UserDTO getUserFromEmail(String email);
    public ResponseEntity<?> updateUser(String email, UserDTO userDTO);
    public ResponseEntity<?> deleteUser(String email);
}
