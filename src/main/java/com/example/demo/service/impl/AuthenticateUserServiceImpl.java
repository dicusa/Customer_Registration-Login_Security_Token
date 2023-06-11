package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.service.AuthenticateUserService;

@Service
public class AuthenticateUserServiceImpl implements AuthenticateUserService{

@Autowired
private JwtTokenUtil jwtTokenUtil;

	@Override
	public  String generateOAuthToken(String clientID, String clientSecret ) throws AuthenticationCredentialsNotFoundException {
		if ("yash".equals(clientID) && "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6".equals(clientSecret)) {
			
return jwtTokenUtil.generateTempToken(clientID);
		} else {
			throw new AuthenticationCredentialsNotFoundException("Credential pair is incorrect");
		}
	}


}
