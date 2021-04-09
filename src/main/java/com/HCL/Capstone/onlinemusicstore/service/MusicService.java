package com.HCL.Capstone.onlinemusicstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoAlbumsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoSongsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.repository.MusicRepository;

@Service
public class MusicService {

	@Autowired
	private MusicRepository mr;

	public Music getMusicById(Long id) throws MusicNotFoundException {
		Optional<Music> music = mr.findMusicById(id);
		if(music.isPresent()) return music.get();
		else throw new MusicNotFoundException();
	}
	
	public Music getMusicByNameAndType(String name, MusicType type) throws MusicNotFoundException {
		Optional<Music> music = mr.findMusicByNameAndType(name, type);
		if(music.isPresent()) return music.get();
		else throw new MusicNotFoundException();
	}
	
	public List<String> getAllGenres() {
		return mr.findAllUniqueGenres();
	}
	
	public List<Music> getAllMusic() {
		return mr.findAll();
	}
	
	//***********************************ADMIN METHODS********************************************************
	public void deleteMusic(Music music) {
		mr.delete(music);
	}
	
	public void saveMusic(Music music) {
		mr.save(music);
	}
	
	
	//***********************************ALBUM METHODS********************************************************
	
	public Album getAlbumById(Long id) throws MusicNotFoundException {
		Optional<Music> album = mr.findById(id);
		if(album.isPresent()) return (Album) album.get();
		else throw new MusicNotFoundException();
	}
	public Album getAlbumByName(String name) throws MusicNotFoundException {
		Optional<Music> music = mr.findMusicByNameAndType(name, MusicType.ALBUM);
		if(music.isPresent()) return (Album) music.get();
		else throw new MusicNotFoundException();
	}
	public List<Album> getAllAlbumByNameContaining(String userInput) throws MusicNotFoundException {
		Optional<List<Music>> albums = mr.findAllByNameContainsIgnoreCaseAndType(userInput, MusicType.ALBUM);
		if(albums.isPresent()) return albums.get().stream().map(music -> (Album) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	public List<Album> getAllAlbums() throws NoAlbumsInDatabaseException {
		Optional<List<Music>> albums = mr.findAllByType(MusicType.ALBUM);
		if(albums.isPresent()) return albums.get().stream().map(music -> (Album) music).collect(Collectors.toList());
		else throw new NoAlbumsInDatabaseException();
	}
	public List<Album> getAllAlbumsByArtist(String artist) throws MusicNotFoundException {
		Optional<List<Music>> albums = mr.findAllByArtistContainsIgnoreCaseAndType(artist, MusicType.ALBUM);
		if(albums.isPresent()) return albums.get().stream().map(music -> (Album) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	public List<Album> getAllAlbumsByGenre(String genre) throws MusicNotFoundException {
		Optional<List<Music>> albums = mr.findAllByGenreAndType(genre, MusicType.ALBUM);
		if(albums.isPresent()) return albums.get().stream().map(music -> (Album) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	public List<Album> getAllAlbumsByPlatform(Platform platform) throws MusicNotFoundException {
		Optional<List<Music>> albums = mr.findAllByPlatformAndType(platform, MusicType.ALBUM);
		if(albums.isPresent()) return albums.get().stream().map(music -> (Album) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	
	
	//***********************************SONG METHODS********************************************************
	public Song getSongById(Long id) throws MusicNotFoundException {
		Optional<Music> song = mr.findById(id);
		if(song.isPresent()) return (Song) song.get();
		else throw new MusicNotFoundException();
	}
	public Song getSongByName(String name) throws MusicNotFoundException {
		Optional<Music> music = mr.findMusicByNameAndType(name, MusicType.SONG);
		if(music.isPresent()) return (Song) music.get();
		else throw new MusicNotFoundException();
	}
	public List<Song> getAllSongsByNameContaining(String userInput) throws MusicNotFoundException {
		Optional<List<Music>> songs = mr.findAllByNameContainsIgnoreCaseAndType(userInput, MusicType.SONG);
		if(songs.isPresent()) return songs.get().stream().map(music -> (Song) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	public List<Song> getAllSongs() throws NoSongsInDatabaseException {
		Optional<List<Music>> songs = mr.findAllByType(MusicType.SONG);
		if(songs.isPresent()) return songs.get().stream().map(music -> (Song) music).collect(Collectors.toList());
		else throw new NoSongsInDatabaseException();
	}
	public List<Song> getAllSongsByArtist(String artist) throws MusicNotFoundException {
		Optional<List<Music>> songs = mr.findAllByArtistContainsIgnoreCaseAndType(artist, MusicType.SONG);
		if(songs.isPresent()) return songs.get().stream().map(music -> (Song) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	public List<Song> getAllSongsByGenre(String genre) throws MusicNotFoundException {
		Optional<List<Music>> songs = mr.findAllByGenreAndType(genre, MusicType.SONG);
		if(songs.isPresent()) return songs.get().stream().map(music -> (Song) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
	public List<Song> getAllSongsByPlatform(Platform platform) throws MusicNotFoundException {
		Optional<List<Music>> songs = mr.findAllByPlatformAndType(platform, MusicType.SONG);
		if(songs.isPresent()) return songs.get().stream().map(music -> (Song) music).collect(Collectors.toList());
		else throw new MusicNotFoundException();
	}
}

