package com.test.CoffeeBackend.service.impl;


import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.dto.AuthResponseDTO;
import com.test.CoffeeBackend.entity.AppUser;
import com.test.CoffeeBackend.repository.UserRepository;
import com.test.CoffeeBackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
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
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> createNewUser(AuthRequestDTO request)
    {
        try
        {
            AppUser userEntity =
                    new AppUser(
                            request.getEmail(),
                            passwordEncoder.encode(request.getPassword()),
                            request.getFullName()
                    );
            userRepository.save(userEntity);
            return ResponseEntity.ok().body("Saved");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad creds");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        AppUser appUser = userRepository.findByEmail(email);
        if(appUser == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(appUser.getEmail(), appUser.getPassword(),new ArrayList<>());
    }

    @Override
    public ResponseEntity<?> login(AuthRequestDTO request)
    {
        //TODO
        return null;
    }
}
