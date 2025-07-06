package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.dto.BeeProfileResponse;
import de.kyrtap.nectar.dto.BeeProfileUpdateRequest;
import de.kyrtap.nectar.model.Bee;
import de.kyrtap.nectar.repo.BeeRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/me")
public class ProfileController {
    private final BeeRepository beeRepository;

    public ProfileController(BeeRepository beeRepository) {
        this.beeRepository = beeRepository;
    }

    @GetMapping
    public BeeProfileResponse getProfile(@AuthenticationPrincipal User user) {
        Bee bee = beeRepository.findByUsername(user.getUsername()).orElseThrow();
        return new BeeProfileResponse(bee.getUsername(), bee.getEmail(), bee.getDisplayName(), bee.getCreatedAt());
    }

    @PutMapping
    public BeeProfileResponse updateProfile(@AuthenticationPrincipal User user, @Valid @RequestBody BeeProfileUpdateRequest updateRequest) {
        Bee bee = beeRepository.findByUsername(user.getUsername()).orElseThrow();
        bee.setEmail(updateRequest.getEmail());
        bee.setDisplayName(updateRequest.getDisplayName());
        beeRepository.save(bee);
        return new BeeProfileResponse(bee.getUsername(), bee.getEmail(), bee.getDisplayName(), bee.getCreatedAt());
    }
} 