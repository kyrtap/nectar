package de.kyrtap.nectar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class BeeProfileUpdateRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String displayName;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
} 