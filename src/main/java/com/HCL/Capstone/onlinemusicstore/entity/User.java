package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class User {

	@Id
	@GeneratedValue
	private Long userID; 
	
	@NotEmpty(message = "Value required")
	private String username; 

	@NotEmpty(message = "Value required") 
	private String password; 
	
	
	//Multiple roles should be separated by a comma
	@NotEmpty(message = "Value Required")
	private String role; 
	
	
	private long creditCard; 
	
	
	public User(String username, String password, String role, long creditCard) { 
		super(); 
		this.username = username; 
		this.password = password; 
		this.role = role; 
		this.creditCard = creditCard; 
	}

	public User() {
		super();
	}

	public String getUN(){ 
		return username;
	}
	public String getPass(){ 
		return password;
	}
	
	public long getCard(){ 
		return creditCard;
	}
	
	
	@Override 
	public String toString()  { 
		return "User Info [userID=" + userID + ", username=" + username + ", password=" + password + ", Credit Card # ="
				+ creditCard +"]";
	}



}
