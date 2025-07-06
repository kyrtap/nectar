package de.kyrtap.nectar.util;

import de.kyrtap.nectar.model.Bee;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    private final String jwtSecret = "replace_this_with_a_secure_secret";
    private final long jwtExpirationMs = 86400000; // 1 day

    public String generateToken(Bee bee) {
        // TODO: Implement token generation
        return null;
    }

    public boolean validateToken(String token) {
        // TODO: Implement token validation
        return false;
    }

    public String getUsernameFromToken(String token) {
        // TODO: Extract username from token
        return null;
    }
} 