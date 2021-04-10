package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Services extends Product{
	
	@NotEmpty(message="Value required")
	@Pattern(regexp="\\A(?!\\s*\\Z).+", message="Value required")
	String description;
	
	public Services() {}

	public Services(String name, Category category, Double price, String description) {
		super(name, category, price);
		this.description = description;
	}
}
