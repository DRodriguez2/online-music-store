package com.HCL.Capstone.onlinemusicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
