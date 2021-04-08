package com.HCL.Capstone.onlinemusicstore.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.exceptions.ProductNotFoundException;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class ServicesService {
	
	@Autowired
	 private ServiceRepository serviceRepository;
	
	

    public Iterable<Services> GetAllServices()
    {
        return serviceRepository.findAll();
    }
    
    public List<Services> findAllByNameContainsIgnoreCase(String input) throws ProductNotFoundException {
		Optional<List<Services>> products = serviceRepository.findAllByNameContainsIgnoreCase(input);
		if(products.isPresent()) return products.get();
		else throw new ProductNotFoundException();
	}
    
    public Services GetServiceByName(String name) throws ProductNotFoundException {
    	Services item = serviceRepository.findByName(name);
		if(item != null) return item;
		else throw new ProductNotFoundException();
    }
    
    public void DeleteServices(Services ServicestoUpdate) {
    	serviceRepository.delete(ServicestoUpdate);
    }
    
    public void UpdateServices(Services ServicestoUpdate) {
    	serviceRepository.save(ServicestoUpdate);
    }


}