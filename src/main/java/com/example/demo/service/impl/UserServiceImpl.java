package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entity.Customer;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import jakarta.annotation.Resource;

public class UserServiceImpl implements UserService{
	
	private static final Exception NullPointerException = null;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.secret}")
	private String secret;

	@Override
	public Customer createUser(Customer customer) {
		// TODO Auto-generated method stub
		return userRepository.save(customer);
	}

	@Override
	public List<Customer> fetchUserList(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Customer> customerList =  userRepository.findAll(PageRequest.of(pageable.getPageNumber(),
				pageable.getPageSize(), Sort.by("userId").descending()));
		
		return customerList.getContent();
	}

	@Override
	public Customer updateUser(Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> tempUser = userRepository.findById(customer.getUserId());
		if(tempUser.isPresent()) {
			
		}
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}
	
	
	void validateNotNull(String string) throws Exception{
		if (Objects.isNull(string)
	            || string.isBlank()) {
	            throw NullPointerException;
	        }
	}

	@Override
	public Customer loadCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String loginUser(Customer customer) throws BadCredentialsException{
		// TODO Auto-generated method stub
		
		Optional<Customer> tempUser = userRepository.findByUserName(customer.getUserName());
		if(tempUser.isPresent() && tempUser.get().getPassword().equals(customer.getPassword())) {
			return jwtTokenUtil.generateToken(customer);
		}else {
			throw new BadCredentialsException("Username or password is incorrect");
		}
	
	}

	

}
