package com.HCL.Capstone.onlinemusicstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
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
	private String role; //TODO: needs a way to assign role with spring sec
	
//	@OneToOne
//	@JoinTable(name="USER_CART", 
//	   joinColumns = @JoinColumn(name="USER_ID"),
//	   inverseJoinColumns = @JoinColumn(name="CART_ID"))
//	Integer cartID; 
	
	
	private Integer creditCard; 
	
	
	public User() {};
	
	public User(String username, String password, String role, Integer creditCard) { 
		super(); 
		this.username = username; 
		this.password = password; 
		this.role = role; 
		this.creditCard = creditCard; 
	}
	

	
	
	@Override 
	public String toString()  { 
		return "User Info [userID=" + userID + ", username=" + username + ", password=" + password + ", Credit Card # ="
				+ creditCard +"]";
	}
	

}
