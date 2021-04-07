package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class ServicesService {
	
	@Autowired
	 private ServiceRepository serviceRepository;
	
	

    public Iterable<Services> GetAllServices()
    {
        return serviceRepository.findAll();
    }


    public Services GetServiceByName(String name) {
    	Services foundUser = serviceRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteServices(Services ServicestoUpdate) {
    	serviceRepository.delete(ServicestoUpdate);
    }
    
    public void UpdateServices(Services ServicestoUpdate) {
    	serviceRepository.save(ServicestoUpdate);
    }


}