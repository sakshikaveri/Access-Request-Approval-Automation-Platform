package com.example.access_management.controller;

import com.example.access_management.dto.SignUpRequest;
import com.example.access_management.entity.User;
import com.example.access_management.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {

        @Autowired
        private userRepository userRepository;

        @PostMapping("/signup")
        public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {

            if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body("Email already exists");
            }

            User user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword()); // encryption later
            user.setRole(request.getRole());

            userRepository.save(user);

            return ResponseEntity.ok("User registered successfully");
        }
    }

