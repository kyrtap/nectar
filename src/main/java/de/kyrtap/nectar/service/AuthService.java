package de.kyrtap.nectar.service;

import de.kyrtap.nectar.dto.RegistrationRequest;
import de.kyrtap.nectar.dto.LoginRequest;
import de.kyrtap.nectar.dto.AuthResponse;
import de.kyrtap.nectar.model.Bee;
import de.kyrtap.nectar.model.Flower;
import de.kyrtap.nectar.repo.BeeRepository;
import de.kyrtap.nectar.repo.FlowerRepository;
import de.kyrtap.nectar.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final BeeRepository beeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final FlowerRepository flowerRepository;

    public AuthService(BeeRepository beeRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, FlowerRepository flowerRepository) {
        this.beeRepository = beeRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.flowerRepository = flowerRepository;
    }

    public AuthResponse register(RegistrationRequest request) {
        if (beeRepository.findByUsername(request.getUsername()).isPresent() ||
            beeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Username or email already exists");
        }
        Bee bee = new Bee();
        bee.setUsername(request.getUsername());
        bee.setEmail(request.getEmail());
        bee.setPassword(passwordEncoder.encode(request.getPassword()));
        bee.setDisplayName(request.getDisplayName());
        beeRepository.save(bee);
        Flower flower = new Flower();
        flower.setBee(bee);
        flowerRepository.save(flower);
        String token = jwtUtil.generateToken(bee);
        return new AuthResponse(token, bee.getUsername(), bee.getDisplayName());
    }

    public AuthResponse login(LoginRequest request) {
        Bee bee = beeRepository.findByUsername(request.getUsernameOrEmail())
                .or(() -> beeRepository.findByEmail(request.getUsernameOrEmail()))
                .orElseThrow(() -> new RuntimeException("Invalid username/email or password"));
        if (!passwordEncoder.matches(request.getPassword(), bee.getPassword())) {
            throw new RuntimeException("Invalid username/email or password");
        }
        String token = jwtUtil.generateToken(bee);
        return new AuthResponse(token, bee.getUsername(), bee.getDisplayName());
    }
} 