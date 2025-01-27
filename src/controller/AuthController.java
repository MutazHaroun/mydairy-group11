package com.example.mydiary.controller;

import com.example.mydiary.model.User;
import com.example.mydiary.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        User registeredUser = authService.registerUser(user);
        return ResponseEntity.status(201).body(registeredUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody User user) {
        User authenticatedUser = authService.authenticate(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(authenticatedUser);
    }
}
