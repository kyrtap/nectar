package de.kyrtap.nectar;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bee_id", nullable = false, unique = true)
    private Bee bee;

    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
    private Set<Petal> petals = new HashSet<>();

    // Getters and setters omitted for brevity
} 