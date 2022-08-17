package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController
{
    @Autowired
    IUserService userService;

    @GetMapping("/byToken/{token}")
    public ResponseEntity<?> getUserFromToken(@PathVariable String token)
    {
        AuthRequestDTO authRequestDTO = userService.getUserFromToken(token);
        if(authRequestDTO != null)
            return ResponseEntity.ok().body(authRequestDTO);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<?> getUserFromEmail(@PathVariable String email)
    {
        AuthRequestDTO authRequestDTO = userService.getUserFromEmail(email);
        if(authRequestDTO != null)
            return ResponseEntity.ok().body(authRequestDTO);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/update/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email,AuthRequestDTO authRequestDTO)
    {
        return userService.updateUser(email,authRequestDTO);
    }

    @DeleteMapping("/byEmail/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email)
    {
        return userService.deleteUser(email);
    }
}
