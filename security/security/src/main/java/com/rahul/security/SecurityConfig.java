/**
 * 
 */
package com.rahul.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author rahul
   @since  06-Mar-2024 2024 11:40:16 am
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.csrf(csrf -> csrf.disable()) // Disable CSRF protection (not recommended for production)
        	.authorizeHttpRequests(requests -> requests
        	.requestMatchers("/jwt/generate").permitAll() // Allow access to /jwt/generate without authentication
            .anyRequest().authenticated()); // All other requests require authentication

        return http.build();
    }
}
