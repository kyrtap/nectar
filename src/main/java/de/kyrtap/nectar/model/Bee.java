package de.kyrtap.nectar.model;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
} 