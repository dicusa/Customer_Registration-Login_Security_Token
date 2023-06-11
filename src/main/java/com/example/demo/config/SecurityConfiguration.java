package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfiguration  {
	
	@Autowired
	private AuthenticationFilter authenticationFilter;
	
	public static final String[] ENDPOINTS_WHITELIST = {
            "/getToken","/h2-console/**"
    };
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeHttpRequests()
		.requestMatchers(ENDPOINTS_WHITELIST).permitAll().anyRequest().authenticated();
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);   
        return http.build();
    }
}