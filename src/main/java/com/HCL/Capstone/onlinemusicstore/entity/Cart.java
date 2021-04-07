package com.HCL.Capstone.onlinemusicstore.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity 
@Getter
public class Cart {
	
	@Id
	@GeneratedValue
	@OneToOne(mappedBy = "cartID")
	Long cartID; 
	
	List<Product> userCart; 
	
	
}
