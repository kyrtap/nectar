package de.kyrtap.nectar.dto;

public class AuthResponse {
    private String token;
    private String username;
    private String displayName;

    public AuthResponse(String token, String username, String displayName) {
        this.token = token;
        this.username = username;
        this.displayName = displayName;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
} 