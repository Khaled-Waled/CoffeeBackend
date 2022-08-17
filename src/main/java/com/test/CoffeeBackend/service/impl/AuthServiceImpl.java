package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.dto.UserDTO;
import com.test.CoffeeBackend.dto.CustomUser;
import com.test.CoffeeBackend.entity.AppUser;
import com.test.CoffeeBackend.repository.UserRepository;
import com.test.CoffeeBackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class AuthServiceImpl implements IAuthService, UserDetailsService
{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;
    @Override
    public ResponseEntity<?> createNewUser(UserDTO request)
    {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // Create new user's account
        AppUser user = new AppUser(request.getEmail(),
                encoder.encode(request.getPassword()), request.getFullName());
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @Override
    public ResponseEntity<?> login(UserDTO request)
    {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        AppUser appUser = userRepository.findByEmail(email);

        if (appUser == null)
            throw new UsernameNotFoundException("Email " + email + " Not found");

        return new CustomUser(appUser.getEmail(),
                appUser.getPassword(),true, true, true,true,
                new ArrayList<>(), appUser.getFullName());
    }
}
