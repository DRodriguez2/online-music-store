package com.HCL.Capstone.onlinemusicstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.entity.enums.Category;
import com.HCL.Capstone.onlinemusicstore.entity.enums.MusicType;
import com.HCL.Capstone.onlinemusicstore.exceptions.AccessoryNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.MusicNotFoundException;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class AccessoryService {
	
	@Autowired
	 private AccessoryRepository accessoryRepository;
	
	
	public Accessory findAccessoryById(Long id) {
		Optional<Accessory> accessory = accessoryRepository.findById(id);
		if(accessory.isPresent()) return accessory.get();
		else return null;
	}

	public List<Accessory> getAllAccessories() {
		return accessoryRepository.findAll();
	}
	
    public Iterable<Accessory> GetAllAccessories()
    {
        return accessoryRepository.findAll();
    }

    public Accessory GetAccessoryByName(String name) throws ProductNotFoundException {
		Accessory item = accessoryRepository.findByName(name);
		if(item != null) return item;
		else throw new ProductNotFoundException();
    	
    }
    public List<Accessory> findAllByNameContainsIgnoreCase(String input) throws ProductNotFoundException {
		Optional<List<Accessory>> products = accessoryRepository.findAllByNameContainsIgnoreCase(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
	}

    public List<Accessory> findAllByBrandContainsIgnoreCase(String input) throws ProductNotFoundException {
		Optional<List<Accessory>> products = accessoryRepository.findAllByBrandContainsIgnoreCase(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
    }

    public List<Accessory> findAllByCategory(Category input) throws ProductNotFoundException {
		Optional<List<Accessory>> products = accessoryRepository.findAllByCategory(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
    }
		
    public void DeleteAccessory(Accessory AccessorytoUpdate) {
    	accessoryRepository.delete(AccessorytoUpdate);
    }
    
    public void UpdateAccessory(Accessory AccessorytoUpdate) {
    	accessoryRepository.save(AccessorytoUpdate);
    }


}