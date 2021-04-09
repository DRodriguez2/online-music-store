package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Song extends Music{
	
	@ManyToOne
	private Album album;
	
	public Song() {}

	public Song(String name, Category category, Double price, Platform platform, MusicType type, String artist, String genre) {
		super(name, category, price, platform, type, artist, genre);
	}
	
}
