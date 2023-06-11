package com.example.demo.classes;


import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String clientID;
	private String clientSecret;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String clientID, String clientSecret) {
		this.setclientID(clientID);
		this.setclientSecret(clientSecret);
	}

	public String getclientID() {
		return this.clientID;
	}

	public void setclientID(String clientID) {
		this.clientID = clientID;
	}

	public String getclientSecret() {
		return this.clientSecret;
	}

	public void setclientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
}
