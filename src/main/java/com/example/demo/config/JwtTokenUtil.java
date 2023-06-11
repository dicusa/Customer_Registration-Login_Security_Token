package com.example.demo.config;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable{
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 *60 *60;
	
    @Value("${jwt.secret}")
	private String secret;
    
    @Autowired
	private UserRepository userRepository;
    
    public String generateToken(Customer userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUserName());
	}
    
    public String generateTempToken(String ClientID) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, ClientID);
	}

	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}
	
	 //for retrieveing any information from token we will need the secret key
	Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	//retrieve username from jwt token
		public String getUsernameFromToken(String token) {
			return getClaimFromToken(token, Claims::getSubject);
		}

		//retrieve expiration date from jwt token
		public java.util.Date getExpirationDateFromToken(String token) {
			return getClaimFromToken(token, Claims::getExpiration);
		}
		//check if the token has expired
		private Boolean isTokenExpired(String token) {
			final java.util.Date expiration = getExpirationDateFromToken(token);
			return expiration.before(new Date(System.currentTimeMillis()));
		}
		
		//validate token
		public Boolean validateToken(String token, String clientID) {
			final String username = getUsernameFromToken(token);
			return (username.equals(clientID) && !isTokenExpired(token));
		}
		
		//validate token
		public Boolean validateToken(String token) {
			final String username = getUsernameFromToken(token);
			Optional<Customer> tempUser = userRepository.findByUserName(username);
//			implement the logic to check if the current user has a active session
			return (tempUser.isPresent() && !isTokenExpired(token));
		}

		
		
		
	
	
}  
