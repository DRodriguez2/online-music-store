package com.HCL.Capstone.onlinemusicstore.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;

import lombok.Getter;

@Entity
@Getter
public class Song extends Music{
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="SONG_ALBUM", 
	   joinColumns = @JoinColumn(name="SONG_ID"),
	   inverseJoinColumns = @JoinColumn(name="ALBUM_ID")
	)
	List<Album> albums = new ArrayList<>();
	
	public Song() {}

	public Song(String name, Category category, Double price, Platform platform, MusicType type, String artist, String genre) {
		super(name, category, price, platform, type, artist, genre);
	}
	
	public void addAlbum(Album album) {
		this.albums.add(album);
	}
	
	public void removeAlbum(Album album) {
		this.albums.remove(album);
	}
}
