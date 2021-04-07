package com.HCL.Capstone.onlinemusicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired private ProductRepository pr;
	
	public void savePoduct(Product product) {
		pr.save(product);
	}
	
	public void deleteProduct(Product product) {
		pr.delete(product);
	}
	
	public Product getProductById(Long id) throws ProductNotFoundException {
		Optional<Product> product = pr.findById(id);
		if(product.isPresent()) return product.get();
		else throw new ProductNotFoundException();
	}
	
	public List<Product> getAllProducts() {
		return pr.findAll();
	}
	
	public List<Product> getAllByNameContains(String input) throws ProductNotFoundException {
		Optional<List<Product>> products = pr.findAllByNameContainsIgnoreCase(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
	}
}
