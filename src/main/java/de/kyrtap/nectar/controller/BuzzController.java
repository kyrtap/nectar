package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.model.Buzz;
import de.kyrtap.nectar.service.BuzzService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buzzes")
public class BuzzController {
    private final BuzzService buzzService;

    public BuzzController(BuzzService buzzService) {
        this.buzzService = buzzService;
    }

    @GetMapping
    public List<Buzz> getAllBuzzes() {
        return buzzService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Buzz> getBuzzById(@PathVariable Long id) {
        return buzzService.findById(id);
    }

    @PostMapping
    public Buzz createBuzz(@RequestBody Buzz buzz) {
        return buzzService.save(buzz);
    }

    @DeleteMapping("/{id}")
    public void deleteBuzz(@PathVariable Long id) {
        buzzService.deleteById(id);
    }
} 