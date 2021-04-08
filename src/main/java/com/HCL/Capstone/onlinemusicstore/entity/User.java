package com.HCL.Capstone.onlinemusicstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class User {

	@Id
	@GeneratedValue
	Long userID; 
	
	@NotEmpty(message = "Value required")
	String username; 

	@NotEmpty(message = "Value required") 
	String password; 
	
	@NotEmpty(message = "Value Required")
	String role; //TODO: needs a way to assign role with spring sec
	
//	@OneToOne
//	@JoinTable(name="USER_CART", 
//	   joinColumns = @JoinColumn(name="USER_ID"),
//	   inverseJoinColumns = @JoinColumn(name="CART_ID"))
//	Integer cartID; 
	
	@Transient
	List<Product> userCart = new ArrayList<>();
	
	Integer creditCard; 
	
	public User(String username, String password, String role, Integer creditCard) { 
		super(); 
		this.username = username; 
		this.password = password; 
		this.role = role; 
		this.creditCard = creditCard; 
	}
	
	public void addProduct(Product product) {
		userCart.add(product);
	}
	
	
	@Override 
	public String toString()  { 
		return "User Info [userID=" + userID + ", username=" + username + ", password=" + password + ", cart=" + userCart.toString() + ", Credit Card # ="
				+ creditCard +"]";
	}
	

}
