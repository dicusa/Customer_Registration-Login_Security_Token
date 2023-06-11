package com.example.demo.facade;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Customer;
import com.example.demo.service.UserService;

public class UserFacade {

	private UserService userService;
	
	public Customer createUser(Customer customer) {
		// TODO Auto-generated method stub
		return userService.createUser(customer);
	}
	
	public List<Customer> fetchAllUser(Pageable pageable) {
		// TODO Auto-generated method stub
		return userService.fetchUserList(pageable);
	}

	public Customer updateUser(Customer customer) {
		// TODO Auto-generated method stub
		return userService.updateUser(customer);
	}

	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userService.deleteUser(userId);;
	}
	public String loginUser(Customer customer) {
		return userService.loginUser(customer);
		
	}
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}




	
	
}
