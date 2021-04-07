package com.HCL.Capstone.onlinemusicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.Cart;

public interface CartRepository extends JpaRepository <Cart, Long>{

}
