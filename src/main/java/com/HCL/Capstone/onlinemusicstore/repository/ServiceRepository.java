package com.HCL.Capstone.onlinemusicstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;

public interface ServiceRepository extends JpaRepository<Services, Long>{

	public Services findByName(String name);
	
	public Optional<List<Services>> findAllByNameContainsIgnoreCase(String name);
		
	public Optional<List<Services>> findAllByCategory(Category category);
		
	@Query("SELECT DISTINCT m.name FROM Services m")
	public List<String> findAllUniqueName();
}
