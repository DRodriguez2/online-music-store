package com.HCL.Capstone.onlinemusicstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;

public interface AccessoryRepository extends JpaRepository<Accessory, Long>{

	public Accessory findByName(String name);

	public Optional<List<Accessory>> findAllByNameContainsIgnoreCase(String name);
	
	public Optional<List<Accessory>> findAllByBrandContainsIgnoreCase(String Brand);
	
	public Optional<List<Accessory>> findAllByCatagory(Category catagory);
		
	@Query("SELECT DISTINCT m.name FROM Instrument m")
	public List<String> findAllUniqueName();
}
