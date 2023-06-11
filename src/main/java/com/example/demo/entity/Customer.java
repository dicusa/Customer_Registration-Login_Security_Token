package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Customer {

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long userId;
	 private String userName;
	 private String userEmail;
	 private String userAddress;
	 private String password;	
	 public String getUserName() {
		 return userName;
	 }
	 public void setUserName(String userName) {
		 this.userName = userName;
	 }
	 public String getUserEmail() {
		 return userEmail;
	 }
	 public void setUserEmail(String userEmail) {
		 this.userEmail = userEmail;
	 }
	 public String getUserAddress() {
		 return userAddress;
	 }
	 public void setUserAddress(String userAddress) {
		 this.userAddress = userAddress;
	 }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
