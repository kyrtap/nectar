package de.kyrtap.nectar.service;

import de.kyrtap.nectar.model.Petal;
import de.kyrtap.nectar.repo.PetalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetalService {
    private final PetalRepository petalRepository;

    public PetalService(PetalRepository petalRepository) {
        this.petalRepository = petalRepository;
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
        // TODO: Check if ownerUsername owns a flower, create petal in that flower
        return null;
    }

    public Petal renamePetalForOwner(Long petalId, String ownerUsername, String newName) {
        // TODO: Check if ownerUsername owns the flower containing the petal, then rename
        return null;
    }

    public void deletePetalForOwner(Long petalId, String ownerUsername) {
        // TODO: Check if ownerUsername owns the flower containing the petal, then delete
    }
} 