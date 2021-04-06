package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MusicStore.entities.*;
import com.example.MusicStore.repository.instumentRepository;


@Service
public class InstrumentService {
	
	@Autowired
	 private instumentRepository InstumentRepository;
	
	

    public Iterable<Instrument> GetAllInstruments()
    {
        return InstumentRepository.findAll();
    }


    public Instrument GetInstrumentByName(String name) {
        Instrument foundUser = InstumentRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteInstrument(Instrument InstrumenttoUpdate) {
    	InstumentRepository.delete(InstrumenttoUpdate);
    }
    
    public void UpdateInstrument(Instrument InstrumenttoUpdate) {
    	InstumentRepository.save(InstrumenttoUpdate);
    }


}