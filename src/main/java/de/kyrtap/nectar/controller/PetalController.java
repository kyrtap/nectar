package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.model.Petal;
import de.kyrtap.nectar.service.PetalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    public Petal createPetal(@RequestBody Petal petal) {
        return petalService.save(petal);
    }

    @DeleteMapping("/{id}")
    public void deletePetal(@PathVariable Long id) {
        petalService.deleteById(id);
    }
} 