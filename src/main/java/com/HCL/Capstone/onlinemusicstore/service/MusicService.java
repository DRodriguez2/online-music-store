package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Music;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
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
	
	public void insertAlbums() { 
		
		Album ab1 = new Album("Appetite for Destruction", Category.MUSIC, 9.99, Platform.DIGITAL, MusicType.ALBUM, "Guns n Roses", "Rock");
		
		Song so1 = new Song("Welcome to the Jungle", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so2 = new Song("It's So Easy", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so3 = new Song("Nightrain", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so4 = new Song("Out Ta Get Me", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so5 = new Song("Mr.Brownstone", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so6 = new Song("Paradise City", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so7 = new Song("My Michelle", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so8 = new Song("Think About You", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so9 = new Song("Sweet Child O' Mine", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so10 = new Song("You're Crazy", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so11 = new Song("Anything Goes", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so12 = new Song("Rocket Queen", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		so1.setAlbum(ab1);
		so2.setAlbum(ab1);
		so3.setAlbum(ab1);
		so4.setAlbum(ab1);
		so5.setAlbum(ab1);
		so6.setAlbum(ab1);
		so7.setAlbum(ab1);
		so8.setAlbum(ab1);
		so9.setAlbum(ab1);
		so10.setAlbum(ab1);
		so11.setAlbum(ab1);
		so12.setAlbum(ab1);
		
		Album ab2 = new Album("Greatest Hits", Category.MUSIC, 9.99, Platform.DIGITAL, MusicType.ALBUM, "Guns n Roses", "Rock");
		
		Song so13 = new Song("Welcome to the Jungle", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so14 = new Song("Sweet Child O' Mine", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so15 = new Song("Patience", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so16 = new Song("Paradise City", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so17 = new Song("Knockin' on Heaven's Door", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so18 = new Song("Civil War", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so19 = new Song("You Could Be Mine", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so20 = new Song("Don't Cry (original)", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so21 = new Song("November Rain", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so22 = new Song("Live and Let Die", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so23 = new Song("Yesterdays", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so24 = new Song("Ain't It Fun", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so25 = new Song("Since I Don't Have You", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		Song so26 = new Song("Sympathy for the Devil", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
		so13.setAlbum(ab2);
		so14.setAlbum(ab2);
		so15.setAlbum(ab2);
		so16.setAlbum(ab2);
		so17.setAlbum(ab2);
		so18.setAlbum(ab2);
		so19.setAlbum(ab2);
		so20.setAlbum(ab2);
		so21.setAlbum(ab2);
		so22.setAlbum(ab2);
		so23.setAlbum(ab2);
		so24.setAlbum(ab2);
		so25.setAlbum(ab2);
		so26.setAlbum(ab2);
			
		Album ab3 = new Album("Empoeror of Sand", Category.MUSIC, 15.00, Platform.DIGITAL, MusicType.ALBUM, "Mastodon", "Rock"); 
		
		Song so27 = new Song("Sultan's Curse", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so28 = new Song("Show Yourself", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so29 = new Song("Precious Stones", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so30 = new Song("Steambreather", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so31 = new Song("Roots Remain", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so32 = new Song("Word to the Wise", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so33 = new Song("Ancient Kingdom", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so34 = new Song("Clandestiny", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so35 = new Song("Andromeda", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so36 = new Song("Scorpion Breath", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		Song so37 = new Song("Jaguar God", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Mastodon", "Heavy Metal");
		
		List<Song> songs = Arrays.asList(so1, so2, so3, so4, so5, so6, so7, so8, so9, so10, so11, so12,
				so13, so14, so15, so16, so17, so18, so19, so20, so21, so22, so23, so24, so25, so26, so27, so28, so29, so30, so31,
				so32, so33, so34, so35, so36, so37);
		
		
		mr.save(ab1);
		mr.save(ab2);
		mr.save(ab3);
		mr.saveAll(songs);
		
		}
}

