/**
 * 
 */
package com.rahul.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.security.JwtDecoder;
import com.rahul.security.JwtEncoder;

import io.jsonwebtoken.Claims;

/**
 * @author rahul
   @since  06-Mar-2024 2024 11:18:25 am
 */
@RestController
@RequestMapping("/jwt")
public class SecurityController {
	@Autowired
	JwtEncoder jwtEncoder;
//    private final JwtEncoder jwtEncoder;
	
	@Autowired
	JwtDecoder jwtDecoder;

//    public JwtController(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
//        this.jwtEncoder = jwtEncoder;
//        this.jwtDecoder = jwtDecoder;
//    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestParam("clientId") String clientId,
                                                @RequestParam("clientSecret") String clientSecret,
                                                @RequestParam("aud") String aud) {
        String token = jwtEncoder.generateToken(clientId, clientSecret, aud);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/verify")
    public ResponseEntity<Claims> verifyToken(@RequestParam("token") String token) {
        Claims claims = jwtDecoder.decodeToken(token);
        return ResponseEntity.ok(claims);
    }
    
    @PostMapping(path  = "/post",consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPost() {
    	return "";
    }
    
}
