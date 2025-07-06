package de.kyrtap.nectar.service;

import de.kyrtap.nectar.model.Bee;
import de.kyrtap.nectar.repo.BeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BeeService {
    private final BeeRepository beeRepository;

    public BeeService(BeeRepository beeRepository) {
        this.beeRepository = beeRepository;
    }

    public List<Bee> findAll() {
        return beeRepository.findAll();
    }

    public Optional<Bee> findById(Long id) {
        return beeRepository.findById(id);
    }

    public Bee save(Bee bee) {
        return beeRepository.save(bee);
    }

    public void deleteById(Long id) {
        beeRepository.deleteById(id);
    }
} 