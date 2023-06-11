package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface UserRepository extends CrudRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long>{

	Optional<Customer> findByUserName(String userName);
	
}
