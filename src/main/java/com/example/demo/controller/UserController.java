package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.classes.JwtResponse;
import com.example.demo.entity.Customer;
import com.example.demo.facade.UserFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private UserFacade userFacade;
	
	

	@PostMapping("/register")
	public Customer createUser(@RequestBody Customer customer) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(customer);
			System.out.println("===Cusotmer: "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userFacade.createUser(customer);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Customer customer) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(customer);
			System.out.println("===Cusotmer: "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = userFacade.loginUser(customer);
		return ResponseEntity.ok(new JwtResponse(response));
		
	}
	
	
	@PostMapping("/fetchAllUser")
	public ResponseEntity<List<Customer>> fetchAllUser(Pageable pageable) {
		return ResponseEntity.ok(userFacade.fetchAllUser(pageable));
		
	}
	
	@PostMapping("/updateUser")
	public Customer updateUser(@RequestParam Customer customer) {
		return userFacade.updateUser(customer);
		
	}
	
	@PostMapping("/deleteUser/{id}")
	public String updateUser(@PathVariable("id") Long userId) {
		 userFacade.deleteUser(userId);
		 return "Deleted Successfully";
		
	}
	
	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
}
