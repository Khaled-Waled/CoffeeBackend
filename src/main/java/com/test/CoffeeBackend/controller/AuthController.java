package com.test.CoffeeBackend.controller;

import com.test.CoffeeBackend.Security.JwtUtils;
import com.test.CoffeeBackend.dto.UserDTO;
import com.test.CoffeeBackend.dto.AuthResponseDTO;
import com.test.CoffeeBackend.dto.CustomUser;
import com.test.CoffeeBackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author khaled-waled
 * A Rest controller that provides login and signup APIs
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authentication")
public class AuthController
{
    @Autowired
    IAuthService authService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * Create user and register them in the system, allows the credentials to be used to log in later
     * @param request
     * @return ResponseEntity: containing the state of execution
     */
    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO request)
    {
        return authService.createNewUser(request);
    }

    /**
     * Login function that allows an existing user to log in to the system and receive a token
     * @param request
     * @return ResponseEntity: representing the state of the request and contains the JWT token if successful
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO request)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        return ResponseEntity.ok(new AuthResponseDTO(userDetails.getUsername(), jwt));
    }
}
