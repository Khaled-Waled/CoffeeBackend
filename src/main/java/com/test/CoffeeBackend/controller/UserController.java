package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.dto.UserDTO;
import com.test.CoffeeBackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author khaled-waled
 * A Rest controller that provides CRUD operation for the users
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController
{
    @Autowired
    IUserService userService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/byToken/{token}")
    public ResponseEntity<?> getUserFromToken(@PathVariable String token)
    {
        UserDTO userDTO = userService.getUserFromToken(token);
        if(userDTO != null)
            return ResponseEntity.ok().body(userDTO);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<?> getUserFromEmail(@PathVariable String email)
    {
        UserDTO userDTO = userService.getUserFromEmail(email);
        if(userDTO != null)
            return ResponseEntity.ok().body(userDTO);
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/update/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, UserDTO userDTO)
    {
        return userService.updateUser(email, userDTO);
    }

    @DeleteMapping("/byEmail/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email)
    {
        return userService.deleteUser(email);
    }
}
