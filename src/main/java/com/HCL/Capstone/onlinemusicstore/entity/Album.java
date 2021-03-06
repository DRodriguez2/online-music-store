package com.HCL.Capstone.onlinemusicstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;

import lombok.Getter;

@Entity
@Getter
public class Album extends Music{
	
	@OneToMany(mappedBy="album", cascade = {CascadeType.ALL})
	List<Song> songs = new ArrayList<>();
	
	public Album() {}

	public Album(String name, Category category, Double price, Platform platform, MusicType type, String artist, String genre) {
		super(name, category, price, platform, type, artist, genre);
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	public void deleteSong(Song song) {
		this.songs.remove(song);
	}
	
}
