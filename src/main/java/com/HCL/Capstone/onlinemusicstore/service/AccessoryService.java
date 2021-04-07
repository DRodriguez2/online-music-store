package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class AccessoryService {
	
	@Autowired
	 private AccessoryRepository accessoryRepository;
	
	

    public Iterable<Accessory> GetAllAccessories()
    {
        return accessoryRepository.findAll();
    }


    public Accessory GetAccessoryByName(String name) {
    	Accessory foundUser = accessoryRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteAccessory(Accessory AccessorytoUpdate) {
    	accessoryRepository.delete(AccessorytoUpdate);
    }
    
    public void UpdateAccessory(Accessory AccessorytoUpdate) {
    	accessoryRepository.save(AccessorytoUpdate);
    }


}