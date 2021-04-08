package com.HCL.Capstone.onlinemusicstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

	public Instrument findByName(String name);

	public Optional<List<Instrument>> findAllByNameContainsIgnoreCase(String name);
	
	public Optional<List<Instrument>> findAllByBrandContainsIgnoreCase(String Brand);
	
	public Optional<List<Instrument>> findAllByCatagory(Category catagory);
		
	@Query("SELECT DISTINCT m.name FROM Instrument m")
	public List<String> findAllUniqueName();
}
