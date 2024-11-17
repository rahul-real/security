/**
 * 
 */
package com.rahul.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * @author rahul
   @since  06-Mar-2024 2024 11:17:21 am
 */
@Component
public class JwtDecoder {
    private final String jwtSecret;
    private final byte[] secretKey;

    public JwtDecoder(@Value("${jwt.secret}") String jwtSecret) {
        this.jwtSecret = jwtSecret;
        this.secretKey = Base64.getEncoder().encode(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public Claims decodeToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
