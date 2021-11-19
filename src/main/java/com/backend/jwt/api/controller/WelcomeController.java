package com.backend.jwt.api.controller;

import com.backend.jwt.api.entity.AuthRequest;
import com.backend.jwt.api.entity.User;
import com.backend.jwt.api.service.CustomUserDetailsService;
import com.backend.jwt.api.util.JwtUtil;
import com.backend.jwt.api.entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.backend.jwt.api.entity.JwtResponse;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to EcoChallenge !!";
    }
    @CrossOrigin(origins= {"http://localhost:3000"})
    @PostMapping("/user/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        final String token = jwtUtil.generateToken(authRequest.getUserName());

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @CrossOrigin(origins= {"http://localhost:3000"})
    @PostMapping(value = "/user/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

}
