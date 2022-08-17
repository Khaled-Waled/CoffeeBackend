package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.Security.JwtUtils;
import com.test.CoffeeBackend.dto.AuthRequestDTO;
import com.test.CoffeeBackend.dto.AuthResponseDTO;
import com.test.CoffeeBackend.entity.AppUser;
import com.test.CoffeeBackend.entity.Product;
import com.test.CoffeeBackend.repository.UserRepository;
import com.test.CoffeeBackend.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public AuthRequestDTO getUserFromToken(String token)
    {
        String email = jwtUtils.getUserNameFromJwtToken(token);
        return getUserFromEmail(email);
    }

    @Override
    public AuthRequestDTO getUserFromEmail(String email)
    {
        AppUser user = userRepository.findByEmail(email);
        if(user==null)
        {
            return null;
        }
        return modelMapper.map(user,AuthRequestDTO.class);
    }

    @Override
    public ResponseEntity<?> updateUser(String email,AuthRequestDTO authRequestDTO)
    {
        AppUser user = userRepository.findByEmail(email);
        if(user==null)
            return ResponseEntity.badRequest().build();

        if(authRequestDTO.getFullName()!=null)
            user.setFullName(authRequestDTO.getFullName());
        if(authRequestDTO.getPassword()!=null)
            user.setPassword(authRequestDTO.getPassword());

        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> deleteUser(String email)
    {
        AppUser appUser = userRepository.findByEmail(email);
        if(appUser!=null)
        {
            userRepository.delete(appUser);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
