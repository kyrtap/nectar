package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Buzz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuzzRepository extends JpaRepository<Buzz, Long> {
} 