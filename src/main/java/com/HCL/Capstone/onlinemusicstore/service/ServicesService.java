package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicStore.entities.*;
import com.example.MusicStore.repository.*;


@Service
public class ServicesService {
	
	@Autowired
	 private servicesRepository ServicesRepository;
	
	

    public Iterable<Services> GetAllServices()
    {
        return ServicesRepository.findAll();
    }


    public Services GetServiceByName(String name) {
    	Services foundUser = ServicesRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteServices(Services ServicestoUpdate) {
    	ServicesRepository.delete(ServicestoUpdate);
    }
    
    public void UpdateServices(Services ServicestoUpdate) {
    	ServicesRepository.save(ServicestoUpdate);
    }


}