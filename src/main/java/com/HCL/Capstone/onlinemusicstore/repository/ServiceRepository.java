package com.HCL.Capstone.onlinemusicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.Services;

public interface ServiceRepository extends JpaRepository<Services, Long>{

	public Services findByName(String name);
}
