/**
 * 
 */
package com.rahul.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author rahul
   @since  06-Mar-2024 2024 11:23:39 am
 */
//@EnableRetry
@EnableAsync
@Configuration
@SpringBootApplication
//@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
public class SecurityApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/rahul");
		SpringApplication.run(SecurityApplication.class, args);
	}
}
