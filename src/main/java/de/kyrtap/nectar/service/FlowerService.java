package de.kyrtap.nectar.service;

import de.kyrtap.nectar.model.Flower;
import de.kyrtap.nectar.repo.FlowerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    public Optional<Flower> findById(Long id) {
        return flowerRepository.findById(id);
    }

    public Flower save(Flower flower) {
        return flowerRepository.save(flower);
    }

    public void deleteById(Long id) {
        flowerRepository.deleteById(id);
    }
} 