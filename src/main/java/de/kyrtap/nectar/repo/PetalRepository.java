package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Petal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetalRepository extends JpaRepository<Petal, Long> {
} 