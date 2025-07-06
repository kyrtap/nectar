package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.dto.RegistrationRequest;
import de.kyrtap.nectar.dto.LoginRequest;
import de.kyrtap.nectar.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegistrationRequest request) {
        // TODO: Implement registration logic
        return null;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        // TODO: Implement login logic
        return null;
    }
} 