package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.classes.JwtRequest;
import com.example.demo.classes.JwtResponse;
import com.example.demo.service.AuthenticateUserService;

@RestController
public class IntegrationController {

	@Autowired
	private AuthenticateUserService authenticateUserService;
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
	@PostMapping("/getToken")
	public ResponseEntity<?> name(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
//			authenticate(authenticationRequest.getclientID(), authenticationRequest.getclientSecret());
			System.out.println("Inside Integration Controller");
			final String response = authenticateUserService
					.generateOAuthToken(authenticationRequest.getclientID(),authenticationRequest.getclientSecret());
			return ResponseEntity.ok(new JwtResponse(response));
		} catch (UsernameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ofNullable(null);
	}
	
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
}
