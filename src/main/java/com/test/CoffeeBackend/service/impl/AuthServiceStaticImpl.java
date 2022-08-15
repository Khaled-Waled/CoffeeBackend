package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.dto.AuthResponseDTO;
import com.test.CoffeeBackend.entity.AppUser;
import com.test.CoffeeBackend.repository.UserRepository;
import com.test.CoffeeBackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceStaticImpl implements IAuthService
{
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> createNewUser(AuthRequestDTO request)
    {
        try
        {
            AppUser userEntity = new AppUser(request.getEmail(), request.getPassword());
            userRepository.save(userEntity);
            return ResponseEntity.ok().body("Saved");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad creds");
        }
    }

    @Override
    public ResponseEntity<?> login(AuthRequestDTO request)
    {
        if(request.getEmail().equals("user@mail.com") &&
                request.getPassword().equals("123"))
        {
            AuthResponseDTO authResponse = new AuthResponseDTO(request.getEmail(), "123");
            return ResponseEntity.ok().body(authResponse);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
