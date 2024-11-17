/**
 * 
 */
package com.rahul.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rahul
   @since  06-Mar-2024 2024 11:16:33 am
 */
@Configuration
public class JwtConfig {
	
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Bean
    public JwtEncoder jwtEncoder() {
        return new JwtEncoder(jwtSecret);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return new JwtDecoder(jwtSecret);
    }
}
