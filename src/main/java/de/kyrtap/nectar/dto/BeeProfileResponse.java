package de.kyrtap.nectar.dto;

import java.time.Instant;

public class BeeProfileResponse {
    private String username;
    private String email;
    private String displayName;
    private Instant createdAt;

    public BeeProfileResponse(String username, String email, String displayName, Instant createdAt) {
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.createdAt = createdAt;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getDisplayName() { return displayName; }
    public Instant getCreatedAt() { return createdAt; }
} 