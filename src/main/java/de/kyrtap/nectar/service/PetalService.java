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
} 