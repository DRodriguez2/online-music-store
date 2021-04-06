package com.HCL.Capstone.onlinemusicstore;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;
import com.HCL.Capstone.onlinemusicstore.repository.InstrumentRepository;
import com.HCL.Capstone.onlinemusicstore.repository.MusicRepository;

@SpringBootTest(classes = OnlineMusicStoreApplication.class)
class OnlineMusicStoreApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired EntityManager em;
	@Autowired MusicRepository mr;
	@Autowired InstrumentRepository im;
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		
		Album album = new Album("Greatest Hits", Category.MUSIC, 9.99, Platform.DIGITAL, MusicType.ALBUM, "Guns n Roses", "Rock");
		mr.save(album);
		Song song = (Song) mr.findMusicByName("Welcome to the Jungle");
		song.addAlbum(album);
		album.addSong(song);
		logger.info(song.getAlbums().toString());
		logger.info(album.getSongs().toString());
		
	}

}
