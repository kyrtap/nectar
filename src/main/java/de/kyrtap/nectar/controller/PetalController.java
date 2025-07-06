package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.model.Petal;
import de.kyrtap.nectar.service.PetalService;
import de.kyrtap.nectar.dto.PetalNameRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/petals")
public class PetalController {
    private final PetalService petalService;

    public PetalController(PetalService petalService) {
        this.petalService = petalService;
    }

    @GetMapping
    public List<Petal> getAllPetals() {
        return petalService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Petal> getPetalById(@PathVariable Long id) {
        return petalService.findById(id);
    }

    @PostMapping
    public Petal createPetal(@AuthenticationPrincipal User user, @Valid @RequestBody PetalNameRequest request) {
        return petalService.createPetalForOwner(user.getUsername(), request.getName());
    }

    @PutMapping("/{petalId}")
    public Petal renamePetal(@PathVariable Long petalId, @AuthenticationPrincipal User user, @Valid @RequestBody PetalNameRequest request) {
        return petalService.renamePetalForOwner(petalId, user.getUsername(), request.getName());
    }

    @DeleteMapping("/{petalId}")
    public void deletePetal(@PathVariable Long petalId, @AuthenticationPrincipal User user) {
        petalService.deletePetalForOwner(petalId, user.getUsername());
    }
} 