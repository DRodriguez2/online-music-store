package com.HCL.Capstone.onlinemusicstore.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public abstract class Music extends Product{
	
	@Enumerated(EnumType.STRING)
	private Platform platform;
	
	@Enumerated(EnumType.STRING)
	private MusicType type;
	
	@NotEmpty(message="Value required")
	private String artist;
	
	/**
	 * Might want to create a native query for getting a list of genres so
	 * front end drop down can be populated dynamically.
	 */
	private String genre;
	
	
	
	public Music() {}

	public Music(String name, Category category, Double price, Platform platform, MusicType type, String artist, String genre) {
		super(name, category, price);
		this.type = type;
		this.platform = platform;
		this.artist = artist;
		this.genre = genre;
	}
}
