package com.HCL.Capstone.onlinemusicstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;

public interface MusicRepository extends JpaRepository<Music, Long>{
	
	public Music findMusicByName(String name);

	public Optional<Music> findMusicByNameAndType(String name, MusicType type);
	
	public Optional<List<Music>> findAllByNameContainsIgnoreCaseAndType(String name, MusicType type);
	
	public Optional<List<Music>> findAllByType(MusicType type);
	
	public Optional<List<Music>> findAllByPlatformAndType(Platform platform, MusicType type);
	
	public Optional<List<Music>> findAllByArtistContainsIgnoreCaseAndType(String artist, MusicType type);
	
	public Optional<List<Music>> findAllByGenreAndType(String genre, MusicType type);
	
	@Query("SELECT DISTINCT m.genre FROM Music m")
	public List<String> findAllUniqueGenres();
}
