package de.kyrtap.nectar.service;

import de.kyrtap.nectar.model.Petal;
import de.kyrtap.nectar.repo.PetalRepository;
import de.kyrtap.nectar.model.Bee;
import de.kyrtap.nectar.model.Flower;
import de.kyrtap.nectar.repo.BeeRepository;
import de.kyrtap.nectar.repo.FlowerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetalService {
    private final PetalRepository petalRepository;
    private final BeeRepository beeRepository;
    private final FlowerRepository flowerRepository;

    public PetalService(PetalRepository petalRepository, BeeRepository beeRepository, FlowerRepository flowerRepository) {
        this.petalRepository = petalRepository;
        this.beeRepository = beeRepository;
        this.flowerRepository = flowerRepository;
    }

    public List<Petal> findAll() {
        return petalRepository.findAll();
    }

    public Optional<Petal> findById(Long id) {
        return petalRepository.findById(id);
    }

    public Petal save(Petal petal) {
        return petalRepository.save(petal);
    }

    public void deleteById(Long id) {
        petalRepository.deleteById(id);
    }

    public Petal createPetalForOwner(String ownerUsername, String name) {
        Bee bee = beeRepository.findByUsername(ownerUsername)
                .orElseThrow(() -> new RuntimeException("Bee not found"));
        Flower flower = flowerRepository.findByBee(bee)
                .orElseThrow(() -> new RuntimeException("Flower not found for bee"));
        Petal petal = new Petal();
        petal.setName(name);
        petal.setFlower(flower);
        petalRepository.save(petal);
        return petal;
    }

    public Petal renamePetalForOwner(Long petalId, String ownerUsername, String newName) {
        Petal petal = petalRepository.findById(petalId)
                .orElseThrow(() -> new RuntimeException("Petal not found"));
        Flower flower = petal.getFlower();
        if (!flower.getBee().getUsername().equals(ownerUsername)) {
            throw new RuntimeException("Not authorized to rename this petal");
        }
        petal.setName(newName);
        petalRepository.save(petal);
        return petal;
    }

    public void deletePetalForOwner(Long petalId, String ownerUsername) {
        Petal petal = petalRepository.findById(petalId)
                .orElseThrow(() -> new RuntimeException("Petal not found"));
        Flower flower = petal.getFlower();
        if (!flower.getBee().getUsername().equals(ownerUsername)) {
            throw new RuntimeException("Not authorized to delete this petal");
        }
        petalRepository.delete(petal);
    }
} 