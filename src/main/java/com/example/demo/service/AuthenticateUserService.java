package com.example.demo.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticateUserService {

	public String generateOAuthToken(String clientID, String clientSecret) throws UsernameNotFoundException;

}
