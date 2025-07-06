package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.model.Bee;
import de.kyrtap.nectar.service.BeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bees")
public class BeeController {
    private final BeeService beeService;

    public BeeController(BeeService beeService) {
        this.beeService = beeService;
    }

    @GetMapping
    public List<Bee> getAllBees() {
        return beeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Bee> getBeeById(@PathVariable Long id) {
        return beeService.findById(id);
    }

    @PostMapping
    public Bee createBee(@RequestBody Bee bee) {
        return beeService.save(bee);
    }

    @DeleteMapping("/{id}")
    public void deleteBee(@PathVariable Long id) {
        beeService.deleteById(id);
    }
} 