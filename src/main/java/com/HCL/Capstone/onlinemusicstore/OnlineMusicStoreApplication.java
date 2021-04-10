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

		Product p1 = new Product("Song 1", Category.MUSIC, 1.99);
		Product p2 = new Product("Headphones", Category.ACCESSORIES, 59.99);
								
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
		
		Instrument i1  = new Instrument("Fender Guitar", Category.INSTRUMENT, 299.00, "Percussion", "Fender");
		Instrument i2  = new Instrument("Yamaha Guitar", Category.INSTRUMENT, 199.00, "Percussion", "Yamaha");
		Instrument i3  = new Instrument("Gibson Guitar", Category.INSTRUMENT, 800.00, "Percussion", "Gibson");
		Instrument i4  = new Instrument("Seagull Guitar", Category.INSTRUMENT, 450.00, "Percussion", "Seagull");
		Instrument i5  = new Instrument("Ovation Guitar", Category.INSTRUMENT, 299.00, "Percussion", "Ovation");
		Instrument i6  = new Instrument("Washburn Guitar", Category.INSTRUMENT, 369.00, "Percussion", "Washburn");
		Instrument i7  = new Instrument("Epiphone Guitar", Category.INSTRUMENT, 249.00, "Percussion", "Epiphone");
		Instrument i8  = new Instrument("Yamaho Console Piano", Category.INSTRUMENT, 1995.00, "Key", "Yamaho");
		Instrument i9  = new Instrument("Donner Digital Piano", Category.INSTRUMENT, 570.00, "Key", "Donner");
		Instrument i10 = new Instrument("Wurlitzer Consule Piano", Category.INSTRUMENT, 1799.00, "Key", "Wurlitzer");
		Instrument i11 = new Instrument("Steinway and Sons Grand Piano", Category.INSTRUMENT, 35000.00, "Key", "Steinway");
		Instrument i12 = new Instrument("Roland AE-05 Aerophone", Category.INSTRUMENT, 499.00, "Woodwind", "Roland");
		Instrument i13 = new Instrument("Etude Student Clarinet", Category.INSTRUMENT, 259.00, "Woodwind", "Etude");
		Instrument i14 = new Instrument("Muslady CKey Bassoon", Category.INSTRUMENT, 849.00, "Woodwind", "Muslady");
		Instrument i15 = new Instrument("Etude Model Flute", Category.INSTRUMENT, 264.00, "Woodwind", "Etude");
		Instrument i16 = new Instrument("Mandinnini Saxophone", Category.INSTRUMENT, 179.00, "Woodwind", "Mandinnini");
		Instrument i17 = new Instrument("Hans Hoyer Triple Horn", Category.INSTRUMENT, 18919.00, "Brass", "Hans");
		Instrument i18 = new Instrument("Levante Bb Horn", Category.INSTRUMENT, 419.00, "Brass", "Levante");
		Instrument i19 = new Instrument("Yamaha Euphonium", Category.INSTRUMENT, 299.00, "Brass", "Yamaha");
		Instrument i20 = new Instrument("Monoprice Metal Kazoo", Category.INSTRUMENT, 5.00, "Brass", "Monoprice");
		instrumentRepo.save(i1);
		instrumentRepo.save(i2);
		instrumentRepo.save(i3);
		instrumentRepo.save(i4);
		instrumentRepo.save(i5);
		instrumentRepo.save(i6);
		instrumentRepo.save(i7);
		instrumentRepo.save(i8);
		instrumentRepo.save(i9);
		instrumentRepo.save(i10);
		instrumentRepo.save(i11);
		instrumentRepo.save(i12);
		instrumentRepo.save(i13);
		instrumentRepo.save(i14);
		instrumentRepo.save(i15);
		instrumentRepo.save(i16);
		instrumentRepo.save(i17);
		instrumentRepo.save(i18);
		instrumentRepo.save(i19);
		instrumentRepo.save(i20);

		Services s1 = new Services("Repairs", Category.SERVICE, 49.99, "Instrument Repair");
		Services s2 = new Services("Guitar Lessons", Category.SERVICE, 59.99, "Guitar Lessons for One Month");
		Services s3 = new Services("Brass Lessons", Category.SERVICE, 49.99, "Brass Lessons for One Month");
		Services s4 = new Services("Woodwind Lessons", Category.SERVICE, 39.99, "Woodwind Lessons for One Month");
		Services s5 = new Services("Piano Lessons", Category.SERVICE, 65.99, "Piano Lessons for One Month");
		Services s6 = new Services("Singing Lessons", Category.SERVICE, 59.99, "Singing Lessons for One Month");
		serviceRepo.save(s1);
		serviceRepo.save(s2);
		serviceRepo.save(s3);
		serviceRepo.save(s4);
		serviceRepo.save(s5);
		serviceRepo.save(s6);
		
		Accessory a1 = new Accessory("Audio Technica Headphones", Category.ACCESSORIES, 149.99, "Headphones", "Audio Technica");
		Accessory a2 = new Accessory("Bose Noise Cancelling Headphones", Category.ACCESSORIES, 279.99, "Headphones", "Audio bose");
		Accessory a3 = new Accessory("Apple AirPods Pro", Category.ACCESSORIES, 229.99, "Headphones", "Apple");
		Accessory a4 = new Accessory("Sony Wireless Earbuds", Category.ACCESSORIES, 229.99, "Headphones", "Sony");
		Accessory a5 = new Accessory("Beats Solo Wirless Headphones", Category.ACCESSORIES, 241.99, "Headphones", "Beats");
		Accessory a6 = new Accessory("Rode Microphone", Category.ACCESSORIES, 229.99, "Mic", "Rode");
		Accessory a7 = new Accessory("Shure Dynamic Microphone", Category.ACCESSORIES, 399.99, "Mic", "Shure");
		Accessory a8 = new Accessory("Neumann Microphone", Category.ACCESSORIES, 699.99, "Mic", "Neumann");
		Accessory a9 = new Accessory("Aston Microphone", Category.ACCESSORIES, 299.99, "Mic", "Aston");
		Accessory a10 = new Accessory("Blue Yeti Microphone", Category.ACCESSORIES, 129.99, "Mic", "Blue Yeti");
		Accessory a11 = new Accessory("Artiphon Orba Synthesizer", Category.ACCESSORIES, 99.99, "Mixer", "Artiphon");
		Accessory a12 = new Accessory("Native Instruments Machine MK3", Category.ACCESSORIES, 149.99, "Mixer", "Native Instruments");
		Accessory a13 = new Accessory("Korg Metronome", Category.ACCESSORIES, 19.99, "Item", "Korg");
		accessoryRepo.save(a1);	
		accessoryRepo.save(a2);	
		accessoryRepo.save(a3);	
		accessoryRepo.save(a4);	
		accessoryRepo.save(a5);	
		accessoryRepo.save(a6);	
		accessoryRepo.save(a7);	
		accessoryRepo.save(a8);	
		accessoryRepo.save(a9);	
		accessoryRepo.save(a10);	
		accessoryRepo.save(a11);	
		accessoryRepo.save(a12);	
		accessoryRepo.save(a13);	

		
		musicRepo.save(ab1);
		musicRepo.save(ab2);
		musicRepo.saveAll(songs);
		User user = new User("user", "password", "ROLE_USER", 1111);
		User admin = new User("admin", "password", "ROLE_ADMIN", 1111);
		
		userService.createUser(user);
		userService.createUser(admin);
		
		
	}

}
