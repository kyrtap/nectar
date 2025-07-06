package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Bee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeeRepository extends JpaRepository<Bee, Long> {
} 