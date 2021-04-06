package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicStore.entities.*;
import com.example.MusicStore.repository.*;


@Service
public class AccessoryService {
	
	@Autowired
	 private accessoryRepository AccessoryRepository;
	
	

    public Iterable<Accessory> GetAllAccessories()
    {
        return AccessoryRepository.findAll();
    }


    public Accessory GetAccessoryByName(String name) {
    	Accessory foundUser = AccessoryRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteAccessory(Accessory AccessorytoUpdate) {
    	AccessoryRepository.delete(AccessorytoUpdate);
    }
    
    public void UpdateAccessory(Accessory AccessorytoUpdate) {
    	AccessoryRepository.save(AccessorytoUpdate);
    }


}