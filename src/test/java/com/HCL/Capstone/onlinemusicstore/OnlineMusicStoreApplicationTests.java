package com.HCL.Capstone.onlinemusicstore;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.HCL.Capstone.onlinemusicstore.repository.InstrumentRepository;
import com.HCL.Capstone.onlinemusicstore.repository.MusicRepository;

@SpringBootTest(classes = OnlineMusicStoreApplication.class)
class OnlineMusicStoreApplicationTests {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired EntityManager em;
	@Autowired MusicRepository mr;
	@Autowired InstrumentRepository im;
	
	@Test
	@Transactional
	public void basicTesting() {
		

		
	}

}
