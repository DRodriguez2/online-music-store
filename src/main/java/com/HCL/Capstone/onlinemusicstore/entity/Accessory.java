package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Accessory extends Product{
	
	@NotEmpty(message="Value required")
	private String description;
	
	@NotEmpty(message="Value required")
	private String brand;
	
	public Accessory() {}

	public Accessory(String name, Category category, Double price, String brand, String description) {
		super(name, category, price);
		this.description = description;
		this.brand = brand;
	}
	
}
