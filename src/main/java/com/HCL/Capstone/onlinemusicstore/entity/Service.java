package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Service extends Product{
	
	@NotEmpty(message="Value required")
	String description;
	
	public Service() {}

	public Service(String name, Category category, Double price, String description) {
		super(name, category, price);
		this.description = description;
	}
}
