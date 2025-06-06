package com.example.nav.controller;

import com.example.nav.entity.User;
import com.example.nav.repository.UserRepository;
import com.example.nav.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public String login(@RequestBody User req) {
        Optional<User> userOpt = userRepository.findByUsername(req.getUsername());
        if (userOpt.isPresent() && encoder.matches(req.getPassword(), userOpt.get().getPassword())) {
            String token = JwtUtil.generateToken(req.getUsername());
            User user = userOpt.get();
            user.setToken(token);
            userRepository.save(user);
            return token;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
