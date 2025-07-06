package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
} 