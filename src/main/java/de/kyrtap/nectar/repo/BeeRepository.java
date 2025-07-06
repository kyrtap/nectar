package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Bee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BeeRepository extends JpaRepository<Bee, Long> {
    Optional<Bee> findByUsername(String username);
    Optional<Bee> findByEmail(String email);
} 