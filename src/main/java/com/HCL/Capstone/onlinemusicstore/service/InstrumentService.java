package com.HCL.Capstone.onlinemusicstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.*;
import com.HCL.Capstone.onlinemusicstore.repository.*;


@Service
public class InstrumentService {
	
	@Autowired
	 private InstrumentRepository instrumentRepository;
	
	

    public Iterable<Instrument> GetAllInstruments()
    {
        return instrumentRepository.findAll();
    }


    public Instrument GetInstrumentByName(String name) {
        Instrument foundUser = instrumentRepository.findByName(name);
        return foundUser;
    }
    
    public void DeleteInstrument(Instrument InstrumenttoUpdate) {
    	instrumentRepository.delete(InstrumenttoUpdate);
    }
    
    public void UpdateInstrument(Instrument InstrumenttoUpdate) {
    	instrumentRepository.save(InstrumenttoUpdate);
    }


}