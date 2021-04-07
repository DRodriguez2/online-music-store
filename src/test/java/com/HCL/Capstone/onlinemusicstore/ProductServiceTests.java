package com.HCL.Capstone.onlinemusicstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.HCL.Capstone.onlinemusicstore.entity.Album;
import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.exceptions.NoAlbumsInDatabaseException;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.service.MusicService;
import com.HCL.Capstone.onlinemusicstore.service.ProductService;

@SpringBootTest(classes = OnlineMusicStoreApplication.class)
class ProductServiceTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired ProductService ps;
	
	@Autowired MusicService ms;
	

	
//	@Test
//	@Transactional
//	public void getAllProducts() {
//		List<Product> products;
//		products = ps.getAllProducts();
//		logger.info("All products: " + products.toString());
//
//	}
	
	@Test
	@Transactional
	public void deleteProduct() throws ProductNotFoundException, NoAlbumsInDatabaseException {
		Product songSweetChild = ps.getProductById(107L);
		ps.deleteProduct(songSweetChild);
		
		List<Album> albums = ms.getAllAlbums();
		Album a1 = albums.get(0);
		Album a2 = albums.get(1);
		logger.info("Album 1: " + a1.getSongs());
		logger.info("Album 2: " + a2.getSongs());


	}
	

}
