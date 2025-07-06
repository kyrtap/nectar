package de.kyrtap.nectar.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Petal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;

    @ManyToMany
    @JoinTable(
        name = "petal_bee",
        joinColumns = @JoinColumn(name = "petal_id"),
        inverseJoinColumns = @JoinColumn(name = "bee_id")
    )
    private Set<Bee> members = new HashSet<>();

    @ManyToMany(mappedBy = "petals")
    private Set<Buzz> buzzes = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Flower getFlower() {
        return flower;
    }
} 
