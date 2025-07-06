package de.kyrtap.nectar;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String displayName;

    private Instant createdAt = Instant.now();

    @OneToOne(mappedBy = "bee", cascade = CascadeType.ALL)
    private Flower flower;

    @ManyToMany(mappedBy = "members")
    private Set<Petal> petals = new HashSet<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Buzz> buzzes = new HashSet<>();
} 