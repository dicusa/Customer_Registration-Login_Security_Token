package com.example.demo.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter{

	@Value("${jwt.secret}")
	private String secret;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization")==null
				?request.getHeader("Authorization")
				:request.getHeader("Authorization").substring(7);
		String URL  =request.getRequestURL().toString();
		System.out.println("token : "+token);
		if(URL.contains("customer/register") || URL.contains("customer/login")) {
			Boolean valid = jwtTokenUtil.validateToken(token, secret);
			if(valid) {
				// 5. Create auth object
				// UsernamePasswordAuthenticationToken: A built-in object, used by spring to represent the current authenticated / being authenticated user.
				// It needs a list of authorities, which has type of GrantedAuthority interface, where SimpleGrantedAuthority is an implementation of that interface
				 UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
								 secret, null,List.of());
				 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 // 6. Authenticate the user
				 // Now, user is authenticated
				 SecurityContextHolder.getContext().setAuthentication(auth);
				 filterChain.doFilter(request, response);
			}

		}
		else if (URL.contains("/getToken")) {
			filterChain.doFilter(request, response);
		}
		else {
			System.out.println("else");
			Boolean valid = jwtTokenUtil.validateToken(token);
			String userName= jwtTokenUtil.getUsernameFromToken(token);
			if(valid) {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
						userName, null,List.of());
		 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		 SecurityContextHolder.getContext().setAuthentication(auth);
			}
			filterChain.doFilter(request, response);
		}
		
		
	}

}
