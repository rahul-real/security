/**
 * 
 */
package com.rahul.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  01-Mar-2024 2024 7:45:52 pm
 */
@Component
@Order(1)
@WebFilter(urlPatterns = {"/*"}, filterName = "jwtSecurityFilter")
@ConditionalOnProperty(prefix = "rahul.bean", name = "jwtsecurity", havingValue = "true")
@Slf4j
public class JwtSecurityFilter {
	
	@Autowired
	ObjectMapper mapper;
	

}
