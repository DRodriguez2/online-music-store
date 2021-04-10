package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;

import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Value required")
	@Pattern(regexp="\\A(?!\\s*\\Z).+", message="Value required")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Digits(integer=5, fraction=2, message="invalid price")
	@Min(value = 0L, message = "invalid price")
	private Double price;
	
	public Product() {}

	public Product(String name, Category category, Double price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	};
	
}
