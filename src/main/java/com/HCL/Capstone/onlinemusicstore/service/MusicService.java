package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicStore.entities.*;
import com.example.MusicStore.repository.*;


@Service
public class MusicService {
	
	@Autowired
	 private musicRepository MusicRepository;
	
	

    public Iterable<Music> GetAllMusic()
    {
        return MusicRepository.findAll();
    }


    public Music GetMusicByName(String name) {
    	Music foundUser = MusicRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteMusic(Music MusictoUpdate) {
    	MusicRepository.delete(MusictoUpdate);
    }
    
    public void UpdateMusic(Music MusictoUpdate) {
    	MusicRepository.save(MusictoUpdate);
    }


}