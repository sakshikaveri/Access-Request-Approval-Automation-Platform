package com.example.access_management.controller;

import com.example.access_management.dto.LoginRequest;
import com.example.access_management.dto.SignUpRequest;
import com.example.access_management.entity.User;
import com.example.access_management.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {

        private final PasswordEncoder passwordEncoder;

        public AuthController(PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
        }

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
            user.setPassword(passwordEncoder.encode(request.getPassword())); // encode password
            user.setRole(request.getRole());
            userRepository.save(user);

            return ResponseEntity.ok("User registered successfully");
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest request) {

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid email or password");
            }

            return ResponseEntity.ok("Login successful");
        }
    }

