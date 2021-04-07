package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class AlbumService {
	
	@Autowired
	 private AlbumRepository AlbumRepository;
	
	

    public Iterable<Album> GetAllAlbums()
    {
        return AlbumRepository.findAll();
    }


    public Album GetAlbumByName(String name) {
    	Album foundUser = AlbumRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteAlbum(Album AlbumtoUpdate) {
    	AlbumRepository.delete(AlbumtoUpdate);
    }
    
    public void UpdateAlbum(Album AlbumtoUpdate) {
    	AlbumRepository.save(AlbumtoUpdate);
    }


}