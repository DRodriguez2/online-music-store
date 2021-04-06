package com.HCL.Capstone.onlinemusicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HCL.Capstone.onlinemusicstore.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{
	
	public Music findMusicByName(String name);

}
