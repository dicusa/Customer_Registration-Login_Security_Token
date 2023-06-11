package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Customer;

public interface UserService {

	Customer createUser(Customer customer);
	
	List<Customer> fetchUserList(Pageable pageable);
	
	Customer updateUser(Customer customer);
	
	void deleteUser(Long userId);
	
	Customer loadCustomerByUsername(String username);

	String loginUser(Customer customer);
	
}
