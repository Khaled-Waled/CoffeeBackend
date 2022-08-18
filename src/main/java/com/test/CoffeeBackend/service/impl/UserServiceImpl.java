package com.test.CoffeeBackend.service.impl;

import com.test.CoffeeBackend.Security.JwtUtils;
import com.test.CoffeeBackend.dto.UserDTO;
import com.test.CoffeeBackend.entity.AppUser;
import com.test.CoffeeBackend.repository.UserRepository;
import com.test.CoffeeBackend.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers()
    {
        List<AppUser> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        users.forEach(user ->
                usersDTO.add(modelMapper.map(user, UserDTO.class)));
        return usersDTO;
    }

    @Override
    public UserDTO getUserFromToken(String token)
    {
        String email = jwtUtils.getUserNameFromJwtToken(token);
        return getUserFromEmail(email);
    }

    @Override
    public UserDTO getUserFromEmail(String email)
    {
        AppUser user = userRepository.findByEmail(email);
        if(user==null)
        {
            return null;
        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public ResponseEntity<?> updateUser(String email, UserDTO userDTO)
    {
        AppUser user = userRepository.findByEmail(email);
        if(user==null)
            return ResponseEntity.badRequest().build();

        if(userDTO.getFullName()!=null)
            user.setFullName(userDTO.getFullName());
        if(userDTO.getPassword()!=null)
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

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
