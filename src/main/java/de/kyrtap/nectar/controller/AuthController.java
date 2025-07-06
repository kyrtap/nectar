package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.dto.RegistrationRequest;
import de.kyrtap.nectar.dto.LoginRequest;
import de.kyrtap.nectar.dto.AuthResponse;
import de.kyrtap.nectar.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegistrationRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
} 