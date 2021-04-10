package com.HCL.Capstone.onlinemusicstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.entity.Song;
import com.HCL.Capstone.onlinemusicstore.entity.User;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Platform;
import com.HCL.Capstone.onlinemusicstore.repository.AccessoryRepository;
import com.HCL.Capstone.onlinemusicstore.repository.InstrumentRepository;
import com.HCL.Capstone.onlinemusicstore.repository.MusicRepository;
import com.HCL.Capstone.onlinemusicstore.repository.ProductRepository;
import com.HCL.Capstone.onlinemusicstore.repository.ServiceRepository;
import com.HCL.Capstone.onlinemusicstore.service.UserService;

@SpringBootApplication
public class OnlineMusicStoreApplication implements CommandLineRunner {

	@Autowired private ProductRepository productRepo;
	@Autowired private InstrumentRepository instrumentRepo;
	@Autowired private ServiceRepository serviceRepo;
	@Autowired private AccessoryRepository accessoryRepo;
	@Autowired private UserService userService;
	@Autowired private MusicRepository musicRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineMusicStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Instrument i1  = new Instrument("Fender Guitar", Category.INSTRUMENT, 299.00, "Percussion", "Fender");
		
		Services s1 = new Services("Service1", Category.SERVICE, 49.99, "Instrument Repair");
		
		Accessory a1 = new Accessory("Accessory1", Category.ACCESSORIES, 149.99, "Audio Technica", "Headphones");
		
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

		List<Song> songs = Arrays.asList(so1, so2, so3, so4, so5, so6, so7, so8, so9, so10, so11, so12,
				so13, so14, so15, so16, so17, so18, so19, so20, so21, so22, so23, so24, so25, so26);
		
		instrumentRepo.save(i1);
		
		serviceRepo.save(s1);
		
		accessoryRepo.save(a1);	
		
		musicRepo.save(ab1);
		musicRepo.save(ab2);
		musicRepo.saveAll(songs);
		User user = new User("user", "password", "ROLE_USER", 1111);
		User admin = new User("admin", "password", "ROLE_ADMIN", 1111);
		
		userService.createUser(user);
		userService.createUser(admin);
		
		
	}

}
