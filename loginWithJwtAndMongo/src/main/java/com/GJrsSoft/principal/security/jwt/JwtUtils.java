package com.GJrsSoft.principal.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.GJrsSoft.principal.security.services.UserDetailsImpl;

import io.jsonwebtoken.*;



@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${jose.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${jose.app.jwtExpirationMs}")
	private String jwtExpiration;
	
	
	@SuppressWarnings("deprecation")
	public String generateJwtToken(Authentication auth) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) auth.getPrincipal();
		
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();

	}

	public boolean validateJwtToken(String jwt) {
		try {
			
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
			return true;
			
		} catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
			
			logger.error("Error al validar: {}", e.getMessage());
			
				
		}
		return false;
	}

	public String getUserNameFromJwtToken(String jwt) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();
	}

}
