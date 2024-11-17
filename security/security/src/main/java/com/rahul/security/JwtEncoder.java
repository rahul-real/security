/**
 * 
 */
package com.rahul.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * @author rahul
   @since  06-Mar-2024 2024 11:10:44 am
 */
@Component
public class JwtEncoder {
    private final String jwtSecret;
    private final byte[] secretKey;

    public JwtEncoder(@Value("${jwt.secret}") String jwtSecret) {
        this.jwtSecret = jwtSecret;
        this.secretKey = Base64.getEncoder().encode(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String clientId, String clientSecret, String aud) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setIssuer("my-app")
                .setAudience(aud)
                .claim("client_id", clientId)
                .claim("client_secret", clientSecret)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.SECONDS)))
                .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS256)
                .compact();
    }
}
