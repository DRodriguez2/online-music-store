package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class MusicService {
	
	@Autowired
	 private MusicRepository musicRepository;
	
	

    public Iterable<Music> GetAllMusic()
    {
        return musicRepository.findAll();
    }


    public Music GetMusicByName(String name) {
    	Music foundUser = musicRepository.findMusicByName(name);
        return foundUser;
    }
    
    public void DeleteMusic(Music MusictoUpdate) {
    	musicRepository.delete(MusictoUpdate);
    }
    
    public void UpdateMusic(Music MusictoUpdate) {
    	musicRepository.save(MusictoUpdate);
    }


}