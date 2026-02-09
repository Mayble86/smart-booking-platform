package com.olegf.spingapp.smartbookingplatform.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class JwtUtil {
    private String secret = "secret";

    public String generateToken(UserDetails userDetails) {
        return "fake-jwt-token";
    }

    public String extractUsername(String token) {
        return "test@test.com";
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
