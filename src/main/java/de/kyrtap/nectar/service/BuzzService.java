package de.kyrtap.nectar.service;

import de.kyrtap.nectar.model.Buzz;
import de.kyrtap.nectar.repo.BuzzRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BuzzService {
    private final BuzzRepository buzzRepository;

    public BuzzService(BuzzRepository buzzRepository) {
        this.buzzRepository = buzzRepository;
    }

    public List<Buzz> findAll() {
        return buzzRepository.findAll();
    }

    public Optional<Buzz> findById(Long id) {
        return buzzRepository.findById(id);
    }

    public Buzz save(Buzz buzz) {
        return buzzRepository.save(buzz);
    }

    public void deleteById(Long id) {
        buzzRepository.deleteById(id);
    }
} 