package de.kyrtap.nectar.controller;

import de.kyrtap.nectar.model.Flower;
import de.kyrtap.nectar.service.FlowerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getAllFlowers() {
        return flowerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Flower> getFlowerById(@PathVariable Long id) {
        return flowerService.findById(id);
    }

    @PostMapping
    public Flower createFlower(@RequestBody Flower flower) {
        return flowerService.save(flower);
    }

    @DeleteMapping("/{id}")
    public void deleteFlower(@PathVariable Long id) {
        flowerService.deleteById(id);
    }
} 