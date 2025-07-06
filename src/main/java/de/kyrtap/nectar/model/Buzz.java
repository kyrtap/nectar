package de.kyrtap.nectar.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Buzz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String content;

    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Bee author;

    @ManyToMany
    @JoinTable(
        name = "buzz_petal",
        joinColumns = @JoinColumn(name = "buzz_id"),
        inverseJoinColumns = @JoinColumn(name = "petal_id")
    )
    private Set<Petal> petals = new HashSet<>();
} 