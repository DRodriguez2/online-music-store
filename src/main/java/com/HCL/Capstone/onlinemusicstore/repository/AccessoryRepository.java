package com.HCL.Capstone.onlinemusicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Long>{

	public Accessory findByName(String name);
}
