package com.HCL.Capstone.onlinemusicstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.HCL.Capstone.onlinemusicstore.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {


	public Product findByName(String name);
  
  public Optional<List<Product>> findAllByNameContainsIgnoreCase(String name);

}
