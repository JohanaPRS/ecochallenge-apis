package com.backend.jwt.api.service;

import com.backend.jwt.api.entity.Desafio;
import com.backend.jwt.api.entity.User;
import com.backend.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }

    public User save(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setApellido_usuario(user.getApellido_usuario());
        newUser.setEdad_usuario(user.getEdad_usuario());
        newUser.setEmail(user.getEmail());
        newUser.setPassword((user.getPassword()));
        return repository.save(newUser);
    }

    public User userByUserName(String userName){
        return repository.findByUserName(userName);
    }

}
