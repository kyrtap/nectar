package de.kyrtap.nectar.repo;

import de.kyrtap.nectar.model.Buzz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BuzzRepository extends JpaRepository<Buzz, Long> {
    // Additional query methods can be defined here
    List<Buzz> findByPetals_Id(Long petalId);
} 