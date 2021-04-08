package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;

import javax.validation.constraints.NotEmpty;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Instrument extends Product{
	
	@NotEmpty(message="Value required")
	private String type;
	
	@NotEmpty(message="Value required")
	private String brand;
	
	public Instrument() {}

	public Instrument(String name, Category category, Double price, String type, String brand) {
		super(name, category, price);
		this.type = type;
		this.brand = brand;
	}

	
}
