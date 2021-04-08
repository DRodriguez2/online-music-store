package com.HCL.Capstone.onlinemusicstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByUsername(String username);
}
