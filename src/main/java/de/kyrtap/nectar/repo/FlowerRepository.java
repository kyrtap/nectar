package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Flower;
import de.kyrtap.nectar.model.Bee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
    Optional<Flower> findByBee(Bee bee);
} 