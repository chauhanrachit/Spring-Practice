package com.practice.ExpenseTracker.security;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
//	byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded();
//  String base64Key = Base64.getEncoder().encodeToString(keyBytes);
//  System.out.println("Generated Secret Key: " + base64Key);
	private static final String SECRET_KEY = "your-secret-key-your-secret-key-your-secret-key"; // Must be 32+ chars
    private static final long EXPIRATION_TIME = 86400000; // 1 day
    
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    
    @Autowired
    private StringRedisTemplate redisTemplate; // Redis for token management
    
    public String generateToken(Map<String, Object> claims) {
    	
    	// Extract username from claims
        String username = (String) claims.get("sub");
    	
    	// 1️ Delete the old token (invalidate the old jti)
        String oldJti = redisTemplate.opsForValue().get(username);
        if (oldJti != null) {
            redisTemplate.delete("token:" + oldJti); // Remove previous token from Redis
        }
        // 2️ Generate a new Token ID (jti)
        String jti = UUID.randomUUID().toString();
        
        // 3️ Create a new token with jti (Token ID)
        claims.put("jti", jti);
        claims.put("iat", new Date());
        claims.put("exp", new Date(System.currentTimeMillis() + EXPIRATION_TIME));
        
        String newToken = Jwts.builder()
                .claims(claims)
                .signWith(key)
                .compact();
        
        // 4️ Store new token's jti in Redis (not the full token!)
        redisTemplate.opsForValue().set(username, jti, EXPIRATION_TIME, TimeUnit.MILLISECONDS);
        redisTemplate.opsForValue().set("token:" + jti, username, EXPIRATION_TIME, TimeUnit.MILLISECONDS);
        
		return newToken;
    }
    
    public String extractUsername(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (JwtException e) {
            return null; // Invalid token
        }
    }
    
    public boolean validateToken(String token, String username) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String tokenJti = claims.getId();
            String storedJti = redisTemplate.opsForValue().get(username);

            return tokenJti != null && tokenJti.equals(storedJti);
        } catch (JwtException e) {
            return false; // Invalid or expired token
        }
    }
    public void logout(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String jti = claims.getId();
            String username = claims.getSubject();

            // Remove token from Redis
            redisTemplate.delete(username);
            redisTemplate.delete("token:" + jti);
        } catch (JwtException e) {
            // Ignore invalid token
        }
    }
}
