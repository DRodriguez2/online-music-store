package com.HCL.Capstone.onlinemusicstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HCL.Capstone.onlinemusicstore.entity.Accessory;
import com.HCL.Capstone.onlinemusicstore.entity.Instrument;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.entity.Services;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.repository.AccessoryRepository;
import com.HCL.Capstone.onlinemusicstore.repository.InstrumentRepository;
import com.HCL.Capstone.onlinemusicstore.repository.MusicRepository;
import com.HCL.Capstone.onlinemusicstore.repository.ProductRepository;
import com.HCL.Capstone.onlinemusicstore.repository.ServiceRepository;

@SpringBootApplication
public class OnlineMusicStoreApplication implements CommandLineRunner {

	@Autowired private ProductRepository productRepo;
	@Autowired private InstrumentRepository instrumentRepo;
	@Autowired private ServiceRepository serviceRepo;
	@Autowired private AccessoryRepository accessoryRepo;
	//@Autowired private MusicRepository musicRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineMusicStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product("Song 1", Category.MUSIC, 1.99);
		Product p2 = new Product("Headphones", Category.ACCESSORIES, 59.99);
		
		Instrument i1  = new Instrument("Fender Guitar", Category.INSTRUMENT, 299.00, "Percussion", "Fender");
		
		Services s1 = new Services("Service1", Category.SERVICE, 49.99, "Instrument Repair");
		
		Accessory a1 = new Accessory("Accessory1", Category.ACCESSORIES, 149.99, "Headphones", "Audio Technica");
		
//		Song so1 = new Song("Welcome to the Jungle", Category.MUSIC, 1.99, Platform.DIGITAL, MusicType.SONG, "Guns n Roses", "Rock");
//		
//		Album ab1 = new Album("Appetite for Destruction", Category.MUSIC, 9.99, Platform.DIGITAL, MusicType.ALBUM, "Guns n Roses", "Rock");


		
		productRepo.save(p1);
		productRepo.save(p2);
		
		instrumentRepo.save(i1);
		
		serviceRepo.save(s1);
		
		accessoryRepo.save(a1);
		
//		musicRepo.save(so1);
//		musicRepo.save(ab1);
		
		
	}

}
