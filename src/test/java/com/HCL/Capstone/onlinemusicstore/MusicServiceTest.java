package com.HCL.Capstone.onlinemusicstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;

@SpringBootTest(classes = OnlineMusicStoreApplication.class)
class MusicServiceTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MusicService ms;

	@Test
	@Transactional
	public void test() throws MusicNotFoundException {
		List<Album> albums = ms.getAllAlbumByNameContaining("A");
		Album a = (Album) albums.get(0);
		logger.info("Album Name: " + a.getName());
		logger.info("Album Songs: " + a.getSongs());
	}

//	@Test
//	@Transactional
//	public void findAlbum() {
//		String albumName = "Appetite for Destruction";
//		try {
//			Music music = ms.getMusicByNameAndType(albumName, MusicType.ALBUM);
//			assertEquals(music.getName(), albumName);
//		} catch(MusicNotFoundException e) {
//			fail();
//		}
//	}
//
//	@Test
//	@Transactional
//	public void getAllSongs() {
//		List<Song> allSongs;
//		try {
//			allSongs = ms.getAllSongs();
//			logger.info(allSongs.toString());
//		} catch (NoSongsInDatabaseException e) {
//			fail();
//		}
//	}
//
//	@Test
//	@Transactional
//	public void getAllAlbums() {
//		List<Album> allAlbums;
//		try {
//			allAlbums = ms.getAllAlbums();
//			logger.info(allAlbums.toString());
//		} catch (NoAlbumsInDatabaseException e) {
//			fail();
//		}
//
//	}
//	
//	@Test
//	@Transactional
//	public void getAlbumContaining() {
//		List<Album> allAlbums;
//		try {
//			allAlbums = ms.getAllAlbumByNameContaining("tru");
//			logger.info("All albums continaing 'tru' " + allAlbums.toString());
//			logger.info("All songs on the album: " + allAlbums.get(0).getSongs().toString());
//		} catch (MusicNotFoundException e) {
//			fail();
//		}
//
//	}
//	
//	@Test
//	@Transactional
//	public void getSongContaining() {
//		List<Song> allSongs;
//		try {
//			allSongs = ms.getAllSongsByNameContaining("w");
//			logger.info("All songs continaing 'w' " + allSongs.toString());
//			Song song = allSongs.get(0);
//			logger.info("first song: " + song.toString());
//		} catch (MusicNotFoundException e) {
//			fail();
//		}
//	}
//	
//	@Test
//	@Transactional
//	public void getAllGenres() {
//		List<String> allGenres;
//		allGenres = ms.getAllGenres();
//		logger.info("All genres: " + allGenres.toString());
//
//	}

}
